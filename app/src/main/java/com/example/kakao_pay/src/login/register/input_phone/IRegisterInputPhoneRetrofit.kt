package com.example.kakao_pay.src.login.register.input_phone

import com.example.kakao_pay.src.login.register.input_phone.models.PostPhoneRequest
import com.example.kakao_pay.src.login.register.input_phone.models.PostPhoneResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface IRegisterInputPhoneRetrofit {
    @POST("/phone/auth")
    fun postPhone(@Body phone: PostPhoneRequest) : Call<PostPhoneResponse>
}