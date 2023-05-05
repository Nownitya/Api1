package com.insurfin.api1.ui.permissions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import android.provider.Settings
import com.insurfin.api1.databinding.FragmentPermission1Binding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Permission1Fragment : Fragment() {

//    private val IMAGE_PICKER = 101
//    private val PERMISSION_REQUEST_READ_EXTERNAL_STORAGE = 102

    private var _binding: FragmentPermission1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPermission1Binding.inflate(inflater , container , false)
        return binding.root

    }
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                openGallery()
            }else {

            }

        }

    private val pickImageLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val imageUri: Uri? = result.data?.data
                binding.imageView.setImageURI(imageUri)

            }
        }




    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        binding.galleryBT.setOnClickListener {

            checkPermissions()
        }
        binding.resetPermission.setOnClickListener {
            resetPermission()
        }


    }

    private fun checkPermissions() {
        if (ContextCompat.checkSelfPermission(
                requireContext() ,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            openGallery()

        } else {
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK , MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        pickImageLauncher.launch(intent)
    }

    private fun resetPermission() {
        val settingsIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", context?.packageName  , null)
        settingsIntent.data = uri
        context?.startActivity(settingsIntent)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}