package com.example.kakao_pay.src.login.register.input_email.certify_email

import com.example.kakao_pay.src.login.register.input_email.certify_email.models.GetEmailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRegisterCertifyEmailRetrofit {
    @GET("/email-auth")
    fun getEmail(
        @Query("email") email : String,
        @Query("auth_number") auth_number : String
    ) : Call<GetEmailResponse>
}