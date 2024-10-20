package com.assessmentfinal.assessmentfinal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessmentfinal.assessmentfinal.api.ApiService


import com.assessmentfinal.assessmentfinal.models.DashboardResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
// DashboardViewModel.kt
@HiltViewModel
class DashboardViewModel @Inject constructor(private val repository: LoginRepository) : ViewModel() {

    private val _dashboardData = MutableLiveData<DashboardResponse>()
    val dashboardData: LiveData<DashboardResponse> get() = _dashboardData

    fun fetchDashboardData(keypass: String) {
        viewModelScope.launch {
            try {
                val response = repository.getDashboardData(keypass)
                if (response.isSuccessful) {
                    _dashboardData.value = response.body()
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}