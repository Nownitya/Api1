package com.insurfin.api1.ui.api3

import android.app.DatePickerDialog
import android.os.Binder
import android.os.Bundle
import android.text.InputType
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialStyledDatePickerDialog
import com.insurfin.api1.R
import com.insurfin.api1.databinding.FragmentDatePickedBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

class DatePickedFragment : Fragment() {

    private lateinit var binding: FragmentDatePickedBinding

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDatePickedBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        date()

        date2()

    }

    private fun date() {

        val dobET = binding.datePicker

        dobET.inputType = InputType.TYPE_CLASS_DATETIME or InputType.TYPE_DATETIME_VARIATION_DATE
        dobET.hint = "dd/mm/yyyy"

        // Set focusable to false to prevent keyboard from popping up
        dobET.isFocusable = false
        dobET.isClickable = true
        val today = Calendar.getInstance()

        dobET.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                requireContext() ,
                { _ , year , month , dayOfMonth ->
                    val selectedDate = Calendar.getInstance().apply {
                        set(Calendar.YEAR , year)
                        set(Calendar.MONTH , month)
                        set(Calendar.DAY_OF_MONTH , dayOfMonth)
                    }
                    val age = today.get(Calendar.YEAR) - selectedDate.get(Calendar.YEAR)
                    if (age < 18) {
                        Log.e("AGE" , "You must be at least 18 years old.")
                        binding.dateOfBirthErrorTV.visibility = View.VISIBLE
                    } else {
                        binding.datePicker.setText(
                            SimpleDateFormat(
                                "dd/MM/yyyy" ,
                                Locale.getDefault()
                            ).format(selectedDate.time)
                        )
                        binding.dateOfBirthErrorTV.visibility = View.INVISIBLE
                    }
                } ,
                today.get(Calendar.YEAR) ,
                today.get(Calendar.MONTH) ,
                today.get(Calendar.DAY_OF_MONTH)
            )

            datePickerDialog.datePicker.maxDate =
                today.timeInMillis - 567648000000 // for 18 years in milliseconds
            datePickerDialog.show()


        }
    }

    private fun date2() {

        binding.datePicker2.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Date of Birth")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()

            datePicker.addOnPositiveButtonClickListener { selectedDate ->
                val calendar = Calendar.getInstance(TimeZone.getTimeZone("IST")).apply {
                    timeInMillis = selectedDate
                }
                val today = Calendar.getInstance()
                val age = today.get(Calendar.YEAR) - calendar.get(Calendar.YEAR)
                if (age < 18) {
                    Log.e("AGE" , "You must be at least 18 years old.")
                    binding.dateOfBirthErrorTV2.visibility = View.VISIBLE
                } else {
                    binding.datePicker2.setText(
                        SimpleDateFormat("dd/MM/yyyy" , Locale.getDefault()).format(calendar.time)
                    )
                    binding.dateOfBirthErrorTV2.visibility = View.INVISIBLE
                }
            }

            datePicker.show(requireActivity().supportFragmentManager , "datePicker")
        }
    }

    private fun date3(){

        val datePicker = MaterialDatePicker.Builder.dateRangePicker()
    }

    private fun date4() {
//        val datePicker =MaterialDatePicker.Builder.customDatePicker()
    }



//    private fun date2() {
//
//        val dobET = binding.datePicker2
//
//        dobET.inputType = InputType.TYPE_CLASS_DATETIME or InputType.TYPE_DATETIME_VARIATION_DATE
//        dobET.hint = "dd/mm/yyyy"
//
//        // Set focusable to false to prevent keyboard from popping up
//        dobET.isFocusable = false
//        dobET.isClickable = true
//        val today = Calendar.getInstance()
//
//        dobET.setOnClickListener {
//            val datePickerDialog = MaterialStyledDatePickerDialog(
//                requireContext(),
//                { _, year, month, dayOfMonth ->
//                    val selectedDate = Calendar.getInstance().apply {
//                        set(Calendar.YEAR, year)
//                        set(Calendar.MONTH, month)
//                        set(Calendar.DAY_OF_MONTH, dayOfMonth)
//                    }
//                    val age = today.get(Calendar.YEAR) - selectedDate.get(Calendar.YEAR)
//                    if (age < 18) {
//                        Log.e("AGE","You must be at least 18 years old.")
//                        binding.dateOfBirthErrorTV2.visibility = View.VISIBLE
//                    } else {
//                        binding.datePicker.setText(
//                            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(selectedDate.time)
//                        )
//                        binding.dateOfBirthErrorTV2.visibility = View.INVISIBLE
//                    }
//                },
//                today.get(Calendar.YEAR),
//                today.get(Calendar.MONTH),
//                today.get(Calendar.DAY_OF_MONTH)
//            )
//
//            datePickerDialog.datePicker.maxDate = today.timeInMillis - 567648000000 // for 18 years in milliseconds
//            datePickerDialog.show()
//
//
//
//        }
//    }


}