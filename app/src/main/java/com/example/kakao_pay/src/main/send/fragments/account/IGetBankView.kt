package com.example.kakao_pay.src.main.send.fragments.account

import com.example.kakao_pay.src.main.send.fragments.account.models.GetBankResponse

interface IGetBankView {
    fun onGetBankSuccess(response: GetBankResponse)
    fun onGetBankFailure(message : String)
}