package com.example.kakao_pay.src.main.sendpage

import com.example.kakao_pay.src.main.sendpage.models.GetFriendsResponse

interface IFriendView {
    fun onGetFriendsSuccess(response: GetFriendsResponse)
    fun onGetFriendsFailure(message : String)
}