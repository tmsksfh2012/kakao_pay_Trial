package com.example.kakao_pay.src.login.register.making_profile

import com.example.kakao_pay.src.login.register.making_profile.models.PostProfileRequest
import com.example.kakao_pay.src.login.register.making_profile.models.PostProfileResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface IRegisterMakeProfileRetrofit {
    @POST("/users")
    fun postProfile(@Body profile : PostProfileRequest) : Call<PostProfileResponse>
}