package com.insurfin.api1.ui.api4

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.insurfin.api1.databinding.FragmentPostApi1Binding
import com.insurfin.api1.ui.api4.adapter.RecyclerViewAdapter1
import com.insurfin.api1.ui.api4.data.PostApiInterface
import com.insurfin.api1.ui.api4.model.PostList1Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PostApi1Fragment : Fragment() {

    private var _binding: FragmentPostApi1Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var recyclerAdapter: RecyclerViewAdapter1
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPostApi1Binding.inflate(inflater , container , false)
        return binding.root

    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_First2Fragment_to_Second3Fragment)
//        }

        recyclerView = binding.recyclerview
        recyclerView.setHasFixedSize(true)

        progressBar = binding.progressBar

//        recyclerView.adapter= RecyclerViewAdapter1(requireContext(),)

        getPosts()

    }

    private fun getPosts() {
        progressBar.visibility = View.VISIBLE
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PostApiInterface::class.java)

        val retrofitData = retrofit.getData()
        retrofitData.enqueue(object : Callback<List<PostList1Item>?> {
            override fun onResponse(
                call: Call<List<PostList1Item>?> ,
                response: Response<List<PostList1Item>?>
            ) {
                val responseBody = response.body()!!
                recyclerAdapter = RecyclerViewAdapter1(requireContext() , responseBody)
                recyclerAdapter.notifyDataSetChanged()
                recyclerView.adapter = recyclerAdapter

                progressBar.visibility = View.GONE

            }

            override fun onFailure(call: Call<List<PostList1Item>?> , t: Throwable) {
                Log.d("API4" , "onFailure: ${t.message}")
                progressBar.visibility = View.GONE

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
}