package com.example.kakao_pay.src.utils

import android.content.Context
import android.graphics.*
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.*
import com.example.kakao_pay.config.ApplicationClass

// EditText Extension
fun EditText.onMyTextChanged(completion: (Editable?) -> Unit){
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            completion(editable)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    })
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