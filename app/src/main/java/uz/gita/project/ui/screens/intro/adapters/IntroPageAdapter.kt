package uz.gita.project.ui.screens.intro.adapters

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.project.ui.screens.intro.pages.PageIntro

class IntroPageAdapter(fragAct: FragmentActivity) : FragmentStateAdapter(fragAct) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        val introFragment = PageIntro()
        introFragment.arguments = Bundle().apply {
            putInt("pos", position)
        }
        return introFragment
    }

}