package com.example.kakao_pay.src.login.register.input_email.models

import com.google.gson.annotations.SerializedName

data class PostEmailRequest(
    @SerializedName("email") val email: String
)