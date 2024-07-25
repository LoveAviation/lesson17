package com.example.lesson17.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lesson17.databinding.ListItemBinding
import com.example.lesson17.helper_classes.Photo
import com.example.lesson17.helper_classes.PhotosResponse

class MyAdapter(
    private val context: Context,
    private var list: PhotosResponse,
    private val onClick: (Photo) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.photos.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.roverName.text = "Rover: ${list.photos[position].rover.name}"
        holder.binding.cameraName.text = "Camera: ${list.photos[position].camera?.name}"
        holder.binding.sol.text = "Sol: ${list.photos[position].sol}"
        holder.binding.earthDate.text = "Earth date: ${list.photos[position].earth_date}"
        Glide.with(context)
            .load(list.photos[position].img_src)
            .into(holder.binding.image)

        val item = list.photos[position]
        holder.itemView.setOnClickListener { onClick(item) }

    }
}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)