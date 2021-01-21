package com.example.kakao_pay.src.login.register.input_phone.recycler_view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kakao_pay.R
import com.example.kakao_pay.src.utils.Constants.TAG

class CountryCodeRecyclerViewAdapter(countryCodeRecyclerViewInterface: ICountryCodeRecyclerView)
    : RecyclerView.Adapter<CountryCodeViewHolder>() {

    private lateinit var countryCodeTitle: String
    private var countryCodeList = ArrayList<String>()
    private var iCountryCodeRecyclerView : ICountryCodeRecyclerView? = null
    private lateinit var countryCodeItemViewHolder : CountryCodeViewHolder

    init {
        this.iCountryCodeRecyclerView = countryCodeRecyclerViewInterface
    }

    // 뷰홀더가 메모리에 올라갔을때
    // 뷰홀더와 레이아웃을 연결 시켜준다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryCodeViewHolder {
        countryCodeItemViewHolder = CountryCodeViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_country_code, parent, false)
            , this.iCountryCodeRecyclerView!!
        )
//        countryCodeItemViewHolder.bindWithView(countryCodeTitle)
//        countryCodeItemViewHolder.itemView.country_code_radio_button.isChecked = true

        return countryCodeItemViewHolder
    }

    override fun getItemCount(): Int {
        return countryCodeList.size
    }

    override fun onBindViewHolder(holder: CountryCodeViewHolder, position: Int) {
        val dataItem = this.countryCodeList[position]

        holder.bindWithView(dataItem)
    }

    // 외부에서 어답터에 문자열 배열을 넣어준다.
    fun submitCode(countryCode: String){
        countryCodeTitle = countryCode
    }

    // 외부에서 어답터에 문자열 배열을 넣어준다.
    fun submitList(countryCodeList: ArrayList<String>){
        this.countryCodeList = countryCodeList
    }
}