package com.pedroMoraes.kanban.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import com.pedroMoraes.kanban.R
import com.pedroMoraes.kanban.data.model.Status
import com.pedroMoraes.kanban.data.model.Task
import com.pedroMoraes.kanban.databinding.FragmentFormTaskBinding
import com.pedroMoraes.kanban.util.initToolbar
import com.pedroMoraes.kanban.util.showBottomSheet


class FormTaskFragment : Fragment() {

    private var _binding: FragmentFormTaskBinding? = null
    private val binding get() = _binding!!

    // alocacao de memoria para variavel e instanciar mais tarde
    private lateinit var task: Task
    private var newTask: Boolean = true
    private var status: Status = Status.TODO

    private lateinit var reference: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)

        // iniciando references da database
        reference = Firebase.database.reference // permite mudar as coisas na database
        auth = Firebase.auth

        initListener()
    }

    private fun initListener() {
        binding.buttonSave.setOnClickListener{
            validateData()
        }
    }

    private fun validateData(){
        val descricao = binding.editTextDescricao.text.toString().trim()

        if (descricao.isNotBlank()) {
            Toast.makeText(requireContext(), "Tudo certo!", Toast.LENGTH_LONG).show()
        } else {
                showBottomSheet(message = getString(R.string.empty_description_form_task_fragment))
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}