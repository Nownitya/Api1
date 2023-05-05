package com.insurfin.api1.ui.api1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.insurfin.api1.ApiInterface
import com.insurfin.api1.PostDataItem
import com.insurfin.api1.databinding.FragmentSampleOneBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SampleOneFragment : Fragment() {

    private var _binding: FragmentSampleOneBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSampleOneBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }

        getData()

    }

    private fun getData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<PostDataItem>?> {
            override fun onResponse(
                call: Call<List<PostDataItem>?>,
                response: Response<List<PostDataItem>?>
            ) {
                val responseBody = response.body()!!

                val stringBuilder = StringBuilder()
                for (data in responseBody) {
                    stringBuilder.append(data.id)
                    stringBuilder.append("\n")
                    stringBuilder.append(data.userId)
                    stringBuilder.append("\n")
                    stringBuilder.append(data.title)
                    stringBuilder.append("\n")
                    stringBuilder.append(data.body)
                    stringBuilder.append("\n")
//                    stringBuilder.append(data.id)
//                    stringBuilder.append(data.id)
//                    stringBuilder.append(data.id)
                }
                binding.text1.text = stringBuilder

            }

            override fun onFailure(call: Call<List<PostDataItem>?>, t: Throwable) {
                Log.d(TAG,"OnFail"+t.message)

            }
        })

    }

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        const val TAG = "API"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}