package com.example.kakao_pay.src.main.send.models.recentList

import com.google.gson.annotations.SerializedName

data class Recent (
    @SerializedName("id") val id : Int,
    @SerializedName("friend_number") val friend_number : Int?,
    @SerializedName("image") val image : String,
    @SerializedName("name") val name : String,
    @SerializedName("bank_name") val bank_name : String?,
    @SerializedName("account") val account : String?,
    @SerializedName("book_mark") val book_mark : String,
    @SerializedName("nickname") val nickname : String?,
    @SerializedName("remit_type") val remit_type : String
)