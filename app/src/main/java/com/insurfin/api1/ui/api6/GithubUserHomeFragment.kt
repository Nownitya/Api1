package com.insurfin.api1.ui.api6

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.insurfin.api1.databinding.FragmentGithubUserHomeBinding
import com.insurfin.api1.ui.api6.data.remote.RetrofitClient
import com.insurfin.api1.ui.api6.model.GithubUserListItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GithubUserHomeFragment : Fragment() {

    private lateinit var binding: FragmentGithubUserHomeBinding

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentGithubUserHomeBinding.inflate(inflater , container , false)
        return binding.root

    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
//
//        coroutineScope.launch{
//            try {

//                val response = RetrofitClient.apiUser.getUserList()
//                if (response.isExecuted) {
//                    for (user in response.)
//                }

                RetrofitClient.apiUser.getUserList().enqueue(object : Callback<List<GithubUserListItem>?> {
                    override fun onResponse(
                        call: Call<List<GithubUserListItem>?> ,
                        response: Response<List<GithubUserListItem>?>
                    ) {
                        if (response.isSuccessful) {
                            val userData = response.body()!!
                            Log.d("GITHUB" , "Successfully: $userData ")

                            val stringBuilder = StringBuilder()
                            userData?.forEach {user ->
                                stringBuilder.append( user.avatar_url)
                            }
                            val sb = StringBuilder()
                            for (data in userData) {
                                    sb.append(data.avatar_url)
                                    sb.append("\n")
                                    sb.append(data.events_url)
                                    sb.append("\n")
                                    sb.append(data.id)
                                    sb.append("\n")
                                    sb.append(data.followers_url)
                                    sb.append("\n")
                                    sb.append("\n")
                                }
                            binding.textviewFirst.text = sb
                            Log.d("GITHUB", sb.toString())

                        }
                    }


                    override fun onFailure(call: Call<List<GithubUserListItem>?> , t: Throwable) {

                        Log.d("GITHUB" , "OnFail" + t.message)
                    }
                })
//            }catch (e: Exception) {
//
//                Log.d("GITHUB" ,"Exception"+e.message)
//            }
//        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        coroutineScope.cancel()
    }
}
