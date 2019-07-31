package com.yf.smarttemplate.data

import android.R
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * 用于快速生成RecyclerView列表
 */
internal class SampleAdapter(private val context: Context, private val useEnglishText: Boolean = true) :
    RecyclerView.Adapter<SampleHolder>() {

    private val data by lazy {
        if (useEnglishText)
            DataProvider.getCountryEnNameList()
        else
            DataProvider.getCountryNameList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.simple_list_item_1, parent, false)
        return SampleHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SampleHolder, position: Int) {
        holder.textView.text = data[position]
    }

}

internal class SampleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView = itemView.findViewById<TextView>(R.id.text1)
}