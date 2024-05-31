package com.learning.artspaceapp.features.homeScreen.controller

import androidx.lifecycle.ViewModel
import com.learning.artspaceapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeScreenController : ViewModel() {
    private val _count = MutableStateFlow(0)
    private val _imagesResult = MutableStateFlow(R.drawable.alcatraz)
    var titleImageList = arrayOf(
        "Liberty Statue",
        "Borobudur Temple",
        "Golden Gate Bridge",
        "The Great Wall of China",
        "Alcatraz",
    )
    private val _titleImageShow = MutableStateFlow(titleImageList[0])

    val imagesResult: StateFlow<Int> = _imagesResult
    val titleResult: StateFlow<String> = _titleImageShow

    fun nextPages() {
        if (_count.value < 4) {
            _count.value++
            showData()
        }
    }

    fun previousPage() {
        if (_count.value > 0) {
            _count.value--
            showData()
        }
    }

    fun showData() {
        _imagesResult.value = when (_count.value) {
            1 -> R.drawable.liberty_statue
            2 -> R.drawable.borobudur_temple
            3 -> R.drawable.golden_gate
            4 -> R.drawable.great_wall_of_china
            else -> R.drawable.alcatraz
        }

        _titleImageShow.value = when (_count.value) {
            1 -> titleImageList[0]
            2 -> titleImageList[1]
            3 -> titleImageList[2]
            4 -> titleImageList[3]
            else -> titleImageList[4]
        }
    }


}