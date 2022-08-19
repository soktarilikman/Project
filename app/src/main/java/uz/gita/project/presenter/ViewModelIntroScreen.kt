package uz.gita.project.presenter

import androidx.lifecycle.MutableLiveData

interface ViewModelIntroScreen {
    val nextPage: MutableLiveData<Unit>
    val openMainScreen: MutableLiveData<Unit>

    fun onClickNextBtn(pagePosition: Int)
}