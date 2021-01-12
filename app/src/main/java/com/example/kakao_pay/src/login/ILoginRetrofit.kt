package com.example.kakao_pay.src.login

import com.example.kakao_pay.src.login.models.PostLoginRequest
import com.example.kakao_pay.src.login.models.PostLoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ILoginRetrofit {
    @POST("/users/login")
    fun postLogin(@Body email : PostLoginRequest) : Call<PostLoginResponse>
}