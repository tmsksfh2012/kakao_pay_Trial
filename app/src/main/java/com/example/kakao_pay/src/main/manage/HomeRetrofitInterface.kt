package com.example.kakao_pay.src.main.manage

import com.example.kakao_pay.src.login.register.input_email.models.PostEmailResponse
import com.example.kakao_pay.src.main.manage.models.PostSignUpRequest
import com.example.kakao_pay.src.main.manage.models.SignUpResponse
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