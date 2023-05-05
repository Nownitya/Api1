package com.insurfin.api1.ui.api3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.insurfin.api1.R
import com.insurfin.api1.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater , container , false)
        return binding.root

    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_Second2Fragment)
//        }

//        val slider = binding.slider

//        slider.apply {
////            it.setValues(100f)
//            this.valueFrom = 10f
////            this.valueTo= 100f
//        }

//        slider.valueFrom = 100f
//        slider.valueFrom = 0.0f
//        slider.stepSize = 100.0f
//        slider.valueTo = 1000.0f

//        slider.also {
//            it.valueFrom = 0.0f
//            it.stepSize = 100.0f
//            it.valueTo = 1000.0f
//        }
//
//        val chipG = binding.chipG1
//        val chip1 = binding.chip1
////        val chip2 = binding.chip2
//
//        chipG.also {
//            it.check(0)
//        }
//
//        chip1.apply {
//            this.isCheckable
//        }
//
//        val panCardET = binding.panCardET
//        panCardET.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(cs: CharSequence? , start: Int , count: Int , after: Int) {
//            }
//
//            override fun onTextChanged(cs: CharSequence? , start: Int , before: Int , count: Int) {
//                val panPattern = "[A-Z]{5}[0-9]{4}[A-Z]{1}".toRegex()
//
//                val panNum = cs.toString()
//
////                if (cs.toString().length == 10) {
////                    if (!panPattern.matches(panNum)) {
////                        binding.errorBox.visibility = View.VISIBLE
////                    } else {
////                        binding.errorBox.visibility = View.INVISIBLE
////                    }
////                } else {
////                    binding.errorBox.visibility = View.VISIBLE
////                }
//
//
//            }
//
//            override fun afterTextChanged(e: Editable?) {
//                val panPattern = "[A-Z]{5}[0-9]{4}[A-Z]{1}".toRegex()
//                val panNum = e.toString()
//                if (!panPattern.matches(panNum)) {
//                    binding.errorBox.visibility = View.VISIBLE
//                } else {
//                    binding.errorBox.visibility = View.INVISIBLE
//                }
//            }
//        })



//        Log.i("SLIDER", "" )

        val progress = binding.button1
        val pass = binding.button2
        val refresh = binding.refreshIV
        val circle1 = binding.circle1
        val circle2 = binding.circle2
        val circle3 = binding.circle3
        val line1 = binding.line1
        val line2 = binding.line2

        progress.setOnClickListener {
            circle2.setImageResource(R.drawable.round1_persianblue_solid)
            circle3.setImageResource(R.drawable.round2_persian_white)
            line2.setImageResource(R.drawable.line1_persian_blue)
            progress.visibility = View.INVISIBLE
            pass.visibility = View.VISIBLE
        }
        pass.setOnClickListener {
            line1.setImageResource(R.drawable.line3_medium_sea_green)
            line2.setImageResource(R.drawable.line3_medium_sea_green)
            circle1.setImageResource(R.drawable.round4_green)
            circle2.setImageResource(R.drawable.round4_green)
            circle3.setImageResource(R.drawable.round4_green)

            refresh.visibility = View.VISIBLE
            pass.visibility = View.INVISIBLE
        }

        refresh.setOnClickListener {
            line1.setImageResource(R.drawable.line1_persian_blue)
            line2.setImageResource(R.drawable.line2_cultured)
            circle1.setImageResource(R.drawable.round1_persianblue_solid)
            circle2.setImageResource(R.drawable.round2_persian_white)
            circle3.setImageResource(R.drawable.round3_silver_sand_and_white)
            refresh.visibility = View.INVISIBLE
            progress.visibility = View.VISIBLE

        }


        binding.nextFragBT.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_datePickedFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}