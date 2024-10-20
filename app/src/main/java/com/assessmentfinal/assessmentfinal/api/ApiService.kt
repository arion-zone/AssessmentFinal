package com.assessmentfinal.assessmentfinal.api

import com.assessmentfinal.assessmentfinal.models.LoginResponse
import com.assessmentfinal.assessmentfinal.models.DashboardResponse
import com.assessmentfinal.assessmentfinal.models.EntityDetails
import com.assessmentfinal.assessmentfinal.models.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.Call

interface ApiService {

    @POST("{location}/auth")
    suspend fun login(
        @Path("location") location: String,
        @Body credentials: LoginRequest
    ): Response<LoginResponse>


    // Adding dashboard function to your existing ApiService
    @GET("dashboard/{keypass}")
    suspend fun getDashboardData(@Path("keypass") keypass: String): Response<DashboardResponse>

}