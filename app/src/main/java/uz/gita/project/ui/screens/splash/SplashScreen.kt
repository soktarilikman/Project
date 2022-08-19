package uz.gita.project.ui.screens.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import uz.gita.project.R
import uz.gita.project.presenter.impl.ViewModelSplashScreenImpl

class SplashScreen : Fragment(R.layout.fragment_splash) {
    private val viewModel by lazy { ViewModelSplashScreenImpl() }
    private val navController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.openIntroScreen.observe(this, observerForOpenIntroScreen)
        viewModel.openMainScreen.observe(this, observerForMainScreen)

    }

    private val observerForOpenIntroScreen = Observer<Unit> {
        navController.navigate(SplashScreenDirections.actionSplashScreenToIntroScreen())
    }
    private val observerForMainScreen = Observer<Unit> {
        navController.navigate(SplashScreenDirections.actionSplashScreenToMainScreen())
    }
}