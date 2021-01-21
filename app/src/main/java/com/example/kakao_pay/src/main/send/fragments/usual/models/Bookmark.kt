package com.example.kakao_pay.src.main.send.fragments.usual.models

import com.google.gson.annotations.SerializedName

data class Bookmark (
        @SerializedName("friend_number") val friend_number : Int?,
        @SerializedName("image") val image : String,
        @SerializedName("name") val name : String,
        @SerializedName("bank_name") val bank_name : String?,
        @SerializedName("account") val account : String?,
        @SerializedName("nickname") val nickname : String?,
        @SerializedName("book_mark") val book_mark : String,
        @SerializedName("remit_type") val remit_type : String
)