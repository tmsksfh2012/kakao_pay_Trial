package com.example.kakao_pay.src.main.send.fragments.account

import com.google.gson.annotations.SerializedName

data class GetSendLimitRequest(
    @SerializedName("account") val account: String?,
    @SerializedName("remit_type") val remit_type: String?
)
