package com.example.simpletodoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletodoapp.R
import com.example.simpletodoapp.databinding.TodoListItemBinding
import com.example.simpletodoapp.model.MyDiffUtil
import com.example.simpletodoapp.model.Todo

class TodoAdapter: RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    private var oldTodoList = emptyList<Todo>()
    inner class TodoViewHolder(val binding : TodoListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(TodoListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.todoText.text = oldTodoList[position].title
        holder.binding.todoCheckBox.isChecked = oldTodoList[position].isChecked
    }

    override fun getItemCount(): Int {
        return oldTodoList.size
    }

    fun setData(newTodoList : List<Todo>){
        val diffUtil = MyDiffUtil(oldTodoList,newTodoList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldTodoList = newTodoList
        diffResult.dispatchUpdatesTo(this)
    }

}