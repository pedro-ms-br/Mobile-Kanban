package com.pedroMoraes.kanban.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pedroMoraes.kanban.data.model.Task
import com.pedroMoraes.kanban.databinding.ItemTaskBinding

class TaskAdapter (
    private val taskList: List<Task>
): RecyclerView.Adapter<TaskAdapter.MyViewHolder> () {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = taskList.size

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val task = taskList[position]
        holder.binding.textDescription.text = task.description
    }

    inner class MyViewHolder(val binding : ItemTaskBinding): RecyclerView.ViewHolder(binding.root) {
        // cada item da lista

    }

}