package com.example.lesson17.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lesson17.databinding.ListItemBinding
import com.example.lesson17.helper_classes.PhotosResponse

class MyAdapter(
    private val context: Context,
    private var list: PhotosResponse
) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder { //при создании
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int { //количество элементов в списке
        return list.photos.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) { //при показе
        holder.binding.roverName.text = "Rover: ${list.photos[position].rover.name}"
        holder.binding.cameraName.text = "Camera: ${list.photos[position].camera?.name}"
        holder.binding.sol.text = "Sol: ${list.photos[position].sol}"
        holder.binding.earthDate.text = "Earth date: ${list.photos[position].earth_date}"


        Glide.with(context)
            .load(list.photos[position].img_src)
            .into(holder.binding.image)
    }
}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)