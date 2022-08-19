package uz.gita.project.presenter.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.project.presenter.ViewModelIntroScreen

class ViewModelIntroScreenImpl : ViewModelIntroScreen, ViewModel() {
    override val nextPage: MutableLiveData<Unit> by lazy { MutableLiveData<Unit>() }
    override val openMainScreen: MutableLiveData<Unit> by lazy { MutableLiveData<Unit>() }

    override fun onClickNextBtn(pagePosition: Int) {
        if (pagePosition < 2) {
            nextPage.value = Unit
        } else {
            openMainScreen.value = Unit
        }
    }

}