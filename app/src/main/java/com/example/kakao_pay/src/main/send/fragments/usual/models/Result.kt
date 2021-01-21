package com.example.kakao_pay.src.main.send.fragments.usual.models

import com.google.gson.annotations.SerializedName

data class Result (
        @SerializedName("book_mark_list") val book_mark_list : ArrayList<Bookmark>
)