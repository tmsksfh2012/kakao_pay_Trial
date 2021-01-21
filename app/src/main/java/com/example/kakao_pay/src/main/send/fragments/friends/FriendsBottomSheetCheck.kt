package com.example.kakao_pay.src.main.send.fragments.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kakao_pay.R
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_friends.User
import com.example.kakao_pay.src.utils.OnMyTextChanged
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_bottom_sheet_check.view.*

class FriendsBottomSheetCheck(val friendFragment: FriendFragment, val user : User, val money : String)  : BottomSheetDialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.dialog_bottom_sheet_check, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(view).load(user.user_image).into(view.img_check)
        view.img_check.background = view.context.resources.getDrawable(R.drawable.imgbox_default, null)
        view.text_name_check.text = user.nickname
        view.edit_check_money.setText(money)

        view.send_check.setOnClickListener {
            dismiss()
            friendFragment.sendMoney(user,  money)
        }
    }
}