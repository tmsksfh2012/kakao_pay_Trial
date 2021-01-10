package com.example.kakao_pay.src.login.register.phone_input.recyclerview

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kakao_pay.src.utils.Constants.TAG
import kotlinx.android.synthetic.main.item_country_code.view.*

class CountryCodeViewHolder(itemView : View, countryCodeRecyclerViewInterface: ICountryCodeRecyclerView)
    : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var myCountryCodeRecyclerViewInterface: ICountryCodeRecyclerView

    private var countryCodeTextView = itemView.country_code_text
    private val constraintCountryCodeItem = itemView.constraint_country_code_item

    init {
        Log.d(TAG, "SearchItemViewHolder - init() called")
        // 리스너 연결
        constraintCountryCodeItem.setOnClickListener(this)
        this.myCountryCodeRecyclerViewInterface = countryCodeRecyclerViewInterface
    }


    override fun onClick(v: View?) {
        when(v) {
            constraintCountryCodeItem -> {
                Log.d(TAG, "onClick: 지역번호 선택")
                this.myCountryCodeRecyclerViewInterface.onCountryCodeItemClicked(adapterPosition)
            }
        }
    }

    // 데이터와 뷰를 묶는다.
    fun bindWithView(countryCode: String){
        Log.d(TAG, "SearchItemViewHolder - bindWithView() called")

        countryCodeTextView.text = countryCode

    }

}