package com.example.kakao_pay.src.login.register.making_profile.dialogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.DatePicker.OnDateChangedListener
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.example.kakao_pay.R
import com.example.kakao_pay.src.login.register.making_profile.RegisterMakeProfileActivity
import com.example.kakao_pay.src.utils.putUserSelectBirth


class DialogBirthChooser : DialogFragment() {
    lateinit var yy : String
    lateinit var  mm : String
    lateinit var  dd : String
    lateinit var mainActivity : RegisterMakeProfileActivity
    var check = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_date_picker, container, false)
        isCancelable = false

        return view.rootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = activity as RegisterMakeProfileActivity
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.apply {
            val datePicker = findViewById<DatePicker>(R.id.datePicker)
            datePicker.init(datePicker.year, datePicker.month, datePicker.dayOfMonth,
                OnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
                    yy = year.toString()
                    mm = (monthOfYear + 1).toString()
                    dd = dayOfMonth.toString()
                    check = true

                })

            findViewById<Button>(R.id.btn_date_picker).setOnClickListener {
                if(mm.length == 1) mm = "0$mm"
                if(dd.length == 1) dd = "0$dd"

                putUserSelectBirth(yy, mm, dd)
                mainActivity.onDetached()
                dismiss()
            }

            findViewById<ImageView>(R.id.date_picker_clear).setOnClickListener {
                mainActivity.onDetached()
                dismiss()
            }
        }
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        view?.apply{
//            findViewById<ImageView>(R.id.date_picker_clear).setOnClickListener {
//                dismiss()
//            }

//            val today = Calendar.getInstance()
//
//            datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH))
//            { view, year, month, dayOfMonth ->
//                yy = year.toString()
//                mm = (month + 1).toString()
//                dd = dayOfMonth.toString()
//                check = true
//
//                Log.d(TAG, "onActivityCreated: $yy")
//                Log.d(TAG, "onActivityCreated: $mm")
//                Log.d(TAG, "onActivityCreated: $dd")
//            }
//        }
//    }
}