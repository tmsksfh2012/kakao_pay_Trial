package com.example.kakao_pay.src.login.register.input_phone.certify_phone

import com.example.kakao_pay.src.login.register.input_phone.certify_phone.models.GetPhoneResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRegisterCertifyPhoneRetrofit {
    @GET("/phone-auth")
    fun getPhone(
        @Query("phone") phone : String,
        @Query("auth_number") auth_number : String
    ) : Call<GetPhoneResponse>
}