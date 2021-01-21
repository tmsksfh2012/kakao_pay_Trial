package com.example.kakao_pay.src.main.send.models

import com.google.gson.annotations.SerializedName

data class PostBookMarkRequest (
        @SerializedName("friend_number") val friend_number : Int?,
        @SerializedName("account") val account : String?,
        @SerializedName("remit_type") val remit_type : String,
        @SerializedName("book_mark") val book_mark : String
)