package com.pedroMoraes.kanban.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedroMoraes.kanban.R
import com.pedroMoraes.kanban.data.model.Status
import com.pedroMoraes.kanban.data.model.Task
import com.pedroMoraes.kanban.databinding.FragmentDoneBinding
import com.pedroMoraes.kanban.ui.adapter.TaskAdapter

class DoneFragment : Fragment() {

    private var _binding: FragmentDoneBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerViewTask(getTask())
    }
    private fun initRecyclerViewTask(taskList: List<Task>) {

        taskAdapter = TaskAdapter(taskList)
        binding.recyclerViewTask.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTask.setHasFixedSize(true)

        binding.recyclerViewTask.adapter = taskAdapter

    }

    private fun getTask() = listOf(
        Task("2","Terminar de arrumar as malas", Status.DONE)
    )
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}