package com.insurfin.api1.ui.api5.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.insurfin.api1.R
import com.insurfin.api1.ui.api5.model.Data

class UserRecyclerViewAdapter(
    var userDetailList: List<Data>
) : RecyclerView.Adapter<UserRecyclerViewAdapter.ItemViewHolder>() {


    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val avatar = view.findViewById<ImageView>(R.id.userImageIV)
        val firstName = view.findViewById<TextView>(R.id.firstNameTV)
        val lastName = view.findViewById<TextView>(R.id.lastNameTV)
        val userId = view.findViewById<TextView>(R.id.userIDTV)
        val email = view.findViewById<TextView>(R.id.emailTV)

    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_details_cardview , parent , false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userDetailList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder , position: Int) {
        val itemData = userDetailList[position]
        holder.firstName.text = itemData.first_name
        holder.lastName.text = itemData.last_name
        holder.userId.text = itemData.id.toString()
        holder.email.text = itemData.email

        Log.d("GLIDE" , itemData.avatar)

        val context = holder.itemView.context
        Glide.with(context)
            .load(itemData.avatar)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.avatar)

    }
}
