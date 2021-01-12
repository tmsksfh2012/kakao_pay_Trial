package com.example.kakao_pay.src.login.register.input_phone.certify_phone.models

import com.google.gson.annotations.SerializedName

data class GetPhoneResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("confirm") val confirm: String
)