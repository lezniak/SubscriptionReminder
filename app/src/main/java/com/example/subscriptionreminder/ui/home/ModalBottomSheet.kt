package com.example.subscriptionreminder.ui.home

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.subscriptionreminder.databinding.BottomModalHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.text.SimpleDateFormat
import java.util.*

class ModalBottomSheet  : BottomSheetDialogFragment() {
    lateinit var binding : BottomModalHomeBinding
    val myCalendar: Calendar = Calendar.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = BottomModalHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val date =


        binding.dateStart.setOnClickListener(View.OnClickListener {
            DatePickerDialog(
                requireContext(),
                date(binding.dateStart),
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        })

        binding.dateEnd.setOnClickListener(View.OnClickListener {
            DatePickerDialog(
                requireContext(),
                date(binding.dateEnd),
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        })
    }

    private fun updateLabel(editText: EditText) {
        val myFormat = "MM/dd/yy"
        val dateFormat = SimpleDateFormat(myFormat, Locale.US)
        editText.setText(dateFormat.format(myCalendar.time))
    }

    private fun date(editText: EditText):DatePickerDialog.OnDateSetListener
    = DatePickerDialog.OnDateSetListener { view, year, month, day ->
        myCalendar.set(Calendar.YEAR, year)
        myCalendar.set(Calendar.MONTH, month)
        myCalendar.set(Calendar.DAY_OF_MONTH, day)
        updateLabel(editText)
    }

}