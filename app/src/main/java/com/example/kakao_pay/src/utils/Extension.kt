package com.example.kakao_pay.src.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.*
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.*
import com.example.kakao_pay.config.ApplicationClass
import com.example.kakao_pay.src.login.register.RegisterMainActivity

// EditText Extension
interface OnMyTextChanged {
    fun EditText.onMyTextChanged(completion: (Editable?) -> Unit)
}

fun putUserSelectPosition(position: Int){
    val editor = ApplicationClass.sSharedPreferences.edit()
    editor.putInt("position",position)
    editor.apply()
}
fun getUserSelectPosition() : Int {
    return ApplicationClass.sSharedPreferences.getInt("position", 0)
}

fun putUserSelectBirth(year: String, month: String, day: String){
    val editor = ApplicationClass.sSharedPreferences.edit()
    editor.putString("year",year)
    editor.putString("month",month)
    editor.putString("day",day)
    editor.apply()
}
fun getUserPreferences(name: String) : String {
    if(ApplicationClass.sSharedPreferences.getString(name, "") == null){
        return name
    }
    else {
        return ApplicationClass.sSharedPreferences.getString(name, "")!!
    }
}
fun putUserCountryCode(countryCode: String){
    val editor = ApplicationClass.sSharedPreferences.edit()
    editor.putString("countryCode",countryCode)
    editor.apply()
}
fun backRegisterMain(activity: Activity){
    activity.finishAffinity()
    activity.startActivity(Intent(activity, RegisterMainActivity::class.java))
}