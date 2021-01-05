package com.example.kakao_pay.src.login.register.email_input.models

import com.google.gson.annotations.SerializedName

data class PostEmailRequest(
    @SerializedName("email") val email: String
)