package com.example.kakao_pay.src.main.send.fragments.friends

import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_friends.GetFriendsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FriendService(val view: IFriendView) {

    fun tryGetUsers(){
        val iFriendsRetrofit = ApplicationClass.sRetrofit.create(IFriendRetrofit::class.java)
        iFriendsRetrofit.getPhone().enqueue(object : Callback<GetFriendsResponse> {
            override fun onResponse(call: Call<GetFriendsResponse>, response: Response<GetFriendsResponse>) {
                view.onGetFriendsSuccess(response.body() as GetFriendsResponse)
            }

            override fun onFailure(call: Call<GetFriendsResponse>, t: Throwable) {
                view.onGetFriendsFailure(t.message ?: "통신 오류")
            }
        })
    }
}