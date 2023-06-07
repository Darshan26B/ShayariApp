package com.darshan.shayariapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.darshan.shayariapp.databinding.RcvshayariBinding
import java.util.ArrayList

class shayariAdapter : Adapter<shayariAdapter.shayariHolder>() {


    var shayariList= ArrayList<ShayariModel>()

    class shayariHolder(itemView: RcvshayariBinding) : ViewHolder(itemView.root) {
        var  binding = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): shayariHolder {
        var binding = RcvshayariBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return shayariHolder(binding)
    }

    override fun getItemCount(): Int {
        return shayariList.size
    }

    override fun onBindViewHolder(holder: shayariHolder, position: Int) {
        holder.binding.apply {
            shayariList.get(position).apply {
                txtShayari.text =shayariList.toString()
            }
        }
    }

    fun setShayari(shayariList: ArrayList<ShayariModel>) {
        this.shayariList=shayariList
    }
}