package com.example.kakao_pay.src.main.send

import com.example.kakao_pay.src.main.send.fragments.usual.models.Bookmark

interface DeliveryData {
    fun setList()
    fun getList() : ArrayList<Bookmark>
}