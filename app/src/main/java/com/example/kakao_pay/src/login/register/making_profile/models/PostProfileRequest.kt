package com.example.kakao_pay.src.login.register.making_profile.models

import com.google.gson.annotations.SerializedName

data class PostProfileRequest (
    @SerializedName("email") val email : String,
    @SerializedName("password") val password : String,
    //@SerializedName("phone") val phone : String,
    @SerializedName("nickname") val nickname : String,
    @SerializedName("birthday") val birthday : String,
    @SerializedName("gender") val gender : String,
    @SerializedName("lunar_check") val lunar_check : Boolean
)