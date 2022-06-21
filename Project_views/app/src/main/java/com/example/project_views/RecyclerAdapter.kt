package com.example.project_views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    val list: List<MyObject>,
    val onClickListener: RecyclerViewItemClickListener,
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.initContent(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        var layout: ConstraintLayout
        var deleteButton: ImageView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
            layout = itemView.findViewById(R.id.relativeLayout)
            deleteButton = itemView.findViewById(R.id.delete_button)
        }

        fun initContent(data: MyObject) {
            itemTitle.text = data.title
            itemDetail.text = data.description
            itemImage.setImageResource(data.image)
            layout.setOnClickListener {
                onClickListener.onClickListener(data, position)
            }
            deleteButton.setOnClickListener {
                onClickListener.onDeleteClick(data, position)
            }
        }
    }

}