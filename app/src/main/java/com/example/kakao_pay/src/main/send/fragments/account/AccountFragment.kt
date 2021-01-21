package com.example.kakao_pay.src.main.send.fragments.account

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import com.example.kakao_pay.R
import com.example.kakao_pay.config.BaseFragment
import com.example.kakao_pay.databinding.FragmentAccountBinding
import com.example.kakao_pay.src.main.send.fragments.account.models.Bank
import com.example.kakao_pay.src.main.send.fragments.account.models.GetBankResponse
import com.example.kakao_pay.src.main.send.fragments.account.models.send_limit.Result
import com.example.kakao_pay.src.main.send.fragments.friends.IPostSendView
import com.example.kakao_pay.src.main.send.fragments.friends.SendService
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_friends.User
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_send.PostSendMoneyRequest
import com.example.kakao_pay.src.main.send.fragments.friends.models.about_send.PostSendMoneyResponse
import com.example.kakao_pay.src.utils.Constants.TAG
import com.example.kakao_pay.src.utils.OnMyTextChanged

class AccountFragment: BaseFragment<FragmentAccountBinding>(FragmentAccountBinding::bind, R.layout.fragment_account),
    OnMyTextChanged, IGetBankView, IGetSendLimitView, IPostSendView {

    lateinit var bankTitle : Bank

    lateinit var bankList : ArrayList<Bank>
    lateinit var shareList : ArrayList<Bank>
    lateinit var sendList : Result
    lateinit var account : String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        BankService(this).tryGetBanks()

        binding.textMyAccount.paint?.isUnderlineText = true
        binding.editBank.isFocusable = false
        binding.editBank.isClickable = false
        binding.editBank.setOnTouchListener { v, event -> false }

        binding.editBank.setOnClickListener {
            val bottomSheet = BankBottomSheet(this, bankList, shareList)
            bottomSheet.show(childFragmentManager, bottomSheet.tag)
        }

        binding.layoutBank.setOnClickListener {
            val bottomSheet = BankBottomSheet(this, bankList, shareList)
            bottomSheet.show(childFragmentManager, bottomSheet.tag)
        }
        binding.editAccount.onMyTextChanged {}

        binding.btnCheckAccount.setOnClickListener {
            if(binding.editAccount.text.isNotEmpty()) {
                val accountRequest = GetSendLimitRequest(
                    account = binding.editAccount.text.toString(),
                    remit_type = null
                )
                account = binding.editAccount.text.toString()

                GetSendLimitService(this).tryGetSendLimit(accountRequest)
            }
        }
    }

    override fun EditText.onMyTextChanged(completion: (Editable?) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                if(binding.editAccount.isFocused){
//                    if(binding.editAccount.text.toString().count() > 14) {
//                        binding.editAccount.setText(binding.editAccount.text.substring(0,binding.editAccount.text.toString().length-1))
//                    }
//                }
            }
        })
    }

    override fun onGetBankSuccess(response: GetBankResponse) {
        if(response.code == 1000) {
            bankList = response.result.bank_list
            shareList = response.result.share_list
        }
    }

    override fun onGetBankFailure(message: String) {
        TODO("Not yet implemented")
    }
    fun getBank(bankContent : Bank){
        bankTitle = bankContent
        binding.editBank.text =
            Editable.Factory.getInstance().newEditable(bankTitle.name)
    }

    override fun onGetSendLimitSuccess(response: GetSendLimitResponse) {
        if(response.code == 1000) {
            sendList = response.result
        }

//        FriendsBottomSheet(this, sendList )
    }

//    fun sendCheck(user: User, money : String) {
//        FriendsBottomSheetCheck(this, user, money)
//    }

    fun sendMoney(user: User, money : String) {
        val sendRequest =
            PostSendMoneyRequest(
                friend_number =  user.friend_number,
                recipient = user.name,
                image = user.user_image,
                nickname = user.nickname,
                remit_bank_name = null,
                remit_account = account,
                payment_type = "페이머니",
                amount = money,
                remit_type = sendList.remit_type

            )
        SendService(this).tryPostSend(sendRequest)
    }

    override fun onGetSendLimitFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onPostSendSuccess(response: PostSendMoneyResponse) {
        Log.d(TAG, "onPostSendSuccess: is called")
    }

    override fun onPostSendFailure(message: String) {
        TODO("Not yet implemented")
    }
}