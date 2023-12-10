package com.example.myapplication.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.Result
import com.example.myapplication.models.Transactions
import com.example.myapplication.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val repository: AppRepository) : ViewModel() {

    private val _transactions = MutableStateFlow<Transactions?>(Transactions(count = 0, next = "", previous = "", results = emptyList()))
    val transactions: StateFlow<Transactions?> = _transactions

    private val _filteredTransactions:MutableStateFlow<List<Result?>> =
        MutableStateFlow(emptyList())
    val filteredTransactions: StateFlow<List<Result?>> = _filteredTransactions

    var errorMessage: MutableState<String?> = mutableStateOf("")
    private var currentUniversity: MutableState<Transactions?> = mutableStateOf(null)
    private var selectedStartDate: MutableState<String> = mutableStateOf("")
    private var selectedEndDate: MutableState<String> = mutableStateOf("")
    private var showStartDateDialog: MutableState<Boolean> = mutableStateOf(false)
    init {
//        getAllTransactions()
        getFilteredTransactions()
    }

    fun setSelectedStartDate(date: String){
        selectedStartDate.value = date
    }
    fun setEndStartDate(date: String){
        selectedEndDate.value = date
    }

    private fun getAllTransactions() {
        viewModelScope.launch {
            val result = repository.fetchAllTransactions()
            if(result.data!!.toString().isNotBlank()){
                _transactions.value = result.data
            }
        }
    }

    private fun getFilteredTransactions() {
        viewModelScope.launch {
            val result = repository.fetchFilteredTransactions(null, null)
            if(result.hasData){
                _filteredTransactions.value = result.data!!
            }else{
//                errorMessage.value = result.e!!.toString()
            }
        }
    }
}