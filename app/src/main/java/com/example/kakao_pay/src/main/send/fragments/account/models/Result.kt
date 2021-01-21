package com.example.kakao_pay.src.main.send.fragments.account.models

import com.google.gson.annotations.SerializedName

data class Result (
    @SerializedName("bank_list") val bank_list : ArrayList<Bank>,
    @SerializedName("share_list") val share_list : ArrayList<Bank>
)