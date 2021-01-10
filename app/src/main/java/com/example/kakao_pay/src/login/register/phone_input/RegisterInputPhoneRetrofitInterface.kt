package com.example.kakao_pay.src.login.register.phone_input

import com.example.kakao_pay.src.login.register.phone_input.models.PostPhoneRequest
import com.example.kakao_pay.src.login.register.phone_input.models.PostPhoneResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterInputPhoneRetrofitInterface {
    @POST("/phone/auth")
    fun postPhone(@Body phone: PostPhoneRequest) : Call<PostPhoneResponse>
}