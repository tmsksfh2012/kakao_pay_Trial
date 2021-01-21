package com.example.kakao_pay.src.main.send.fragments.account.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kakao_pay.R
import com.example.kakao_pay.src.main.send.fragments.account.models.Bank

class BankRecyclerViewAdapter(iBankRecyclerView: IBankRecyclerView, val itemClick: (Bank) -> Unit) :
    RecyclerView.Adapter<BankViewHolder>() {

    var state : Boolean = true
    private var bankList = ArrayList<Bank>()
    private var shareList = ArrayList<Bank>()
    private lateinit var friendsProfileViewHolder : BankViewHolder
    private var iBankRecyclerView : IBankRecyclerView? = null

    init {
        this.iBankRecyclerView = iBankRecyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        friendsProfileViewHolder = BankViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bank, parent, false), this.iBankRecyclerView!!, itemClick)
        return friendsProfileViewHolder
    }

    override fun getItemCount(): Int {
        if (state) {
            return bankList.size
        }
        else {
            return shareList.size
        }
    }

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        if (state) {
            val dataItem = this.bankList[position]
            holder.bindWithView(dataItem, dataItem.name)
        }
        else {
            val dataItem = this.shareList[position]
            holder.bindWithView(dataItem ,dataItem.name)
        }
    }
    // 외부에서 어답터에 Bank 배열을 넣어준다.
    fun submitBank(inputBankList: ArrayList<Bank>){
        state = true
        this.bankList = inputBankList
    }

    // 외부에서 어답터에 Bank 배열을 넣어준다.
    fun submitShare(inputBankList: ArrayList<Bank>){
        state = false
        this.shareList = inputBankList
    }

}