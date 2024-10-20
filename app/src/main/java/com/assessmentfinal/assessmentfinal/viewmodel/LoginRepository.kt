package com.assessmentfinal.assessmentfinal.viewmodel

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.assessmentfinal.assessmentfinal.api.ApiService
import com.assessmentfinal.assessmentfinal.models.DashboardResponse
import com.assessmentfinal.assessmentfinal.models.LoginRequest
import com.assessmentfinal.assessmentfinal.models.LoginResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(
    private val apiService: ApiService,
    @ApplicationContext private val context: Context
) {

    suspend fun login(username: String, password: String, location: String): Response<LoginResponse> {
        val loginRequest = LoginRequest(username, password)
        return apiService.login(location, loginRequest)
    }
    // New function to fetch dashboard data
    suspend fun getDashboardData(keypass: String): Response<DashboardResponse> {
        return apiService.getDashboardData(keypass)
    }
}