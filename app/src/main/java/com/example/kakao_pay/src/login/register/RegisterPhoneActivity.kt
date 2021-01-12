package com.example.kakao_pay.src.login.register

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityRegisterPhoneBinding
import com.example.kakao_pay.src.login.register.input_phone.RegisterInputPhoneActivity

class RegisterPhoneActivity : BaseActivity<ActivityRegisterPhoneBinding>(ActivityRegisterPhoneBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.noMailAgreeTitleCheckBox.setOnCheckedChangeListener { _, _ ->
            if (binding.noMailAgreeTitleCheckBox.isChecked) {
                binding.noMailAgreeFirCheckBox.isChecked = true
                binding.noMailAgreeSecCheckBox.isChecked = true
                binding.noMailAgreeThrCheckBox.isChecked = true
                binding.noMailAgreeForCheckBox.isChecked = true
                binding.noMailAgreeFiveCheckBox.isChecked = true
                binding.noMailAgreeSixCheckBox.isChecked = true
                binding.noMailAgreeSevenCheckBox.isChecked = true
            }
            else {
                binding.noMailAgreeFirCheckBox.isChecked = false
                binding.noMailAgreeSecCheckBox.isChecked = false
                binding.noMailAgreeThrCheckBox.isChecked = false
                binding.noMailAgreeForCheckBox.isChecked = false
                binding.noMailAgreeFiveCheckBox.isChecked = false
                binding.noMailAgreeSixCheckBox.isChecked = false
                binding.noMailAgreeSevenCheckBox.isChecked = false
            }
        }

        binding.noMailAgreeSecCheckBox.setOnCheckedChangeListener{ _, _ ->
            if(binding.noMailAgreeSecCheckBox.isChecked && binding.noMailAgreeThrCheckBox.isChecked
                && binding.noMailAgreeSevenCheckBox.isChecked) {
                binding.btnNoMailAgree.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                binding.btnNoMailAgree.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
            else if(!binding.noMailAgreeSecCheckBox.isChecked || !binding.noMailAgreeThrCheckBox.isChecked
                && !binding.noMailAgreeSevenCheckBox.isChecked) {
                binding.btnNoMailAgree.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                binding.btnNoMailAgree.setTextColor(ContextCompat.getColor(this, R.color.grayText))
            }
        }

        binding.noMailAgreeThrCheckBox.setOnCheckedChangeListener{ _, _ ->
            if(binding.noMailAgreeSecCheckBox.isChecked && binding.noMailAgreeThrCheckBox.isChecked
                && binding.noMailAgreeSevenCheckBox.isChecked) {
                binding.btnNoMailAgree.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                binding.btnNoMailAgree.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
            else if(!binding.noMailAgreeSecCheckBox.isChecked || !binding.noMailAgreeThrCheckBox.isChecked
                && !binding.noMailAgreeSevenCheckBox.isChecked) {
                binding.btnNoMailAgree.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                binding.btnNoMailAgree.setTextColor(ContextCompat.getColor(this, R.color.grayText))
            }
        }

        binding.noMailAgreeSevenCheckBox.setOnCheckedChangeListener{ _, _ ->
            if(binding.noMailAgreeSecCheckBox.isChecked && binding.noMailAgreeThrCheckBox.isChecked
                && binding.noMailAgreeSevenCheckBox.isChecked) {
                binding.btnNoMailAgree.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                binding.btnNoMailAgree.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
            else if(!binding.noMailAgreeSecCheckBox.isChecked || !binding.noMailAgreeThrCheckBox.isChecked
                && !binding.noMailAgreeSevenCheckBox.isChecked) {
                binding.btnNoMailAgree.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                binding.btnNoMailAgree.setTextColor(ContextCompat.getColor(this, R.color.grayText))
            }
        }

        binding.noMailAgreeTitle.setOnClickListener {
            binding.noMailAgreeTitleCheckBox.toggle()
        }
        binding.noMailAgreeFir.setOnClickListener {
            binding.noMailAgreeFirCheckBox.toggle()
        }
        binding.noMailAgreeSec.setOnClickListener {
            binding.noMailAgreeSecCheckBox.toggle()
        }
        binding.noMailAgreeThr.setOnClickListener {
            binding.noMailAgreeThrCheckBox.toggle()
        }
        binding.noMailAgreeFor.setOnClickListener {
            binding.noMailAgreeForCheckBox.toggle()
        }
        binding.noMailAgreeFive.setOnClickListener {
            binding.noMailAgreeFiveCheckBox.toggle()
        }
        binding.noMailAgreeSix.setOnClickListener {
            binding.noMailAgreeSixCheckBox.toggle()
        }
        binding.noMailAgreeSeven.setOnClickListener {
            binding.noMailAgreeSevenCheckBox.toggle()
        }
        binding.back.setOnClickListener {
            finish()
        }

        binding.btnNoMailAgree.setOnClickListener {
            if (binding.noMailAgreeSecCheckBox.isChecked && binding.noMailAgreeThrCheckBox.isChecked
                && binding.noMailAgreeSevenCheckBox.isChecked) {
                startActivity(Intent(this, RegisterInputPhoneActivity::class.java))
            }
        }
    }
}