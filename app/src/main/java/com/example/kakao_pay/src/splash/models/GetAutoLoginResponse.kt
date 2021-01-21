package com.example.kakao_pay.src.splash.models

import com.google.gson.annotations.SerializedName

data class GetAutoLoginResponse (
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result : Result?
)