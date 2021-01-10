package com.example.kakao_pay.src.login.register.phone_input

import com.example.kakao_pay.src.login.register.phone_input.models.PostPhoneResponse


interface RegisterInputPhoneView {
    fun onPostPhoneSuccess(response: PostPhoneResponse)
    fun onPostPhoneFailure(message : String)
}