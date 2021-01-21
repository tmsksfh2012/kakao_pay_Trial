package com.example.kakao_pay.src.login.register.input_email

import com.example.kakao_pay.src.login.register.input_email.models.PostEmailRequest
import com.example.kakao_pay.src.login.register.input_email.models.PostEmailResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface IRegisterInputEmailRetrofit {
    @POST("/email-auth")
    fun postEmail(@Body email: PostEmailRequest) : Call<PostEmailResponse>
}