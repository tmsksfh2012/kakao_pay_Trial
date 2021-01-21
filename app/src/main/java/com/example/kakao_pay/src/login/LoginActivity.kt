package com.example.kakao_pay.src.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.example.kakao_pay.R
import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityLoginBinding
import com.example.kakao_pay.src.login.login_manager.DialogLoginManager
import com.example.kakao_pay.src.login.models.PostLoginRequest
import com.example.kakao_pay.src.login.models.PostLoginResponse
import com.example.kakao_pay.src.login.register.RegisterMainActivity
import com.example.kakao_pay.src.login.retrofit.ILoginView
import com.example.kakao_pay.src.login.retrofit.LoginService
import com.example.kakao_pay.src.main.MainActivity
import com.example.kakao_pay.src.splash.SplashActivity
import com.example.kakao_pay.src.utils.OnMyTextChanged

class LoginActivity:BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate),
    OnMyTextChanged, ILoginView {
    val reg = Regex("[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mLoginManagerDialog = DialogLoginManager()

        binding.editLoginId.onMyTextChanged {}
        binding.editLoginPassword.onMyTextChanged {}

        binding.btnLoginManager.paint?.isUnderlineText = true

        binding.btnLoginManager.setOnClickListener {
            mLoginManagerDialog.show(supportFragmentManager, mLoginManagerDialog.tag)
        }
        binding.btnRegister.setOnClickListener {
            showLoadingDialog(this)
            Handler(Looper.getMainLooper()).postDelayed({
                dismissLoadingDialog()
                startActivity(Intent(this, RegisterMainActivity::class.java))
            },500)
        }

        binding.btnLogin.setOnClickListener {
            if(binding.editLoginPassword.toString().count() < 4 && binding.editLoginId.text.toString().count() == 0) {
                showCustomToast("이메일 또는 전화번호는 입력해주세요. 비밀번호가 올바르지 않습니다.")
                binding.editLoginId.setBackgroundResource(R.drawable.inputbox_err)
                binding.editLoginPassword.setBackgroundResource(R.drawable.inputbox_err)
            }
            else if(binding.editLoginId.text.toString().count() == 0) {
                showCustomToast("이메일 또는 전화번호를 입력해주세요.")
                binding.editLoginId.setBackgroundResource(R.drawable.inputbox_err)
            }
            else if(binding.editLoginPassword.toString().count() < 4) {
                showCustomToast("비밀번호가 올바르지 않습니다.")
                binding.editLoginPassword.setBackgroundResource(R.drawable.inputbox_err)
            }
            else if(!binding.editLoginId.text.matches(reg)) {
                showCustomToast("이메일 또는 전화번호 형식이 올바르지 않습니다.")
                binding.editLoginId.setBackgroundResource(R.drawable.inputbox_err)
            }
            else {
                val postLogin = PostLoginRequest(
                    email = binding.editLoginId.text.toString(),
                    password = binding.editLoginPassword.text.toString()
                )
                showLoadingDialog(this)
                LoginService(this).tryPostLogin(postLogin)
            }
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        startActivity(Intent(this, LoginMainActivity::class.java))
    }

    override fun EditText.onMyTextChanged(completion: (Editable?) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.editLoginId.isFocused) {
                    if(binding.editLoginId.text.matches(reg) && binding.editLoginPassword.text.count() >= 4){
                        if(binding.editLoginId.background == getDrawable(R.drawable.inputbox_err)){
                            binding.editLoginId.setBackgroundResource(R.drawable.inputbox_selector)
                        }
                        binding.btnLogin.setTextColor(ContextCompat.getColor(context, R.color.black))
                        binding.btnLogin.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                    }
                    else {
                        binding.btnLogin.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                        binding.btnLogin.setTextColor(ContextCompat.getColor(context, R.color.grayText))
                    }
                }
                else if(binding.editLoginPassword.isFocused) {
                    if(binding.editLoginId.text.matches(reg) && binding.editLoginPassword.text.count() >= 4) {
                        if(binding.editLoginPassword.background == getDrawable(R.drawable.inputbox_err)){
                            binding.editLoginPassword.setBackgroundResource(R.drawable.inputbox_selector)
                        }
                        binding.btnLogin.setTextColor(ContextCompat.getColor(context, R.color.black))
                        binding.btnLogin.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                    }
                    else {
                        binding.btnLogin.setBackgroundResource(R.drawable.btn_rounded_bg_gray)
                        binding.btnLogin.setTextColor(ContextCompat.getColor(context, R.color.grayText))
                    }
                }
            }
        })
    }

    override fun onPostLoginSuccess(response: PostLoginResponse) {
        dismissLoadingDialog()
        when(response.code) {
            1000 -> {
                val token = response.jwt
                val editor = ApplicationClass.sSharedPreferences.edit()
                editor.putString(ApplicationClass.X_ACCESS_TOKEN,token)
                editor.apply()
                startActivity(Intent(this, SplashActivity::class.java))
            }
        }
    }

    override fun onPostLoginFailure(message: String) {
        dismissLoadingDialog()
    }
}