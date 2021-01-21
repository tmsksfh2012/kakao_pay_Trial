package com.example.kakao_pay.src.main.send.fragments.account

import com.example.kakao_pay.src.main.send.fragments.account.GetSendLimitResponse


interface IGetSendLimitView {
    fun onGetSendLimitSuccess(response: GetSendLimitResponse)
    fun onGetSendLimitFailure(message : String)
}