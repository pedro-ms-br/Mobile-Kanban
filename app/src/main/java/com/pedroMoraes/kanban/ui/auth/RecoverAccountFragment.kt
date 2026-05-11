package com.pedroMoraes.kanban.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.pedroMoraes.kanban.R
import com.pedroMoraes.kanban.databinding.FragmentRecoverAccountBinding
import com.pedroMoraes.kanban.util.initToolbar
import com.pedroMoraes.kanban.util.initToolbar
import com.pedroMoraes.kanban.util.showBottomSheet


class RecoverAccountFragment : Fragment() {


    private var _binding: FragmentRecoverAccountBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoverAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }

    private fun initListener() {
        binding.buttonEnviar.setOnClickListener {
            validateData()
        }

    }

    private fun validateData(){
        val email = binding.editTextEmail.text.toString().trim()
        if (email.isNotBlank()) {
            Toast.makeText(requireContext(), "Tudo Certo!", Toast.LENGTH_LONG).show()

        } else {
            showBottomSheet(message = getString(R.string.empty_email))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
