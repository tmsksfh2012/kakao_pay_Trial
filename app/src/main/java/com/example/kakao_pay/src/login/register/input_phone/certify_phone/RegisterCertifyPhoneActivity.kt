package com.example.kakao_pay.src.login.register.input_phone.certify_phone

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityCertifyPhoneBinding
import com.example.kakao_pay.src.login.register.input_email.certify_email.dialogs.DialogSuccessCertify
import com.example.kakao_pay.src.login.register.input_phone.IRegisterInputPhoneView
import com.example.kakao_pay.src.login.register.input_phone.RegisterInputPhoneService
import com.example.kakao_pay.src.login.register.input_phone.certify_phone.dialogs.DialogNoCertifyPhone
import com.example.kakao_pay.src.login.register.input_phone.certify_phone.models.GetPhoneRequest
import com.example.kakao_pay.src.login.register.input_phone.certify_phone.models.GetPhoneResponse
import com.example.kakao_pay.src.login.register.input_phone.models.PostPhoneRequest
import com.example.kakao_pay.src.login.register.input_phone.models.PostPhoneResponse
import com.example.kakao_pay.src.utils.OnMyTextChanged
import com.example.kakao_pay.src.utils.getUserSelectPosition


class RegisterCertifyPhoneActivity : BaseActivity<ActivityCertifyPhoneBinding> (ActivityCertifyPhoneBinding::inflate),
    View.OnClickListener, IRegisterCertifyPhoneView, IRegisterInputPhoneView, OnMyTextChanged{
    val MillisInfuture = 300 * 1000
    val countDownInterval = 1000
    var STATE : Boolean = true
    lateinit var phone : String
    lateinit var countDownTimer : CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        countDownTimer = object : CountDownTimer(MillisInfuture.toLong(), countDownInterval.toLong()) {
            override fun onTick(millisUntilFinished: Long) {
                val getMin = millisUntilFinished - millisUntilFinished / (60 * 60 * 1000)
                val min = (getMin / (60 * 1000)).toString()

                var second = (getMin % (60 * 1000) / 1000).toString()
                // 초가 한자리면 0을 붙인다
                if (second.length == 1) {
                    second = "0" + second
                }
                binding.timerCertify.text = "$min:$second"
            }

            override fun onFinish() {
                STATE = false
            }
        }
        countDownTimer.start()

        binding.noAuthNum.paint?.isUnderlineText = true

        phone = intent.extras?.getString("phone")!!
        binding.editPhone.text = Editable.Factory.getInstance().newEditable(phone)
        binding.editPhone.setTextColor(Color.parseColor("#757575"))
        binding.editPhone.isClickable = false
        binding.editPhone.isFocusable = false
        binding.editPhone.setOnTouchListener { v, event -> false }

        binding.editAuthNum.onMyTextChanged {}
        binding.imgCancel.setOnClickListener {
            binding.editAuthNum.text.clear()
        }

        binding.btnPhoneCertifySend.setOnClickListener {
            if(!STATE) {
                showCustomToast("시간초과")
            }
            else{
                val getPhoneNum = GetPhoneRequest(phone = phone, auth_number = binding.editAuthNum.text.toString())
                showLoadingDialog(this)
                RegisterCertifyPhoneService(this).tryGetPhone(getPhoneNum)
            }
        }
        binding.noAuthNum.setOnClickListener {
            val noCertifyPhone = DialogNoCertifyPhone()
            noCertifyPhone.show(supportFragmentManager, noCertifyPhone.tag)
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    override fun onGetPhoneSuccess(response: GetPhoneResponse) {
        dismissLoadingDialog()
        when(response.code){
            1000-> {
                val mSuccessDialog = DialogSuccessCertify()
                mSuccessDialog.show(supportFragmentManager, mSuccessDialog.tag)
            }
        }
    }

    override fun onGetPhoneFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

    override fun onPostPhoneSuccess(response: PostPhoneResponse) {
        dismissLoadingDialog()
    }

    override fun onPostPhoneFailure(message: String) {
    }

    fun onDetached() {
        val position = getUserSelectPosition()
        if(position == 1) {
            val postPhone = PostPhoneRequest(phone = phone)
            showLoadingDialog(this)
            RegisterInputPhoneService(this).tryPostPhone(postPhone)

            STATE = true
            countDownTimer.cancel()
            countDownTimer.start()
        }
        else if(position == 2){
            finish()
        }
    }

    fun getPhoneNum(): String {
        return phone
    }

    override fun EditText.onMyTextChanged(completion: (Editable?) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.editAuthNum.isFocused){
                    when {
                        binding.editAuthNum.text.toString().count() == 0 -> {
                            binding.imgCancel.visibility = View.GONE
                        }
                        binding.editAuthNum.text.toString().count() == 1 -> {
                            binding.imgCancel.visibility = View.VISIBLE
                        }
                        binding.editAuthNum.text.toString().count() == 6 -> {
                            binding.btnPhoneCertifySend.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                            binding.btnPhoneCertifySend.setTextColor(ContextCompat.getColor(context, R.color.black))
                        }
                        binding.editAuthNum.text.toString().count() > 6 -> {
                            binding.editAuthNum.setText(binding.editAuthNum.text.substring(0,binding.editAuthNum.text.toString().length-1))
                        }
                    }
                }
            }
        })
    }
}