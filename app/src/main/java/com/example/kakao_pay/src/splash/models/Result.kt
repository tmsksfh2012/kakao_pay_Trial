package com.example.kakao_pay.src.splash.models

import com.google.gson.annotations.SerializedName

data class Result (
    @SerializedName("email") val email : String,
    @SerializedName("name") val name : String,
    @SerializedName("phone") val phone : String,
    @SerializedName("birth") val birthday : String
)