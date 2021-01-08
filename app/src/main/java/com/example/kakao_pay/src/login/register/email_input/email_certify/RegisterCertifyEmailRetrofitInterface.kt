package com.example.kakao_pay.src.login.register.email_input.email_certify

import com.example.kakao_pay.src.login.register.email_input.email_certify.models.GetEmailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RegisterCertifyEmailRetrofitInterface {
    @GET("/email/auth")
    fun getEmail(
        @Query("email") email : String,
        @Query("auth_number") auth_number : String
    ) : Call<GetEmailResponse>
}