package com.example.kakao_pay.src.main.send.fragments.account

import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.main.send.fragments.account.models.GetBankResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BankService(val view: IGetBankView) {
    fun tryGetBanks(){
        val iBookmarkRetrofit = ApplicationClass.sRetrofit.create(IGetBankRetrofit::class.java)
        iBookmarkRetrofit.getBanks().enqueue(object : Callback<GetBankResponse> {
            override fun onResponse(call: Call<GetBankResponse>, response: Response<GetBankResponse>) {
                view.onGetBankSuccess(response.body() as GetBankResponse)
            }

            override fun onFailure(call: Call<GetBankResponse>, t: Throwable) {
                view.onGetBankFailure(t.message ?: "통신 오류")
            }
        })
    }
}