package com.example.kakao_pay.src.login.register.phone_input.models

import com.google.gson.annotations.SerializedName

data class PostPhoneRequest (
    @SerializedName("phone") val phone : String
)