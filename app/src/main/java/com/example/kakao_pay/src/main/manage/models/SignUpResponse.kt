package com.example.kakao_pay.src.main.manage.models

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
        @SerializedName("isSuccess") val isSuccess: Boolean,
        @SerializedName("code") val code: Int,
        @SerializedName("message") val message: String,
        @SerializedName("result") val result: ResultSignUp
)