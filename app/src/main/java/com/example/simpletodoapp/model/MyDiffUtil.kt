package com.example.simpletodoapp.model

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil(
    private val oldList : List<Todo>,
    private val newList : List<Todo>
) : DiffUtil.Callback(){

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return oldList[oldItemPosition].title == newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].title != newList[newItemPosition].title -> {
                false
            }
            oldList[oldItemPosition].isChecked != newList[newItemPosition].isChecked -> {
                false
            }
            else -> true
        }
    }
}