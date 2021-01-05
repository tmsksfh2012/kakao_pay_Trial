package com.example.kakao_pay.src.main.managepage

import com.example.kakao_pay.src.login.register.email_input.models.PostEmailResponse
import com.example.kakao_pay.src.main.managepage.models.PostSignUpRequest
import com.example.kakao_pay.src.main.managepage.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface HomeRetrofitInterface {
    @GET("/users")
    fun getUsers() : Call<PostEmailResponse>
    @POST("/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>
}