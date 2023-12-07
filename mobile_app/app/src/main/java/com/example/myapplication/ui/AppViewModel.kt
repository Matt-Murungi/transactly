package com.example.myapplication.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.repository.AppRepository
import com.example.myapplication.models.UniversityModelItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val repository: AppRepository) : ViewModel() {

    private var _universities: MutableStateFlow<List<UniversityModelItem>> =
        MutableStateFlow(emptyList())
    val universities: StateFlow<List<UniversityModelItem>> get() = _universities
    var errorMessage: MutableState<String?> = mutableStateOf("")
    private var currentUniversity: MutableState<UniversityModelItem?> = mutableStateOf(null)

    init {
        fetchUgandanUniversities()
    }

    private fun fetchUgandanUniversities() {
        viewModelScope.launch {
            val result = repository.getUgandanUniversities()
            if (!result.data!!.isEmpty()) {
                _universities.value = result.data!!

            } else {
                errorMessage.value = result.e?.message
            }
        }
    }

    fun setCurrentSelectedUniversity(university: UniversityModelItem) {
        currentUniversity.value = university
    }

    fun getCurrentSelectedUniversity(): UniversityModelItem? {
        return currentUniversity.value;
    }
}