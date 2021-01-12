package com.example.kakao_pay.src.login.register.making_profile

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseActivity
import com.example.kakao_pay.databinding.ActivityMakingProfileBinding
import com.example.kakao_pay.src.login.register.complete_register.RegisterCompleteActivity
import com.example.kakao_pay.src.login.register.making_profile.dialogs.DialogBirthChooser
import com.example.kakao_pay.src.login.register.making_profile.dialogs.DialogBirthErr
import com.example.kakao_pay.src.login.register.making_profile.models.PostProfileRequest
import com.example.kakao_pay.src.login.register.making_profile.models.PostProfileResponse
import com.example.kakao_pay.src.utils.Constants.TAG
import com.example.kakao_pay.src.utils.OnMyTextChanged
import com.example.kakao_pay.src.utils.getUserPreferences

class RegisterMakeProfileActivity : BaseActivity<ActivityMakingProfileBinding>(ActivityMakingProfileBinding::inflate),
    IRegisterMakeProfileView, OnMyTextChanged{
    lateinit var email : String
    lateinit var password : String
    lateinit var nickname : String
    lateinit var name : String
    lateinit var birthNum : String

    var phone : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val reg = Regex("^[가-힣]*\$")

        password = intent.extras?.getString("password")!!
        email = intent.extras?.getString("email")!!
        phone = intent.extras?.getString("phone")
        if(phone == "") {
            phone = null
        }
        val mDatePiker = DialogBirthChooser()

        binding.makingProfileBack.setOnClickListener {
            finish()
        }

        Log.d(TAG, "onCreate: " + (intent.extras?.getString("email")!!))

        binding.textBirthType.setOnClickListener {
            binding.checkBirthType.toggle()
        }

        binding.editName.onMyTextChanged {}

        binding.editNickname.onMyTextChanged {}

        binding.layoutBirth.setOnClickListener {

            mDatePiker.show(supportFragmentManager, mDatePiker.tag)
        }

        binding.btnNext.setOnClickListener {
            if (binding.editNickname.text.toString() == "") {
                showCustomToast("닉네임이 등록되지 않았습니다. 닉네임을 입력해주세요.")
                binding.editNickname.setBackgroundResource(R.drawable.inputbox_err)
            }
            else if (binding.birthYear.text.toString() == "연도" || binding.birthMon.text.toString() == "월"
                || binding.birthDay.text.toString() == "일") {
                val mBirthErr = DialogBirthErr()
                mBirthErr.show(supportFragmentManager, mBirthErr.tag)
            }
            else if (binding.editName.text.toString() == "") {
                showCustomToast("이름이 등록되지 않았습니다. 이름을 입력해주세요.")
                binding.editName.setBackgroundResource(R.drawable.inputbox_err)
            }
            else if (!binding.editName.text.matches(reg)) {
                showCustomToast("올바른 이름 형식이 아닙니다. 다시 시도해주세요.")
            }
            else {
                nickname = binding.editNickname.text.toString()
                name = binding.editName.text.toString()
                if (binding.checkBirthType.isChecked) {
                    when {
                        binding.checkGenderMen.isChecked -> {
                            val birth =
                                binding.birthYear.text.toString() + binding.birthMon.text.toString() + binding.birthDay.text.toString()
                            val postProfile = PostProfileRequest(
                                email = email,
                                name = name,
                                password = password,
                                birthday = birth,
                                nickname = binding.editNickname.text.toString(),
                                gender = "M",
                                lunar_check = true,
                                phone = phone
                            )
                            showLoadingDialog(this)
                            birthNum = binding.birthYear.text.toString() +"." + binding.birthMon.text.toString()+"." + binding.birthDay.text.toString()
                            RegisterMakeProfileService(this).tryPostProfile(postProfile)
                        }
                        binding.checkGenderWomen.isChecked -> {
                            val birth =
                                binding.birthYear.text.toString() + binding.birthMon.text.toString() + binding.birthDay.text.toString()
                            val postProfile = PostProfileRequest(
                                email = email,
                                name = name,
                                password = password,
                                birthday = birth,
                                nickname = binding.editNickname.text.toString(),
                                gender = "G",
                                lunar_check = true,
                                phone = phone
                            )
                            showLoadingDialog(this)
                            birthNum = binding.birthYear.text.toString() +"." + binding.birthMon.text.toString()+"." + binding.birthDay.text.toString()
                            RegisterMakeProfileService(this).tryPostProfile(postProfile)
                        }
                        binding.checkGenderNoChoose.isChecked -> {
                            val birth =
                                binding.birthYear.text.toString() + binding.birthMon.text.toString() + binding.birthDay.text.toString()
                            val postProfile = PostProfileRequest(
                                email = email,
                                name = name,
                                password = password,
                                birthday = birth,
                                nickname = binding.editNickname.text.toString(),
                                gender = "N",
                                lunar_check = true,
                                phone = phone
                            )
                            showLoadingDialog(this)
                            birthNum = binding.birthYear.text.toString() +"." + binding.birthMon.text.toString()+"." + binding.birthDay.text.toString()
                            RegisterMakeProfileService(this).tryPostProfile(postProfile)
                        }
                    }

                } else if (!binding.checkBirthType.isChecked) {
                    if (binding.checkGenderMen.isChecked) {
                        val birth =
                            binding.birthYear.text.toString() + binding.birthMon.text.toString() + binding.birthDay.text.toString()
                        val postProfile = PostProfileRequest(
                            email = email,
                            name = name,
                            password = password,
                            birthday = birth,
                            nickname = binding.editNickname.text.toString(),
                            gender = "M",
                            lunar_check = false,
                            phone = phone
                        )
                        showLoadingDialog(this)
                        birthNum = binding.birthYear.text.toString() +"." + binding.birthMon.text.toString()+"." + binding.birthDay.text.toString()
                        RegisterMakeProfileService(this).tryPostProfile(postProfile)
                    } else if (binding.checkGenderWomen.isChecked) {
                        val birth =
                            binding.birthYear.text.toString() + binding.birthMon.text.toString() + binding.birthDay.text.toString()
                        val postProfile = PostProfileRequest(
                            email = email,
                            name = name,
                            password = password,
                            birthday = birth,
                            nickname = binding.editNickname.text.toString(),
                            gender = "G",
                            lunar_check = false,
                            phone = phone
                        )
                        showLoadingDialog(this)
                        birthNum = binding.birthYear.text.toString() +"." + binding.birthMon.text.toString()+"." + binding.birthDay.text.toString()
                        RegisterMakeProfileService(this).tryPostProfile(postProfile)
                    } else if (binding.checkGenderNoChoose.isChecked) {
                        val birth =
                            binding.birthYear.text.toString() + binding.birthMon.text.toString() + binding.birthDay.text.toString()
                        val postProfile = PostProfileRequest(
                            email = email,
                            name = name,
                            password = password,
                            birthday = birth,
                            nickname = binding.editNickname.text.toString(),
                            gender = "N",
                            lunar_check = false,
                            phone = phone
                        )
                        showLoadingDialog(this)
                        birthNum = binding.birthYear.text.toString() +"." + binding.birthMon.text.toString()+"." + binding.birthDay.text.toString()
                        RegisterMakeProfileService(this).tryPostProfile(postProfile)
                    }
                }
            }
        }

    }

    override fun onPostProfileSuccess(response: PostProfileResponse) {
        dismissLoadingDialog()
        Log.d(TAG, "onPostProfileSuccess: " + response.code)
            // 회원가입 성공
        if(response.code == 1000) {
            startActivity(Intent(this, RegisterCompleteActivity::class.java)
                .putExtra("email",email).putExtra("nickname", nickname).putExtra("name", name)
                .putExtra("birth", birthNum).putExtra("phone", phone)
                .putExtra("password", password))
        }
        else {
            showCustomToast(response.message)
        }
    }

    override fun onPostProfileFailure(message: String) {}

    fun onDetached() {
        Log.d(TAG, "isDetached: Here")

        val yy : String = getUserPreferences("year")
        val mm : String = getUserPreferences("month")
        val dd : String = getUserPreferences("day")


        binding.birthYear.text = yy
        binding.birthMon.text = mm
        binding.birthDay.text = dd

        if(binding.birthYear.text.toString() != "연도" && binding.birthMon.text.toString() != "월"
            && binding.birthDay.text.toString() != "일"){
            binding.btnNext.setBackgroundResource(R.drawable.btn_rounded_bg_yellow)
            binding.btnNext.setTextColor(ContextCompat.getColor(this, R.color.black))
        }
    }

    override fun EditText.onMyTextChanged(completion: (Editable?) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.editName.isFocused) {
                    binding.editName.setBackgroundResource(R.drawable.inputbox_selector)
                    if (binding.editName.text.toString().count() > 20) {
                        binding.editName.setText(binding.editName.text!!.substring(0, binding.editName.text.toString().length - 1)
                        )
                    }
                }
                else if(binding.editNickname.isFocused) {
                    binding.editNickname.setBackgroundResource(R.drawable.inputbox_selector)
                    if (binding.editNickname.text.toString().count() > 20) {
                        binding.editNickname.setText(binding.editNickname.text!!.substring(0, binding.editNickname.text.toString().length - 1)
                        )
                    }
                }
            }
        })
    }
}