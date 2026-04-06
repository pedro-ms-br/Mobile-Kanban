package com.pedroMoraes.kanban.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedroMoraes.kanban.R
import com.pedroMoraes.kanban.databinding.FragmentRegisterBinding
import com.pedroMoraes.kanban.util.initToolbar


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
        initToolbar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}