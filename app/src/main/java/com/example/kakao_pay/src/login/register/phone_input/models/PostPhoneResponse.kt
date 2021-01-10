package com.example.kakao_pay.src.login.register.phone_input.models

import com.google.gson.annotations.SerializedName

data class PostPhoneResponse (
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String
)