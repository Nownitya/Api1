package com.insurfin.api1.ui.permissions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.insurfin.api1.R
import com.insurfin.api1.databinding.FragmentPermissionListBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PermissionListFragment : Fragment() {

    private var _binding: FragmentPermissionListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPermissionListBinding.inflate(inflater , container , false)
        return binding.root

    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        binding.permission1BT.setOnClickListener {
            findNavController().navigate(R.id.action_permissionListFragment_to_permission1Fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}