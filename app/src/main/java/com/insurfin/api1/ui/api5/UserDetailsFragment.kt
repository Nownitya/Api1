package com.insurfin.api1.ui.api5

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.insurfin.api1.databinding.FragmentUserDetailsBinding
import com.insurfin.api1.ui.api4.adapter.RecyclerViewAdapter1
import com.insurfin.api1.ui.api5.adapter.UserRecyclerViewAdapter
import com.insurfin.api1.ui.api5.data.UserApiInterface
import com.insurfin.api1.ui.api5.model.UserDetailsList
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class UserDetailsFragment : Fragment() {

    private var _binding: FragmentUserDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewAdapter: UserRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentUserDetailsBinding.inflate(inflater , container , false)
        return binding.root

    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        recyclerView = binding.userRecyclerView
        recyclerView.setHasFixedSize(true)

        recyclerViewAdapter = UserRecyclerViewAdapter(emptyList())
        recyclerView.adapter = recyclerViewAdapter


        getUser()


    }

    private fun getUser() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .baseUrl(BASE_URL)
            .build()
            .create(UserApiInterface::class.java)

        val retrofitData = retrofit.getUserDetailList(1 , 6)
        retrofitData.enqueue(object : Callback<UserDetailsList?> {
            override fun onResponse(
                call: Call<UserDetailsList?> ,
                response: Response<UserDetailsList?>
            ) {
//                val responses = response.body()?.data
//                recyclerViewAdapter=UserRecyclerViewAdapter(responses!!)

                if (response.isSuccessful) {
                    val userData = response.body()?.data ?: emptyList()

                    recyclerViewAdapter.userDetailList = userData
                    recyclerViewAdapter.notifyDataSetChanged()
                }

            }

            override fun onFailure(call: Call<UserDetailsList?> , t: Throwable) {
                Log.d("API5" , "onFailure: ${t.message}")
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val BASE_URL = "https://reqres.in/api/"
    }
}