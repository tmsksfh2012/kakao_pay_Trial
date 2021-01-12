package com.example.kakao_pay.src.main.sendpage.models

import com.google.gson.annotations.SerializedName

data class User (
        @SerializedName("friend_number") val friend_number : Int,
        @SerializedName("user_image") val user_image : String,
        @SerializedName("name") val name : String,
        @SerializedName("nickname") val nickname : String,
        @SerializedName("book_mark") val book_mark : String,
        @SerializedName("remit_type") val remit_type : String
)