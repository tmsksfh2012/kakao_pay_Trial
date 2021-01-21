package com.example.kakao_pay.src.main.send.fragments.friends

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.bumptech.glide.Glide
import com.example.kakao_pay.R
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_friends.User
import com.example.kakao_pay.src.utils.Constants.TAG
import com.example.kakao_pay.src.utils.OnMyTextChanged
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_bottom_sheet_send.view.*
import java.text.DecimalFormat


class FriendsBottomSheet(val friendFragment: FriendFragment ,val user : User) : BottomSheetDialogFragment(), OnMyTextChanged {

    var myFormatter = DecimalFormat("#,##0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.dialog_bottom_sheet_send, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(view).load(user.user_image).into(view.img_send)
        view.img_send.background = view.context.resources.getDrawable(R.drawable.imgbox_default, null)
        view.img_send.clipToOutline = true
        view.text_name_send.text = user.nickname
        view.text_limit.text = friendFragment.gettingLimit()

        view.one.setOnClickListener {
            if(view.edit_send_money.text.toString() == 0.toString()) {
                view.edit_send_money.text =  Editable.Factory.getInstance().newEditable("1")
            }
            else {
                view.edit_send_money.setText(view.edit_send_money.text.toString() + "1")
            }
        }
        view.two.setOnClickListener {
            if(view.edit_send_money.text.toString() == 0.toString()) {
                view.edit_send_money.text =  Editable.Factory.getInstance().newEditable("2")
            }
            else {
                view.edit_send_money.setText(view.edit_send_money.text.toString() + "2")
            }
        }
        view.three.setOnClickListener {
            if(view.edit_send_money.text.toString() == 0.toString()) {
                view.edit_send_money.text =  Editable.Factory.getInstance().newEditable("3")
            }
            else {
                view.edit_send_money.setText(view.edit_send_money.text.toString() + "3")
            }
        }
        view.four.setOnClickListener {
            if(view.edit_send_money.text.toString() == 0.toString()) {
                view.edit_send_money.text =  Editable.Factory.getInstance().newEditable("4")
            }
            else {
                view.edit_send_money.setText(view.edit_send_money.text.toString() + "4")
            }
        }
        view.five.setOnClickListener {
            if(view.edit_send_money.text.toString() == 0.toString()) {
                view.edit_send_money.text =  Editable.Factory.getInstance().newEditable("5")
            }
            else {
                view.edit_send_money.setText(view.edit_send_money.text.toString() + "5")
            }
        }
        view.six.setOnClickListener {
            if(view.edit_send_money.text.toString() == 0.toString()) {
                view.edit_send_money.text =  Editable.Factory.getInstance().newEditable("6")
            }
            else {
                view.edit_send_money.setText(view.edit_send_money.text.toString() + "6")
            }
        }
        view.seven.setOnClickListener {
            if(view.edit_send_money.text.toString() == 0.toString()) {
                view.edit_send_money.text =  Editable.Factory.getInstance().newEditable("7")
            }
            else {
                view.edit_send_money.setText(view.edit_send_money.text.toString() + "7")
            }
        }
        view.eight.setOnClickListener {
            if(view.edit_send_money.text.toString() == 0.toString()) {
                view.edit_send_money.text =  Editable.Factory.getInstance().newEditable("8")
            }
            else {
                view.edit_send_money.setText(view.edit_send_money.text.toString() + "8")
            }
        }
        view.nine.setOnClickListener {
            if(view.edit_send_money.text.toString() == 0.toString()) {
                view.edit_send_money.text =  Editable.Factory.getInstance().newEditable("9")
            }
            else {
                view.edit_send_money.setText(view.edit_send_money.text.toString() + "9")
            }
        }
        view.zero.setOnClickListener {
            if(view.edit_send_money.text.toString() == 0.toString()) {
            }
            else {
                view.edit_send_money.setText(view.edit_send_money.text.toString() + "0")
            }
        }
        view.delete.setOnClickListener {
            if(view.edit_send_money.text.count() == 1) {
            }
            else {
                view.edit_send_money.setText(view.edit_send_money.text.toString().substring(0, view.edit_send_money.text.count()-1));
            }
        }
        view.my_money.setOnClickListener {
            view.edit_send_money.setText(friendFragment.gettingBalance().toString())
        }
        view.edit_send_money.onMyTextChanged {
            Log.d(TAG, "onMyTextChanged: "+view.edit_send_money.text.toString())
            if(view.edit_send_money.text.toString() == "0" ) {
                view.send_check.setBackgroundResource(R.drawable.btn_circle)
                view.send_check.setTextColor(resources.getColor(R.color.grayText, null))
            }
            else{
                view.send_check.setBackgroundResource(R.drawable.btn_circle_yellow)
                view.send_check.setTextColor(resources.getColor(R.color.black, null))
                view.send_check.text = myFormatter.format(view.send_check.text.toString())
            }
        }
        view.send_check.setOnClickListener {
            dismiss()
            if(view.edit_send_money.text.toString() != "0") {
                friendFragment.sendCheck(user, view.edit_send_money.text.toString())
            }
        }

    }

    override fun EditText.onMyTextChanged(completion: (Editable?) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (view!!.edit_send_money.isFocused) {
                    Log.d(TAG, "onTextChanged: "+view!!.edit_send_money.text.toString())
                    if (view!!.edit_send_money.text.toString() == "0") {
                        view!!.send_check.setBackgroundResource(R.drawable.btn_circle)
                        view!!.send_check.setTextColor(resources.getColor(R.color.grayText, null))
                    }
//                    else {
//                        if(view!!.edit_send_money.text.count() > 3) {
//                            val intMoney = Double.(view!!.edit_send_money.text.toString())
//                            val money = myFormatter.format(intMoney)
//                            view!!.edit_send_money.setText(money)
//                        }
                        view!!.send_check.setBackgroundResource(R.drawable.btn_circle_yellow)
                        view!!.send_check.setTextColor(resources.getColor(R.color.black, null))
//                    }
                }
            }
        })
    }

//    private fun setupFullHeight(bottomSheetDialog: BottomSheetDialog) {
//        val bottomSheet =
//            bottomSheetDialog.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
//        val behavior: BottomSheetBehavior<*> = BottomSheetBehavior.from<FrameLayout?>(bottomSheet!!)
//        val layoutParams = bottomSheet.layoutParams
//        val windowHeight = getWindowHeight()
//        if (layoutParams != null) {
//            layoutParams.height = windowHeight
//        }
//        bottomSheet.layoutParams = layoutParams
//        behavior.state = BottomSheetBehavior.STATE_EXPANDED
//    }
//
//    private fun getWindowHeight(): Int {
//        // Calculate window height for fullscreen use
//        val displayMetrics = DisplayMetrics()
//
//        (context as Activity?)!!.windowManager.defaultDisplay.getMetrics(displayMetrics)
//        context!!.display
//        return displayMetrics.heightPixels
//    }
}