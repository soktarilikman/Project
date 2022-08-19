package uz.gita.project.ui.screens.intro

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.project.R
import uz.gita.project.databinding.FragmentIntroScreenBinding
import uz.gita.project.presenter.ViewModelIntroScreen
import uz.gita.project.presenter.impl.ViewModelIntroScreenImpl
import uz.gita.project.ui.screens.intro.adapters.IntroPageAdapter

class IntroScreen : Fragment(R.layout.fragment_intro_screen) {
    private val viewModel by lazy { ViewModelIntroScreenImpl() }
    private val binding: FragmentIntroScreenBinding by viewBinding()
    private val myAdapter: IntroPageAdapter by lazy { IntroPageAdapter(requireActivity()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.nextPage.observe(this, observerNextPage)
        viewModel.openMainScreen.observe(this, observerOpenMainScreen)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPagerIntro.adapter = myAdapter

        binding.dotsIndicator.attachTo(binding.viewPagerIntro)

        binding.viewPagerIntro.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (position == 2) {
                    binding.introNextBtn.apply {
                        text = "Get Started"
                    }
                } else {
                    binding.introNextBtn.apply {
                        text = "Next"
                    }
                }
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }
        })

        binding.introNextBtn.setOnClickListener {
            viewModel.onClickNextBtn(binding.viewPagerIntro.currentItem)
        }
    }

    private val observerNextPage = Observer<Unit> {
        binding.viewPagerIntro.currentItem = binding.viewPagerIntro.currentItem + 1
    }

    private val observerOpenMainScreen = Observer<Unit> {
        findNavController().navigate(IntroScreenDirections.actionIntroScreenToMainScreen())
    }

}