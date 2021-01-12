package com.example.kakao_pay.src.login.register.input_email.certify_email.models

import com.google.gson.annotations.SerializedName

data class GetEmailResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("confirm") val confirm: String
)