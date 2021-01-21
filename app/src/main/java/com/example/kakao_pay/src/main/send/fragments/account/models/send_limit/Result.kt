package com.example.kakao_pay.src.main.send.fragments.account.models.send_limit

import com.google.gson.annotations.SerializedName

data class Result (
    @SerializedName("remit_type") val remit_type : String,
    @SerializedName("count") val count : Int,
    @SerializedName("remit_limit") val remit_limit : String,
    @SerializedName("balance") val balance : Int
)