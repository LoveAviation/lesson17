package com.example.lesson17.presentation

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lesson17.databinding.ListItemBinding
import com.example.lesson17.helper_classes.PhotosResponse

class MyAdapter(
    private var list: PhotosResponse
) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder { //при создании
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int { //количество элементов в списке
        return list.photos.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) { //при показе
        holder.binding.roverName.text = list.photos[position].rover.name
        holder.binding.cameraName.text = list.photos[position].camera?.name
        holder.binding.sol.text = list.photos[position].sol.toString()
        holder.binding.earthDate.text = list.photos[position].earth_date



        Glide.with(holder.binding.root)
            .load(list.photos[position].img_src)
            .into(holder.binding.image)
    }
}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)