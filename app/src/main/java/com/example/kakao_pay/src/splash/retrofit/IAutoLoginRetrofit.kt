package com.example.kakao_pay.src.splash.retrofit

import com.example.kakao_pay.src.splash.models.GetAutoLoginResponse
import retrofit2.Call
import retrofit2.http.GET

interface IAutoLoginRetrofit {
    @GET("/auto-login")
    fun getAutoLogin() : Call<GetAutoLoginResponse>
}