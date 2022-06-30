package com.example.subscriptionreminder.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.subscriptionreminder.R
import com.example.subscriptionreminder.databinding.HomeCardBinding
import com.example.subscriptionreminder.infrastructure.model.Subscription
import java.util.concurrent.Flow

class HomeAdapter(val list: List<Subscription>, val requireContext: Context) : RecyclerView.Adapter<HomeAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterViewHolder =
        HomeAdapterViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.home_card, parent, false))

    override fun onBindViewHolder(holder: HomeAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class HomeAdapterViewHolder(binding: HomeCardBinding) : RecyclerView.ViewHolder(binding.root){
    val title =  binding.title
    fun bind(item: Subscription){
        title.setText(item.company)
    }
}
