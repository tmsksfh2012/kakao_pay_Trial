package com.example.kakao_pay.src.main.manage.models

import com.google.gson.annotations.SerializedName

data class ResultSignUp(
        @SerializedName("userId") val userId: Int,
        @SerializedName("jwt") val jwt: String
)