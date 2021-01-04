package com.example.kakao_pay.src.login.models

import android.telephony.TelephonyManager
import com.google.gson.annotations.SerializedName

data class PostSignUpRequest (
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("nickname") val nickname: String
)