package com.iori.kotlinlab.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.iori.kotlinlab.R
import com.iori.kotlinlab.model.AppItem
import kotlinx.android.synthetic.main.activity_main.view.*


class MyAdapter(var data:List<AppItem>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {



    interface OnClickItemListener{
        fun onClickItem(appItem: AppItem)
    }

    var listener : OnClickItemListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.d(TAG,"onCreateViewHolder")
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_app,parent,false))
    }


    override fun getItemCount(): Int {
        Log.d(TAG,"${data.size}")
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG,"onBindViewHolder")
        val item = data[position]
        Glide.with(holder.ivIcon.context).load(item.url).into(holder.ivIcon)
        holder.txName.text = item.app_name

        holder.itemView.setOnClickListener { v: View? -> listener?.onClickItem(item) }
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txName: TextView = itemView.findViewById(R.id.tx_name)
        var ivIcon: ImageView = itemView.findViewById(R.id.iv_icon)
    }

    companion object {
        val TAG:String = "TEST"
    }
}