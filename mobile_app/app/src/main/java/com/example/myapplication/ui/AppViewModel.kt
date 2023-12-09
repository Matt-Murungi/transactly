package com.example.myapplication.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.TransactionHistory
import com.example.myapplication.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val repository: AppRepository) : ViewModel() {

    private var _transactions: MutableStateFlow<List<TransactionHistory>> =
        MutableStateFlow(emptyList())
    val transactios: StateFlow<List<TransactionHistory>> get() = _transactions
    var errorMessage: MutableState<String?> = mutableStateOf("")
    private var currentUniversity: MutableState<TransactionHistory?> = mutableStateOf(null)
    private var selectedStartDate: MutableState<String> = mutableStateOf("")
    private var selectedEndDate: MutableState<String> = mutableStateOf("")
    private var showStartDateDialog: MutableState<Boolean> = mutableStateOf(false)
    init {
        getAllTransactions()
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
            Log.d("View model", "fetchUgandanUniversities: $result")

        }
    }


}