//package com.example.kakao_pay.src.main.sendpage.fragments
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.kakao_pay.R
//
//class FriendAdapter : RecyclerView.Adapter<PagerViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder =
//        PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_friends, parent, false))
//
//    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
//        holder.bind(bgColors[position], position)
//    }
//
//    override fun getItemCount(): Int = bgColors.size
//}
//
//class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//    private val textView: TextView = itemView.findViewById(R.id.page_name)
//
//    fun bind(@ColorRes bgColor: Int, position: Int) {
//        textView.text = "RecyclerViewAdapter\nPage $position"
//        itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, bgColor))
//    }
//}