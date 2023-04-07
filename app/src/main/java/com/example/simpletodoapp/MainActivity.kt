package com.example.simpletodoapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletodoapp.adapter.TodoAdapter
import com.example.simpletodoapp.databinding.ActivityMainBinding

import com.example.simpletodoapp.model.Todo

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myAdapter by lazy { TodoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todos = mutableListOf<Todo>()


        initRecyclerView(todos)

        binding.addBtn.setOnClickListener {
            val title = binding.etText.text.toString()
            if (title != ""){
                todos.add(Todo(title,false))
                myAdapter.notifyItemChanged(todos.size-1 )
            }else{
                Toast.makeText(this,"write something",Toast.LENGTH_SHORT).show()
            }
            binding.etText.text.clear()

        }
    }

    private fun initRecyclerView(todos : List<Todo>){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter
        myAdapter.setData(todos)
    }


}