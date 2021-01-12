package com.example.kakao_pay.src.login.register.input_email.certify_email.models

import com.google.gson.annotations.SerializedName

data class GetEmailRequest (
    @SerializedName("email") val email: String,
    @SerializedName("authNum") val authNum: String
)