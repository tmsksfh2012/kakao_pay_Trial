package com.example.kakao_pay.src.main.send.fragments.recent

import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.main.send.models.recentList.GetRecentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecentService(val view: IRecentView) {

    fun tryGetRecent() {
        val iRecentRetrofit = ApplicationClass.sRetrofit.create(IRecentRetrofit::class.java)
        iRecentRetrofit.getRecent().enqueue(object : Callback<GetRecentResponse> {
            override fun onResponse(call: Call<GetRecentResponse>, response: Response<GetRecentResponse>) {
                view.onGetRecentSuccess(response.body() as GetRecentResponse)
            }

            override fun onFailure(call: Call<GetRecentResponse>, t: Throwable) {
                view.onGetRecentFailure(t.message ?: "통신 오류")
            }
        })
    }
}