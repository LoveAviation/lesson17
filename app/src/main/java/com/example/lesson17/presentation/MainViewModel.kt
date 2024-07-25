package com.example.lesson17.presentation

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson17.domain.UseCase
import com.example.lesson17.helper_classes.PhotosResponse
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var _photos = MutableLiveData<PhotosResponse>()
    val photos: LiveData<PhotosResponse> get() = _photos
    val useCase = UseCase()

    init {
        getPhotos()
    }

    fun getPhotos(){
        viewModelScope.launch {
            try {
                _photos.value = useCase.executeAPI()
                Log.d(TAG, "${photos.value}")
            }catch (e: Exception) {
                Log.e(TAG,"Something went wrong")
            }
        }
    }
}