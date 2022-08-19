package uz.gita.project.presenter

import androidx.lifecycle.MutableLiveData

interface ViewModelSplashScreen {
    val openIntroScreen: MutableLiveData<Unit>
    val openMainScreen: MutableLiveData<Unit>
}