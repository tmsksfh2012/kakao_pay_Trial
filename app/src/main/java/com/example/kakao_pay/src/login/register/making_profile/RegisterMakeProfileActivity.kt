package com.example.kakao_pay.src.login.register.making_profile

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityMakingProfileBinding
import com.example.kakao_pay.src.login.register.complete_register.RegisterCompleteActivity
import com.example.kakao_pay.src.login.register.email_input.RegisterInputEmailService
import com.example.kakao_pay.src.login.register.making_profile.dialogs.DialogBirthChooser
import com.example.kakao_pay.src.login.register.making_profile.dialogs.DialogBirthErr
import com.example.kakao_pay.src.login.register.making_profile.models.PostProfileRequest
import com.example.kakao_pay.src.login.register.making_profile.models.PostProfileResponse
import com.example.kakao_pay.src.utils.Constants.TAG
import com.example.kakao_pay.src.utils.getUserPreferences
import com.example.kakao_pay.src.utils.onMyTextChanged

class RegisterMakeProfileActivity : BaseActivity<ActivityMakingProfileBinding>(ActivityMakingProfileBinding::inflate),
    RegisterMakeProfileView{
    lateinit var email : String
    lateinit var password : String
    lateinit var  nickname : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        password = intent.extras?.getString("password").toString()
        email = intent.extras?.getString("email").toString()
        val mDatePiker = DialogBirthChooser()

        Log.d(TAG, "onCreate: " + (intent.extras?.getString("email").toString()))

        binding.textBirthType.setOnClickListener {
            binding.checkBirthType.toggle()
        }

        binding.editNickname.onMyTextChanged {
            if (it.toString().count() == 1) {
                binding.editNickname.setBackgroundResource(R.drawable.inputbox_selector)
            } else if (it.toString().count() > 20) {
                binding.editNickname.setText(
                    binding.editNickname.text!!.substring(
                        0,
                        binding.editNickname.text.toString().length - 1
                    )
                )
            }
        }

        binding.layoutBirth.setOnClickListener {

            mDatePiker.show(supportFragmentManager, mDatePiker.tag)
        }

        if (mDatePiker.isDetached) {
            Log.d(TAG, "isDetached: Here")
            lateinit var yy : String
            lateinit var mm : String
            lateinit var dd : String

            if(getUserPreferences("year") == "year") yy = "연도"
            if(getUserPreferences("month") == "month") yy = "월"
            if(getUserPreferences("day") == "day") yy = "일"

            binding.birthYear.text = Editable.Factory.getInstance().newEditable(yy)
            binding.birthMon.text = Editable.Factory.getInstance().newEditable(mm)
            binding.birthDay.text = Editable.Factory.getInstance().newEditable(dd)

            if(binding.birthYear.text.toString() != "연도" && binding.birthMon.text.toString() != "월"
                && binding.birthDay.text.toString() != "일"){
                binding.btnNext.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
                binding.btnNext.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        binding.btnNext.setOnClickListener {
            if (binding.editNickname.text.toString() == "") {
                showCustomToast("닉네임이 등록되지 않았습니다. 닉네임을 입력해주세요.")
                binding.editNickname.setBackgroundResource(R.drawable.inputbox_err)
            } else if (binding.birthYear.text.toString() == "연도" || binding.birthMon.text.toString() == "월"
                || binding.birthDay.text.toString() == "일"
            ) {
                val mBirthErr = DialogBirthErr()
                mBirthErr.show(supportFragmentManager, mBirthErr.tag)
            } else {
                nickname = binding.editNickname.text.toString()
                if (binding.checkBirthType.isChecked) {
                    if (binding.checkGenderMen.isChecked) {
                        val birth =
                            binding.birthYear.text.toString() + binding.birthMon.text.toString() + binding.birthDay.text.toString()
                        val postProfile = PostProfileRequest(
                            email = email,
                            password = password,
                            birthday = birth,
                            nickname = binding.editNickname.text.toString(),
                            gender = "M",
                            lunar_check = true,
                            phone = ""
                        )
                        showLoadingDialog(this)
                        RegisterMakeProfileService(this).tryPostProfile(postProfile)
                    } else if (binding.checkGenderWomen.isChecked) {
                        val birth =
                            binding.birthYear.text.toString() + binding.birthMon.text.toString() + binding.birthDay.text.toString()
                        val postProfile = PostProfileRequest(
                            email = email,
                            password = password,
                            birthday = birth,
                            nickname = binding.editNickname.text.toString(),
                            gender = "G",
                            lunar_check = true,
                            phone = ""
                        )
                        showLoadingDialog(this)
                        RegisterMakeProfileService(this).tryPostProfile(postProfile)
                    } else if (binding.checkGenderNoChoose.isChecked) {
                        val birth =
                            binding.birthYear.text.toString() + binding.birthMon.text.toString() + binding.birthDay.text.toString()
                        val postProfile = PostProfileRequest(
                            email = email,
                            password = password,
                            birthday = birth,
                            nickname = binding.editNickname.text.toString(),
                            gender = "N",
                            lunar_check = true,
                            phone = ""
                        )
                        showLoadingDialog(this)
                        RegisterMakeProfileService(this).tryPostProfile(postProfile)
                    }

                } else if (!binding.checkBirthType.isChecked) {
                    if (binding.checkGenderMen.isChecked) {
                        val birth =
                            binding.birthYear.text.toString() + binding.birthMon.text.toString() + binding.birthDay.text.toString()
                        val postProfile = PostProfileRequest(
                            email = email,
                            password = password,
                            birthday = birth,
                            nickname = binding.editNickname.text.toString(),
                            gender = "M",
                            lunar_check = false,
                            phone = ""
                        )
                        showLoadingDialog(this)
                        RegisterMakeProfileService(this).tryPostProfile(postProfile)
                    }
                }
            }
        }

    }

    override fun onPostProfileSuccess(response: PostProfileResponse) {
        dismissLoadingDialog()
        when(response.code) {
            // 회원가입 성공
            1000 -> {
                startActivity(Intent(this, RegisterCompleteActivity::class.java)
                    .putExtra("email",email).putExtra("password",password).putExtra("nickname", nickname))
            }
        }
    }

    override fun onPostProfileFailure(message: String) {

    }
}