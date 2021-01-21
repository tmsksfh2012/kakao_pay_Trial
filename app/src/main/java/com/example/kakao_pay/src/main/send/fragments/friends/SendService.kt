package com.example.kakao_pay.src.main.send.fragments.friends

import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_send.PostSendMoneyRequest
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_send.PostSendMoneyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SendService(val view: IPostSendView) {

    fun tryPostSend(sendRequest : PostSendMoneyRequest){
        val iBookmarkRetrofit = ApplicationClass.sRetrofit.create(IPostSendRetrofit::class.java)
        iBookmarkRetrofit.getBookmark(sendRequest).enqueue(object : Callback<PostSendMoneyResponse> {
            override fun onResponse(call: Call<PostSendMoneyResponse>, response: Response<PostSendMoneyResponse>) {
                view.onPostSendSuccess(response.body() as PostSendMoneyResponse)
            }

            override fun onFailure(call: Call<PostSendMoneyResponse>, t: Throwable) {
                view.onPostSendFailure(t.message ?: "통신 오류")
            }
        })
    }
}