package com.yaroslav_pys.nitrixapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yaroslav_pys.nitrixapp.data.remote.dto.VideoData
import com.yaroslav_pys.nitrixapp.domain.usecases.GetVideosInfoUseCase
import com.yaroslav_pys.nitrixapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowVideoViewModel @Inject constructor(
    private val getVideosInfoUseCase: GetVideosInfoUseCase
) : BaseViewModel() {

    private val _videos = MutableLiveData<VideoData>()
    val videos: LiveData<VideoData> get() = _videos

    fun getVideoListInfo() {
        scope.launch {
            _videos.postValue(getVideosInfoUseCase.getAllVideo())
        }
    }
}