package com.insurfin.api1.ui.api6.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.insurfin.api1.ui.api6.model.GithubUserList

class RecyclerviewAdapter(
    private val data: List<GithubUserList>
    ): RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder , position: Int) {
        TODO("Not yet implemented")
    }

}