package com.darshan.shayariapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.darshan.shayariapp.databinding.RcvshayariBinding

class shayariAdapter : Adapter<shayariAdapter.shayariHolder>() {




    class shayariHolder(itemView: RcvshayariBinding) : ViewHolder(itemView.root) {
        var  binding = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): shayariHolder {
        var binding = RcvshayariBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return shayariHolder(binding)
    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(holder: shayariHolder, position: Int) {

    }
}