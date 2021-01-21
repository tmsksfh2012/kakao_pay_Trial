package com.example.kakao_pay.src.main.send.fragments.friends.models.about_friends

import com.google.gson.annotations.SerializedName

data class Result (
        @SerializedName("user_list") val user_list : ArrayList<User>
)