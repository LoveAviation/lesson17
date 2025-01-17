package com.example.lesson17.helper_classes

data class PhotosResponse(
    val photos: List<Photo>
)

data class Photo(
    val id: Int,
    val sol: Int,
    val camera: Camera?,
    val img_src: String,
    val earth_date: String,
    val rover: Rover
)

data class Camera(
    val id: Int?,
    val name: String?,
    val rover_id: Int?,
    val full_name: String?
)

data class Rover(
    val id: Int,
    val name: String,
    val landing_date: String,
    val launch_date: String,
    val status: String,
    val max_sol: Int,
    val max_date: String,
    val total_photos: Int,
    val cameras: List<Camera>
)