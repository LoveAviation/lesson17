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

    private var _state = MutableLiveData<String>()
    val state: LiveData<String> get() = _state

    private val useCase = UseCase()

    init {
        getPhotos()
    }

    fun getPhotos(){
        viewModelScope.launch {
            _state.value = "loading"
            Log.d(TAG, "loading")
            try {
                _photos.value = useCase.executeAPI()
                _state.value = "success"
                Log.d(TAG, "success")
            }catch (e: Exception) {
                Log.e(TAG,"Something went wrong")
                _state.value = "error"
            }
        }
    }
}