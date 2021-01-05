package com.example.kakao_pay.src.login.register.email_input.email_certify.models

import com.google.gson.annotations.SerializedName

data class GetEmailRequest (
    @SerializedName("email") val email: String,
    @SerializedName("authNum") val authNum: String
)