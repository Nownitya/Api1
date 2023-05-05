package com.insurfin.api1.ui.api2_retrofit

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.insurfin.api1.databinding.FragmentAlbumBinding
import com.insurfin.api1.ui.api2_retrofit.retrofit.Album
import com.insurfin.api1.ui.api2_retrofit.retrofit.AlbumService
import com.insurfin.api1.ui.api2_retrofit.retrofit.RetrofitInstance
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AlbumFragment : Fragment() {

    private var _binding: FragmentAlbumBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAlbumBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }

        val retrofitService = RetrofitInstance.getRerofitInstance().create(AlbumService::class.java)

        val responseLiveData:LiveData<Response<Album>> = liveData {
            val response:Response<Album> = retrofitService.getAlbum()
            emit(response)

        }

        responseLiveData.observe(viewLifecycleOwner, Observer {
            val albumList = it.body()?.listIterator()
            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumItem = albumList.next()
                    val result =
                        " "+"Album_Title : ${albumItem.title}"+"\n"+
                        " "+"Album_ID : ${albumItem.id}"+"\n"+
                        " "+"User_ID : ${albumItem.userId}"+"\n\n\n"
                    binding.text.append(result)

                    Log.i(TAG, albumItem.title)

                }
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "ALBUM_ITEM"
    }
}