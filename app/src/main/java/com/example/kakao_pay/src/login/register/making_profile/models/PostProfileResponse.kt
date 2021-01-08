package com.example.kakao_pay.src.login.register.making_profile.models

import com.google.gson.annotations.SerializedName

data class PostProfileResponse (
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String
)