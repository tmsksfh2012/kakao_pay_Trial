package com.example.kakao_pay.src.login

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.kakao_pay.R
import com.example.kakao_pay.src.utils.Constants.TAG
import kotlinx.android.synthetic.main.item_image.view.*

class LoginViewPagerAdapter(private val imageList : ArrayList<Int>) : PagerAdapter() {


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view ===  `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.item_image, container, false)

        view.imageView.setImageResource(imageList[position])

        container.addView(view)

        return view

    }

    override fun getCount(): Int {
        return imageList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}