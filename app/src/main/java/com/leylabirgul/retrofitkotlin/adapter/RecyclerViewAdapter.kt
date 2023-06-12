package com.leylabirgul.retrofitkotlin.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leylabirgul.retrofitkotlin.R
import com.leylabirgul.retrofitkotlin.model.CryptoModel

class RecyclerViewAdapter(private val cryptoList : ArrayList<CryptoModel>,private val listener:Listener):RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {
    interface Listener{
        fun onItemClick(cryptoModel: CryptoModel)
    }
  private val colors:Array<String> = arrayOf("#F71308","#F79208","#E1F708","#50F708","#08F7F0","#086AF7","#9C08F7","#F708B9","#F7082C")


    class RowHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind (cryptoModel: CryptoModel,colors : Array<String>,position : Int,listener:Listener) {
            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 9]))
            itemView.text_name.text = cryptoModel.currency
            itemView.text_price.text = cryptoModel.price

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return RowHolder(view)
    }

    override fun getItemCount(): Int {
      return cryptoList.size
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position],colors,position,listener)

    }
}