package com.idn.doadandzikir.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadandzikir.Model.DoaDanDzikirItem
import com.idn.doadandzikir.R

class DoaDanDzikirAdapter : RecyclerView.Adapter<DoaDanDzikirAdapter.DzikirViewHolder>() {

    private val listData = ArrayList<DoaDanDzikirItem>()
    fun setData(list: List<DoaDanDzikirItem>) {
        listData.clear()
        listData.addAll(list)
    }

    inner class DzikirViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTitle = view.findViewById<TextView>(R.id.tv_desc)
        val textLafaz = view.findViewById<TextView>(R.id.tv_lafaz)
        val textTransL = view.findViewById<TextView>(R.id.tv_terjemah)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DzikirViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.row_item_dzikir_doa, parent, false)
    )


    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: DzikirViewHolder, position: Int) {
        holder.apply {
            textTitle.text = listData[position].title
            textLafaz.text = listData[position].arabic
            textTransL.text = listData[position].trans
        }
    }

}
