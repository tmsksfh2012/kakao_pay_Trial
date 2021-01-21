package com.example.kakao_pay.src.main.send.fragments.friends

import com.example.kakao_pay.src.main.send.fragments.friends.models.about_send.PostSendMoneyResponse

interface IPostSendView {
    fun onPostSendSuccess(response: PostSendMoneyResponse)
    fun onPostSendFailure(message : String)
}