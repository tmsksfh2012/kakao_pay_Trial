package com.example.kakao_pay.src.main.send.fragments.friends.models.about_send

import com.google.gson.annotations.SerializedName

data class Result (
    @SerializedName("remit_number") val remit_number : Int,
    @SerializedName("amount") val amount : String,
    @SerializedName("recipient") val recipient : String,
    @SerializedName("bank_account") val bank_account : Int,
    @SerializedName("balance") val balance : String,
)