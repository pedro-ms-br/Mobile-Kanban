package com.pedroMoraes.kanban.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.pedroMoraes.kanban.R
import com.pedroMoraes.kanban.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!


    //variavel da database

    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }


    private fun validateData() {
        val email = binding.editTextEmail.text.toString().trim()
        val senha = binding.editTextSenha.text.toString().trim()

        if (email.isNotBlank()) {
            if (senha.isNotBlank()){
                // mostrar progress bar
                binding.progressBar.isVisible = true
            } else {
                // mostra mensagem
            }
        } else {
            // coisas pra fazer se for vazio
        }
    }

    private fun registerUser(email: String, senha: String) {
        try {
            // instanciando o auth
            val auth = FirebaseAuth.getInstance()

            // criando usuario no auth
            auth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful) {
                        // encaminha para tela de home
                        findNavController().navigate(R.id.action_global_homeFragment)
                    } else {
                        //deu ruim
                        binding.progressBar.isVisible = false
                        Toast.makeText(requireContext(), task.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }.addOnFailureListener{

                }

        } catch (e: Exception) {
            Toast.makeText(requireContext(), e.message.toString(), Toast.LENGTH_SHORT).show()
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}