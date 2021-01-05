package com.example.kakao_pay.src.login.register.email_input.models

import com.google.gson.annotations.SerializedName

data class PostEmailResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String
)