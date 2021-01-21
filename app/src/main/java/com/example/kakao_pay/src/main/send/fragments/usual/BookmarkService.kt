package com.example.kakao_pay.src.main.send.fragments.usual

import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.main.send.fragments.usual.models.GetBookmarkResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookmarkService (val view: IGetBookmarkView) {

    fun tryGetBookmark(){
        val iBookmarkRetrofit = ApplicationClass.sRetrofit.create(IGetBookmarkRetrofit::class.java)
        iBookmarkRetrofit.getBookmark().enqueue(object : Callback<GetBookmarkResponse> {
            override fun onResponse(call: Call<GetBookmarkResponse>, response: Response<GetBookmarkResponse>) {
                view.onGetBookmarkSuccess(response.body() as GetBookmarkResponse)
            }

            override fun onFailure(call: Call<GetBookmarkResponse>, t: Throwable) {
                view.onGetBookmarkFailure(t.message ?: "통신 오류")
            }
        })
    }
}