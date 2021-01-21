package com.example.kakao_pay.src.main.send.fragments.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kakao_pay.R
import com.example.kakao_pay.src.main.send.fragments.account.models.Bank
import com.example.kakao_pay.src.main.send.fragments.account.recycler_view.BankRecyclerViewAdapter
import com.example.kakao_pay.src.main.send.fragments.account.recycler_view.IBankRecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_bottom_sheet_bank.view.*

class BankBottomSheet(val parentFragment : AccountFragment, var bankList : ArrayList<Bank>, var shareList : ArrayList<Bank>) : BottomSheetDialogFragment(),
    IBankRecyclerView {

    lateinit var bankContent : Bank

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
        return inflater.inflate(R.layout.dialog_bottom_sheet_bank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterBank = BankRecyclerViewAdapter(this) {
            bank -> bankContent = bank
            parentFragment.getBank(bankContent)
            dismiss()
        }
        adapterBank.submitBank(bankList)

        val adapterShare = BankRecyclerViewAdapter(this, ){
            bank -> bankContent = bank
            parentFragment.getBank(bankContent)
            dismiss()
        }
        adapterShare.submitShare(shareList)

        val myGridLayoutManagerBank = GridLayoutManager(context, 3)
        val myGridLayoutManagerShare = GridLayoutManager(context, 3)

        val bankRecycler = view.recycler_view_bank
        val shareRecycler = view.recycler_view_share

        bankRecycler.adapter = adapterBank
        shareRecycler.adapter = adapterShare

        bankRecycler.layoutManager = myGridLayoutManagerBank
        shareRecycler.layoutManager = myGridLayoutManagerShare
    }

    override fun onBankItemClicked(position: Int) : Int {
        return position
    }
}