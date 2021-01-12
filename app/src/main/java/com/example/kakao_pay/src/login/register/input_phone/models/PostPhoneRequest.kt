package com.example.kakao_pay.src.login.register.input_phone.models

import com.google.gson.annotations.SerializedName

data class PostPhoneRequest (
    @SerializedName("phone") val phone : String
)