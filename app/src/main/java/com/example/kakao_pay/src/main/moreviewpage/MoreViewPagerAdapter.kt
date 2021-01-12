package com.example.kakao_pay.src.main.moreviewpage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.kakao_pay.R
import kotlinx.android.synthetic.main.item_more_view_main.view.*

class MoreViewPagerAdapter(private val imageList : ArrayList<Int>, private val stringList : ArrayList<String>)
    : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view ===  `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.item_more_view_main, container, false)

        view.img_setting_title.setImageResource(imageList[position])
        view.text_setting_title.text = stringList[position]

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