package com.example.kakao_pay.src.login.register.phone_input

import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityInputPhoneBinding
import com.example.kakao_pay.src.login.register.phone_input.models.PostPhoneRequest
import com.example.kakao_pay.src.login.register.phone_input.models.PostPhoneResponse
import com.example.kakao_pay.src.login.register.phone_input.recyclerview.DialogCountryCodeRecyclerView
import com.example.kakao_pay.src.utils.Constants
import com.example.kakao_pay.src.utils.getUserPreferences
import com.example.kakao_pay.src.utils.onMyTextChanged


class RegisterInputPhoneActivity : BaseActivity<ActivityInputPhoneBinding>(ActivityInputPhoneBinding::inflate),
    RegisterInputPhoneView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val reg = Regex("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}\$")
        binding.countryCodeBox.setOnClickListener {
            val countryCodeRecycler = DialogCountryCodeRecyclerView()
            countryCodeRecycler.show(supportFragmentManager,countryCodeRecycler.tag)
        }
        binding.btnPhoneSend.setOnClickListener {
            val phone = binding.editPhone.text.toString()
            if(binding.editPhone.text.matches(reg)){
                showCustomToast("정규식")
                val postPhone = PostPhoneRequest(phone = phone)
                showLoadingDialog(this)
                RegisterInputPhoneService(this).tryPostPhone(postPhone)
            }
            else {
                showCustomToast("잘못된 형식의 전화번호입니다. 정확한 전화번호를 입력해주세요.")
                binding.layoutPhone.setBackgroundResource(R.drawable.inputbox_err)
            }
        }

        binding.editPhone.onMyTextChanged {
            if(it.toString().count() > 3) {
                binding.layoutPhone.setBackgroundResource(R.drawable.inputbox_selector)
                binding.btnPhoneSend.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                binding.btnPhoneSend.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        binding.back.setOnClickListener {
            finish()
        }
    }

    // 다이어로그 onDetached 시 작업
    fun onDetached() {
        Log.d(Constants.TAG, "onDetached: called")

        var countryCode = getUserPreferences("countryCode")
        countryCode = countryCode.replace(("[^\\d.]").toRegex(), "")
        binding.textCountryCode.text = "+"+countryCode
    }

    override fun onPostPhoneSuccess(response: PostPhoneResponse) {
        dismissLoadingDialog()
        when(response.code) {
            1000 -> {
                showCustomToast("성공")
            }
            2003 -> {
                showCustomToast("이미 가입된 전화번호")
            }
        }
    }

    override fun onPostPhoneFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}