package com.example.kakao_pay.src.main.send.fragments.account.models

import com.google.gson.annotations.SerializedName

data class Bank (
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String
)