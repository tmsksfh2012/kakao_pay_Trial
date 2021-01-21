package com.example.kakao_pay.src.main.send.fragments.account

import com.example.kakao_pay.src.main.send.fragments.account.models.send_limit.Result
import com.google.gson.annotations.SerializedName

data class GetSendLimitResponse (
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : Result
)