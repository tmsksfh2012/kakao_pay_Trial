package com.example.kakao_pay.src.main.send.fragments.friends

import com.example.kakao_pay.src.main.send.fragments.friends.models.about_friends.GetFriendsResponse

interface IFriendView {
    fun onGetFriendsSuccess(response: GetFriendsResponse)
    fun onGetFriendsFailure(message : String)
}