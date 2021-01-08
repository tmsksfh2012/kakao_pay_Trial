package com.example.kakao_pay.src.login.register

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityRegisterEmailBinding
import com.example.kakao_pay.src.login.register.email_input.RegisterInputEmailActivity

class RegisterEmailActivity : BaseActivity<ActivityRegisterEmailBinding>(ActivityRegisterEmailBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.agreeTitleCheckBox.setOnCheckedChangeListener { _, _ ->
            if (binding.agreeTitleCheckBox.isChecked) {
                binding.agreeFirCheckBox.isChecked = true
                binding.agreeSecCheckBox.isChecked = true
                binding.agreeThrCheckBox.isChecked = true
                binding.agreeForCheckBox.isChecked = true
            }
            else {
                binding.agreeFirCheckBox.isChecked = false
                binding.agreeSecCheckBox.isChecked = false
                binding.agreeThrCheckBox.isChecked = false
                binding.agreeForCheckBox.isChecked = false
            }
        }

        binding.agreeSecCheckBox.setOnCheckedChangeListener{ _, _ ->
            if(binding.agreeSecCheckBox.isChecked && binding.agreeThrCheckBox.isChecked) {
                binding.btnAgree.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                binding.btnAgree.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
            else if(!binding.agreeSecCheckBox.isChecked || !binding.agreeThrCheckBox.isChecked) {
                binding.btnAgree.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                binding.btnAgree.setTextColor(ContextCompat.getColor(this, R.color.grayText))
            }
        }

        binding.agreeThrCheckBox.setOnCheckedChangeListener{ _, _ ->
            if(binding.agreeSecCheckBox.isChecked && binding.agreeThrCheckBox.isChecked) {
                binding.btnAgree.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                binding.btnAgree.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
            else if(!binding.agreeSecCheckBox.isChecked || !binding.agreeThrCheckBox.isChecked) {
                binding.btnAgree.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                binding.btnAgree.setTextColor(ContextCompat.getColor(this, R.color.grayText))
            }
        }

        binding.agreeTitle.setOnClickListener {
            binding.agreeTitleCheckBox.toggle()
        }
        binding.agreeFir.setOnClickListener {
            binding.agreeFirCheckBox.toggle()
        }
        binding.agreeSec.setOnClickListener {
            binding.agreeSecCheckBox.toggle()
        }
        binding.agreeThr.setOnClickListener {
            binding.agreeThrCheckBox.toggle()
        }
        binding.agreeFor.setOnClickListener {
            binding.agreeForCheckBox.toggle()
        }
        binding.back.setOnClickListener {
            finish()
        }

        binding.btnAgree.setOnClickListener {
            if(binding.agreeSecCheckBox.isChecked && binding.agreeThrCheckBox.isChecked) {
                startActivity(Intent(this, RegisterInputEmailActivity::class.java))
            }
        }
    }
}