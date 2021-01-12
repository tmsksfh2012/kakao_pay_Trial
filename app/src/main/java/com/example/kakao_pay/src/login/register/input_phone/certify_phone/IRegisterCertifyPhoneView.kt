package com.example.kakao_pay.src.login.register.input_phone.certify_phone

import com.example.kakao_pay.src.login.register.input_phone.certify_phone.models.GetPhoneResponse

interface IRegisterCertifyPhoneView {
    fun onGetPhoneSuccess(response: GetPhoneResponse)
    fun onGetPhoneFailure(message: String)
}