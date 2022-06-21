package com.example.project_views

interface RecyclerViewItemClickListener {
    fun onClickListener(data: MyObject, pos: Int)
    fun onDeleteClick(data:MyObject, pos: Int)
}