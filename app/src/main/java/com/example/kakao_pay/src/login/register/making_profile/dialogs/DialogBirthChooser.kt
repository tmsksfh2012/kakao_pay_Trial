package com.example.kakao_pay.src.login.register.making_profile.dialogs

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.example.kakao_pay.R
import com.example.kakao_pay.src.utils.Constants.TAG
import com.example.kakao_pay.src.utils.putUserSelectBirth
import java.util.*


class DialogBirthChooser : DialogFragment(), View.OnClickListener {
    lateinit var yy : String
    lateinit var  mm : String
    lateinit var  dd : String
    lateinit var  datePicker: DatePicker
    var check = false

    interface DateListener {
        fun onDateSelected(year: Int, month: Int, day: Int)
    }

    private var listener: DateListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        datePicker = DatePicker(context)

        datePicker.maxDate = System.currentTimeMillis()
        Log.d(TAG, "onActivityCreated: ${datePicker.maxDate}")

        val view = inflater.inflate(R.layout.dialog_date_picker, container, false)
        isCancelable = false

        if (check) {
            datePicker.updateDate(yy.toInt(), mm.toInt(), dd.toInt())
        }

        return view.rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.apply{
            findViewById<ImageView>(R.id.date_picker_clear).setOnClickListener {
                dismiss()
            }

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

            findViewById<Button>(R.id.btn_date_picker).setOnClickListener {
                putUserSelectBirth(yy,mm,dd)
                dismiss()
            }
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_date_picker -> {
                val year = datePicker.year
                val month = datePicker.month + 1 // months start in 0
                val day = datePicker.dayOfMonth
                listener?.onDateSelected(year, month, day)
            }
        }
        dismiss()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as DateListener
    }

    fun setDate(year: Int, month: Int, day: Int) {
        yy = year.toString()
        mm = month.toString()
        dd = day.toString()
        this.check = true
    }

}