package com.example.kakao_pay.src.login.register.input_phone.certify_phone.models

import com.google.gson.annotations.SerializedName

data class GetPhoneRequest (
    @SerializedName("phone") val phone: String,
    @SerializedName("auth_number") val auth_number: String
)