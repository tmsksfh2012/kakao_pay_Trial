package com.example.kakao_pay.src.login.register.making_kakao

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityMakeKakaoBinding
import com.example.kakao_pay.src.login.register.making_password.RegisterMakePasswordActivity
import com.example.kakao_pay.src.utils.OnMyTextChanged
import com.example.kakao_pay.src.utils.backRegisterMain

class RegisterMakeKakaoActivity : BaseActivity<ActivityMakeKakaoBinding>(ActivityMakeKakaoBinding::inflate),
    OnMyTextChanged{
    lateinit var phone : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        phone = intent.extras?.getString("phone")!!

        binding.editId.onMyTextChanged {}

        binding.imgCancel.setOnClickListener {
            binding.editId.text.clear()
        }

        binding.back.setOnClickListener {
            backRegisterMain(this)
        }
        binding.btnNext.setOnClickListener {
            if (binding.editId.text.toString().isEmpty()) {
                binding.layoutId.setBackgroundResource(R.drawable.inputbox_err)
                showCustomToast("아이디를 입력해주세요")
            }
            else if (binding.editId.text.toString().count() < 3 ||
                binding.editId.text.toString().count() > 15) {
                binding.layoutId.setBackgroundResource(R.drawable.inputbox_err)
                showCustomToast("3자 이상 15자까지 사용할 수 있습니다.")
            }
            else {
                // 비밀번호 생성창으로 이동
                startActivity(Intent(this, RegisterMakePasswordActivity::class.java)
                    .putExtra("email", binding.editId.text.toString()+"@kakao.com")
                    .putExtra("phone", phone))
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        backRegisterMain(this)
    }

    override fun EditText.onMyTextChanged(completion: (Editable?) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.editId.isFocused){
                    if(binding.layoutId.background == getDrawable(R.drawable.inputbox_err)) {
                        binding.layoutId.setBackgroundResource(R.drawable.inputbox_selector)
                    }
                    when {
                        binding.editId.text.toString().count() == 0 -> {
                            binding.btnNext.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                            binding.btnNext.setTextColor(ContextCompat.getColor(context, R.color.grayText))
                            binding.imgCancel.visibility = View.GONE
                        }
                        binding.editId.text.toString().count() == 1 -> {
                            binding.imgCancel.visibility = View.VISIBLE
                        }
                        binding.editId.text.toString().count() == 3 -> {
                            binding.btnNext.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                            binding.btnNext.setTextColor(ContextCompat.getColor(context, R.color.black))
                        }
                        binding.editId.text.toString().count() == 2 -> {
                            binding.btnNext.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                            binding.btnNext.setTextColor(ContextCompat.getColor(context, R.color.grayText))
                        }
                    }
                }
            }
        })
    }
}