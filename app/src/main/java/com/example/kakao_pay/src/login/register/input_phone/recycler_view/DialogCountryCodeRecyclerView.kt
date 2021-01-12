package com.example.kakao_pay.src.login.register.input_phone.recycler_view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kakao_pay.R
import com.example.kakao_pay.src.login.register.input_phone.RegisterInputPhoneActivity
import com.example.kakao_pay.src.utils.Constants.TAG
import com.example.kakao_pay.src.utils.putUserCountryCode
import kotlinx.android.synthetic.main.dialog_country_code_collection.*

class DialogCountryCodeRecyclerView : DialogFragment(),
    ICountryCodeRecyclerView,  View.OnClickListener {

    private var countryCodeList = ArrayList<String>()
    private lateinit var countryCodeArray : Array<String>
    private lateinit var myCountryCodeRecyclerViewAdapter: CountryCodeRecyclerViewAdapter
    private lateinit var mainActivity : RegisterInputPhoneActivity
    private lateinit var callback: OnBackPressedCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        countryCodeArray = resources.getStringArray(R.array.CountryCodes)

        for (element in countryCodeArray) {
            countryCodeList.add(element)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_country_code_collection, container, false)
        isCancelable = false

        return view.rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.countryCodeRecyclerViewSetting(this.countryCodeList)
    }

    override fun onCountryCodeItemClicked(position: Int) {
        putUserCountryCode(countryCodeList[position])
        mainActivity.onDetached()
        dismiss()
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    // 리사이클러뷰 준비
    private fun countryCodeRecyclerViewSetting(countryCodeList: ArrayList<String>){
        Log.d(TAG, "countryCodeRecyclerViewSetting: called")

        //
        this.myCountryCodeRecyclerViewAdapter = CountryCodeRecyclerViewAdapter(this)

//        this.myCountryCodeRecyclerViewAdapter.submitCode(mainActivity.getCode())
        this.myCountryCodeRecyclerViewAdapter.submitList(countryCodeList)

        val myLinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        country_code_recycler_view.apply {
            layoutManager = myLinearLayoutManager
            adapter = myCountryCodeRecyclerViewAdapter
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = activity as RegisterInputPhoneActivity

        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                dismiss()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }
}