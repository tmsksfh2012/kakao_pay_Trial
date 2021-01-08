package com.example.kakao_pay.src.login.register.making_profile

import com.example.kakao_pay.src.login.register.making_profile.models.PostProfileResponse

interface RegisterMakeProfileView {
    fun onPostProfileSuccess(response: PostProfileResponse)
    fun onPostProfileFailure(message : String)
}