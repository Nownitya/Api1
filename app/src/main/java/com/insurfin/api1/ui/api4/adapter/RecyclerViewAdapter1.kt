package com.insurfin.api1.ui.api4.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.insurfin.api1.R
import com.insurfin.api1.ui.api4.model.PostList1Item
import org.w3c.dom.Text

class RecyclerViewAdapter1(val context: Context , val dataList: List<PostList1Item>):RecyclerView.Adapter<RecyclerViewAdapter1.ItemViewHolder>() {

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageView)
        val userId = view.findViewById<TextView>(R.id.userIDTV)
        val title = view.findViewById<TextView>(R.id.titleTV)
        val body = view.findViewById<TextView>(R.id.bodyTV)
        val cardView = view.findViewById<CardView>(R.id.postCardView)
        val constraintLayouts = view.findViewById<ConstraintLayout>(R.id.constraintLayout)


    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_api_card_view1 , parent , false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder , position: Int) {
        val itemData = dataList[position]
        holder.userId.text = itemData.userId.toString()
        holder.title.text = itemData.title.toString()
        holder.body.text = itemData.body.toString()
        holder.cardView.setOnClickListener {
            if (!holder.constraintLayouts.isVisible) {
                holder.constraintLayouts.visibility = View.VISIBLE
            } else {
                holder.constraintLayouts.visibility = View.GONE
            }
        }
    }


}