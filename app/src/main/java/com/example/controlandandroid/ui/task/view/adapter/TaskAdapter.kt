package com.example.controlandandroid.ui.task.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.controlandandroid.R
import com.example.controlandandroid.data.model.Task
import com.example.controlandandroid.databinding.ItemTaskBinding

class TaskAdapter(
    val listener: TaskListeners
): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    interface TaskListeners{
        fun onSelectTask(task: Task)
    }

    private val taskList: MutableList<Task> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskAdapter.TaskViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TaskViewHolder(
            layoutInflater.inflate(R.layout.item_task, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: TaskAdapter.TaskViewHolder,
        position: Int
    ) = holder.bind(taskList[position])

    override fun getItemCount(): Int = taskList.size


    @SuppressLint("NotifyDataSetChanged")
    fun updateTaskList(newTaskList: List<Task>) {
        val oldTaskList = taskList.toList()
//        val differCallback = object : RecyclerViewDiffUtil<Task>(oldTaskList, newTaskList) {
//            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//                val properties1 = oldTaskList[oldItemPosition]::class.members
//
//            }
//        }
        taskList.clear()
        taskList.addAll(newTaskList)
        notifyDataSetChanged()
    }

    inner class TaskViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val binding = ItemTaskBinding.bind(view)

        fun bind(task: Task) {
            binding.itemTaskName.text = task.name
            binding.itemTaskClient.text = task.client

            binding.root.setOnClickListener {
                listener.onSelectTask(task)
            }
        }
    }
}