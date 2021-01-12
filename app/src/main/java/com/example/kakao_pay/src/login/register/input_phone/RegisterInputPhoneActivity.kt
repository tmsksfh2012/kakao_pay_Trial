package com.example.kakao_pay.src.login.register.input_phone

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityInputPhoneBinding
import com.example.kakao_pay.src.login.register.input_phone.certify_phone.RegisterCertifyPhoneActivity
import com.example.kakao_pay.src.login.register.input_phone.models.PostPhoneRequest
import com.example.kakao_pay.src.login.register.input_phone.models.PostPhoneResponse
import com.example.kakao_pay.src.login.register.input_phone.recycler_view.DialogCountryCodeRecyclerView
import com.example.kakao_pay.src.utils.Constants
import com.example.kakao_pay.src.utils.OnMyTextChanged
import com.example.kakao_pay.src.utils.getUserPreferences


class RegisterInputPhoneActivity : BaseActivity<ActivityInputPhoneBinding>(ActivityInputPhoneBinding::inflate),
    IRegisterInputPhoneView, OnMyTextChanged{
    private lateinit var phone : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val reg = Regex("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}\$")
        binding.countryCodeBox.setOnClickListener {
            val countryCodeRecycler = DialogCountryCodeRecyclerView()
            countryCodeRecycler.show(supportFragmentManager,countryCodeRecycler.tag)
        }
        binding.btnPhoneSend.setOnClickListener {
            phone = binding.editPhone.text.toString()
            if(binding.editPhone.text.matches(reg)){
                val postPhone = PostPhoneRequest(phone = phone)
                showLoadingDialog(this)
                RegisterInputPhoneService(this).tryPostPhone(postPhone)
            }
            else {
                showCustomToast("잘못된 형식의 전화번호입니다. 정확한 전화번호를 입력해주세요.")
                binding.layoutPhone.setBackgroundResource(R.drawable.inputbox_err)
            }
        }

        binding.editPhone.onMyTextChanged {}

        binding.back.setOnClickListener {
            finish()
        }
    }

    // 다이어로그 onDetached 시 작업
    fun onDetached() {
        Log.d(Constants.TAG, "onDetached: called")

        var countryCode = getUserPreferences("countryCode")
        countryCode = countryCode.replace(("[^\\d.]").toRegex(), "")
        binding.textCountryCode.text = "+$countryCode"
    }

    override fun onPostPhoneSuccess(response: PostPhoneResponse) {
        dismissLoadingDialog()
        when(response.code) {
            1000 -> {
                startActivity(Intent(this,RegisterCertifyPhoneActivity::class.java).putExtra("phone", phone))
            }
            2003 -> {
                showCustomToast("이미 가입된 전화번호입니다. 다른 전화번호로 시도해주세요.")
            }
        }
    }

    override fun onPostPhoneFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

    override fun EditText.onMyTextChanged(completion: (Editable?) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.editPhone.isFocused){
                    if(binding.editPhone.text.toString().count() > 3) {
                        binding.layoutPhone.setBackgroundResource(R.drawable.inputbox_selector)
                        binding.btnPhoneSend.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                        binding.btnPhoneSend.setTextColor(ContextCompat.getColor(context, R.color.black))
                    }
                    else {
                        binding.btnPhoneSend.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                        binding.btnPhoneSend.setTextColor(ContextCompat.getColor(context, R.color.grayText))
                    }
                }
            }
        })
    }
}