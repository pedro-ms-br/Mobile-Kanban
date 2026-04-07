package com.pedroMoraes.kanban.util

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.pedroMoraes.kanban.R
import com.pedroMoraes.kanban.databinding.BottomSheetBinding


fun Fragment.initToolbar(toolbar: Toolbar) {
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title=""
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar.setNavigationOnClickListener {
        activity?.onBackPressedDispatcher?.onBackPressed()
    }

}

fun Fragment.showBottomSheet(
    titleDialog: Int? = null,
    titleButton: Int? = null,
    message: Int,
    onClick: () -> Unit ={}
) {
    val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)
    val binding: BottomSheetBinding =
                BottomSheetBinding.inflate(layoutInflater, null, false)

    binding.textViewTitle.text = getText(titleDialog ?: R.string.text_title_warning )
    binding.textViewMessage.text = getText(message)
    binding.buttonOk.text = getText(titleButton ?: R.string.text_button_warning)
    binding.buttonOk.setOnClickListener {
        // ao clicar o botao, executa o onclick e em seguita fecha a caixa de dialogo
        onClick()
        bottomSheetDialog.dismiss()
    }

    bottomSheetDialog.setContentView(binding.root)
    bottomSheetDialog.show()
}