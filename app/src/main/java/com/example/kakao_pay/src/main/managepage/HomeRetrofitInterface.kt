package com.example.kakao_pay.src.main.managepage

import com.example.kakao_pay.src.main.managepage.models.PostSignUpRequest
import com.example.kakao_pay.src.main.managepage.models.SignUpResponse
import com.example.kakao_pay.src.main.managepage.models.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface HomeRetrofitInterface {
    @GET("/users")
    fun getUsers() : Call<UserResponse>
    @POST("/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>
}