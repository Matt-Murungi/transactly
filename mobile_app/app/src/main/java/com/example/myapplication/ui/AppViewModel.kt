package com.example.myapplication.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.Result
import com.example.myapplication.models.Transactions
import com.example.myapplication.repository.AppRepository
import com.example.myapplication.ui.theme.BarGraphColor
import com.example.myapplication.ui.utils.formatThousandSeparator
import com.github.tehras.charts.bar.BarChartData
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.N)
@HiltViewModel
class AppViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: AppRepository
) : ViewModel() {

    private val _transactions = MutableStateFlow<Transactions?>(
        null
    )
    val transactions: StateFlow<Transactions?> = _transactions
    var selectedTransaction: MutableState<Result?> = mutableStateOf(null)
    private val _filteredTransactions: MutableStateFlow<List<Result?>> =
        MutableStateFlow(emptyList())
    val filteredTransactions: StateFlow<List<Result?>> = _filteredTransactions

    private val _isConnected: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isConnected: StateFlow<Boolean> = _isConnected

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage
    val showError: MutableState<Boolean> = mutableStateOf(false)

    var selectedStartDate: MutableState<String?> = mutableStateOf(null)
    var selectedEndDate: MutableState<String?> = mutableStateOf(null)
    private var showStartDateDialog: MutableState<Boolean> = mutableStateOf(false)

    private val _transactionsByCategory: MutableStateFlow<List<BarChartData.Bar>> =
        MutableStateFlow(emptyList())
    val transactionsByCategory: StateFlow<List<BarChartData.Bar>> = _transactionsByCategory

    private val _transactionsByType: MutableStateFlow<List<BarChartData.Bar>> =
        MutableStateFlow(emptyList())
    val transactionByType: StateFlow<List<BarChartData.Bar>> = _transactionsByType

    private val _transactionsByService: MutableStateFlow<List<BarChartData.Bar>> =
        MutableStateFlow(emptyList())
    val transactionsByService: StateFlow<List<BarChartData.Bar>> = _transactionsByService


    var totalTransactionsAmount: MutableState<String> = mutableStateOf("")
    var numberOfTransactions: MutableState<String> = mutableStateOf("")

    var isLoading: MutableState<Boolean> = mutableStateOf(false)
    var showDialog: MutableState<Boolean> = mutableStateOf(false)
    var showTransactionHistoryDialog: MutableState<Boolean> = mutableStateOf(false)
    var showCalendar: MutableState<Boolean> = mutableStateOf(false)
    var calendarType: MutableState<String> = mutableStateOf("")


    init {
        checkInternetConnection()
        getFilteredTransactions()
        getAllTransactions()
    }

    fun setSelectedStartDate(date: String) {
        selectedStartDate.value = date
    }

    fun setSelectedEndDate(date: String) {

        selectedEndDate.value = date
    }

    fun setCalendarType(calendar: String) {
        if (calendar == UIConstants.START_DATE_CALENDAR) {
            calendarType.value = UIConstants.START_DATE_CALENDAR
        } else {
            calendarType.value = UIConstants.END_DATE_CALENDAR
        }
    }


    private fun getAllTransactions() {
        viewModelScope.launch {
            val result = repository.fetchAllTransactions()
            if (result.hasData) {
                _transactions.value = result.data
            } else {
                _errorMessage.value = result.message
                showError.value = true
            }
        }
    }

    fun getPaginatedTransaction(url: String) {
        isLoading.value = true
        showError.value = false
        viewModelScope.launch {
            val result = repository.fetchPaginatedTransaction(url)
            if (result.hasData) {
                _transactions.value = result.data
            } else {
                _errorMessage.value = result.message
                showError.value = true
            }
        }
        isLoading.value = false
    }

    fun getFilteredTransactions() {

        isLoading.value = true
        showError.value = false
        viewModelScope.launch {

            val result =
                repository.fetchFilteredTransactions(selectedEndDate.value, selectedEndDate.value)

            if (result.hasData) {
                _filteredTransactions.value = result.data!!
                isLoading.value = false
                showCalendar.value = false
                showDialog.value = false
                selectedStartDate.value = null
                selectedEndDate.value = null
                generateCategoryTransactionData()
                calculateTotalAmount()
                calculateNumberOfTransactions()
                generateTransactionTypeData()
                generateTransactionServiceData()


            } else {
                _errorMessage.value = result.message
                showError.value = true
            }
        }
    }


    private fun generateBarGraphData(groupBy: (Result?) -> String): List<BarChartData.Bar> {
        val groupedByCategory = _filteredTransactions.value.groupBy(groupBy)
        val categorySums = groupedByCategory.map { (category, results) ->
            val sum = results.sumOf { it!!.amount }
            category to sum
        }

        return categorySums.map { (category, sum) ->
            BarChartData.Bar(label = category, value = sum.toFloat(), color = BarGraphColor)
        }
    }


    private fun generateCategoryTransactionData() {
        _transactionsByCategory.value = generateBarGraphData { it!!.category }
    }

    private fun generateTransactionTypeData() {
        _transactionsByType.value = generateBarGraphData { it!!.type }

    }

    private fun generateTransactionServiceData() {
        _transactionsByService.value = generateBarGraphData { it!!.service }

    }


    private fun calculateTotalAmount() {
        totalTransactionsAmount.value =
            formatThousandSeparator(_filteredTransactions.value.sumOf { it!!.amount })

    }

    fun calculateNumberOfTransactions() {
        numberOfTransactions.value = _filteredTransactions.value.size.toString()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun checkInternetConnection() {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.registerDefaultNetworkCallback(object :
            ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                _isConnected.value = true
            }

            override fun onLost(network: Network) {
                _isConnected.value = false
            }
        })

    }
}