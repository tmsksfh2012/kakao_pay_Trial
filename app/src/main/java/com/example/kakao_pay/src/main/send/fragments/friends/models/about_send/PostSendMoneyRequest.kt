package com.example.kakao_pay.src.main.send.fragments.friends.models.about_send

import com.google.gson.annotations.SerializedName

data class PostSendMoneyRequest (
    @SerializedName("friend_number") val friend_number :Int?,
    @SerializedName("recipient") val recipient :String,
    @SerializedName("image") val image :String,
    @SerializedName("nickname") val nickname :String?,
    @SerializedName("remit_bank_name") val remit_bank_name :String?,
    @SerializedName("remit_account") val remit_account :String?,
    @SerializedName("payment_type") val payment_type :String,
    @SerializedName("amount") val amount :String,
    @SerializedName("remit_type") val remit_type :String,
)