//package com.example.kakao_pay.src.main.send.fragments
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import com.example.kakao_pay.R
//import com.google.android.material.bottomsheet.BottomSheetDialogFragment
//
//class BottomSheetFragment() : BottomSheetDialogFragment() {
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        super.onCreateView(inflater, container, savedInstanceState)
//        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
//    }
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        view?.findViewById<ViewGroup>(R.id.layout_usual)?.setOnClickListener {
//            // 선택 버튼 하이라이트
//            view?.findViewById<TextView>(R.id.usual)?.setTextColor(resources.getColor(R.color.black, null))
//            view?.findViewById<View>(R.id.usual_line)?.background = resources.getDrawable(R.drawable.rounded_black_line, null)
//
//            // 나머지 초기화
//            view?.findViewById<TextView>(R.id.account)?.setTextColor(resources.getColor(R.color.grayText, null))
//            view?.findViewById<View>(R.id.account_line)?.background = resources.getDrawable(R.drawable.rounded_white_line, null)
//
//            view?.findViewById<TextView>(R.id.recent)?.setTextColor(resources.getColor(R.color.grayText, null))
//            view?.findViewById<View>(R.id.recent_line)?.background = resources.getDrawable(R.drawable.rounded_white_line, null)
//
//            view?.findViewById<TextView>(R.id.friends)?.setTextColor(resources.getColor(R.color.grayText, null))
//            view?.findViewById<View>(R.id.friends_line)?.background = resources.getDrawable(R.drawable.rounded_white_line, null)
//        }
//        view?.findViewById<ViewGroup>(R.id.layout_recent)?.setOnClickListener {
//            // 선택 버튼 하이라이트
//            view?.findViewById<TextView>(R.id.recent)?.setTextColor(resources.getColor(R.color.black, null))
//            view?.findViewById<View>(R.id.recent_line)?.background = resources.getDrawable(R.drawable.rounded_black_line, null)
//
//            // 나머지 초기화
//            view?.findViewById<TextView>(R.id.account)?.setTextColor(resources.getColor(R.color.grayText, null))
//            view?.findViewById<View>(R.id.account_line)?.background = resources.getDrawable(R.drawable.rounded_white_line, null)
//
//            view?.findViewById<TextView>(R.id.usual)?.setTextColor(resources.getColor(R.color.grayText, null))
//            view?.findViewById<View>(R.id.usual_line)?.background = resources.getDrawable(R.drawable.rounded_white_line, null)
//
//            view?.findViewById<TextView>(R.id.friends)?.setTextColor(resources.getColor(R.color.grayText, null))
//            view?.findViewById<View>(R.id.friends_line)?.background = resources.getDrawable(R.drawable.rounded_white_line, null)
//
//        }
//        view?.findViewById<ViewGroup>(R.id.layout_friends)?.setOnClickListener {
//            // 선택 버튼 하이라이트
//            view?.findViewById<TextView>(R.id.friends)?.setTextColor(resources.getColor(R.color.black, null))
//            view?.findViewById<View>(R.id.friends_line)?.background = resources.getDrawable(R.drawable.rounded_black_line, null)
//
//            // 나머지 초기화
//            view?.findViewById<TextView>(R.id.account)?.setTextColor(resources.getColor(R.color.grayText, null))
//            view?.findViewById<View>(R.id.account_line)?.background = resources.getDrawable(R.drawable.rounded_white_line, null)
//
//            view?.findViewById<TextView>(R.id.usual)?.setTextColor(resources.getColor(R.color.grayText, null))
//            view?.findViewById<View>(R.id.usual_line)?.background = resources.getDrawable(R.drawable.rounded_white_line, null)
//
//            view?.findViewById<TextView>(R.id.recent)?.setTextColor(resources.getColor(R.color.grayText, null))
//            view?.findViewById<View>(R.id.recent_line)?.background = resources.getDrawable(R.drawable.rounded_white_line, null)
//        }
//        view?.findViewById<ViewGroup>(R.id.layout_account)?.setOnClickListener {
//            // 선택 버튼 하이라이트
//            view?.findViewById<TextView>(R.id.account)?.setTextColor(resources.getColor(R.color.black, null))
//            view?.findViewById<View>(R.id.account_line)?.background = resources.getDrawable(R.drawable.rounded_black_line, null)
//
//            // 나머지 초기화
//            view?.findViewById<TextView>(R.id.friends)?.setTextColor(resources.getColor(R.color.grayText, null))
//            view?.findViewById<View>(R.id.friends_line)?.background = resources.getDrawable(R.drawable.rounded_white_line, null)
//
//            view?.findViewById<TextView>(R.id.usual)?.setTextColor(resources.getColor(R.color.grayText, null))
//            view?.findViewById<View>(R.id.usual_line)?.background = resources.getDrawable(R.drawable.rounded_white_line, null)
//
//            view?.findViewById<TextView>(R.id.recent)?.setTextColor(resources.getColor(R.color.grayText, null))
//            view?.findViewById<View>(R.id.recent_line)?.background = resources.getDrawable(R.drawable.rounded_white_line, null)
//        }
//    }
//}