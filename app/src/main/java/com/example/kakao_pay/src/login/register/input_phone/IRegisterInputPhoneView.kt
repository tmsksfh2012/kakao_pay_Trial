package com.example.kakao_pay.src.login.register.input_phone

import com.example.kakao_pay.src.login.register.input_phone.models.PostPhoneResponse


interface IRegisterInputPhoneView {
    fun onPostPhoneSuccess(response: PostPhoneResponse)
    fun onPostPhoneFailure(message : String)
}