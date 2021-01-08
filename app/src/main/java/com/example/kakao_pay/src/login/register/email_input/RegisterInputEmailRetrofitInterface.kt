package com.example.kakao_pay.src.login.register.email_input

import com.example.kakao_pay.src.login.register.email_input.models.PostEmailRequest
import com.example.kakao_pay.src.login.register.email_input.models.PostEmailResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterInputEmailRetrofitInterface {
    @POST("/email/auth")
    fun postEmail(@Body email: PostEmailRequest) : Call<PostEmailResponse>
}