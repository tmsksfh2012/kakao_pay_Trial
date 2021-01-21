package com.example.kakao_pay.src.main.send.fragments.account.recycler_view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kakao_pay.src.main.send.fragments.account.models.Bank
import kotlinx.android.synthetic.main.item_bank.view.*

class BankViewHolder(itemView : View, IBankRecyclerView : IBankRecyclerView, itemClick:  (Bank) -> Unit)
    : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var myBankRecyclerViewInterface: IBankRecyclerView = IBankRecyclerView
    private var bankNameSet = itemView.text_name_bank
    val itemClicked = itemClick

    fun bindWithView(bank: Bank, bankName : String) {
        bankNameSet.text = bankName
        bankNameSet.clipToOutline = true

        // 리스너 연결
        itemView.setOnClickListener{ itemClicked(bank) }
    }

    override fun onClick(v: View?) {

    }

}