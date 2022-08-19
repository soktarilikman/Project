package uz.gita.project.presenter.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.project.presenter.ViewModelSplashScreen
import uz.gita.project.sharedPref.MySharedPref

class ViewModelSplashScreenImpl : ViewModelSplashScreen, ViewModel() {
    private val sharedPref: MySharedPref by lazy { MySharedPref.getSharedPref() }
    override val openIntroScreen: MutableLiveData<Unit> by lazy { MutableLiveData<Unit>() }
    override val openMainScreen: MutableLiveData<Unit> by lazy { MutableLiveData<Unit>() }

    init {
        viewModelScope.launch {
            delay(2000)
            if (!sharedPref.isIntroOne()) {
                openIntroScreen.value = Unit
                sharedPref.setIntroOne()
            } else {
                openMainScreen.value = Unit
            }

        }
    }
}