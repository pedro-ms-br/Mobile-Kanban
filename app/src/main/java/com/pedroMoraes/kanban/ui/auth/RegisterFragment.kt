package com.pedroMoraes.kanban.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.pedroMoraes.kanban.R
import com.pedroMoraes.kanban.databinding.FragmentRegisterBinding
import com.pedroMoraes.kanban.util.initToolbar
import com.pedroMoraes.kanban.util.showBottomSheet


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }

    private fun initListener() {
        binding.buttonRegistrar.setOnClickListener {
            validateData()
        }
    }

    private fun validateData(){
        val email = binding.editTextEmail.text.toString().trim()
        val senha = binding.editTextSenha.text.toString().trim()

        if (email.isNotBlank()) {
            if (senha.isNotBlank()) {
                Toast.makeText(requireContext(), "Tudo Certo!", Toast.LENGTH_LONG).show()
            } else {
                showBottomSheet(message = getString(R.string.empty_password_register_fragment))
            }
        } else {
            showBottomSheet(message = getString(R.string.empty_email_register_fragment))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}