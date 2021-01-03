package com.example.kakao_pay.src.main.managepage.models

import com.google.gson.annotations.SerializedName

data class ResultUser (
    @SerializedName("userId") val userId: Int,
    @SerializedName("email") val email: String
)