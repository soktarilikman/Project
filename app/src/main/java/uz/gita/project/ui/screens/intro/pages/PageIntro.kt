package uz.gita.project.ui.screens.intro.pages

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.gita.project.R
import uz.gita.project.databinding.FragmentPageIntroBinding

class PageIntro : Fragment(R.layout.fragment_page_intro) {

    private lateinit var binding: FragmentPageIntroBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPageIntroBinding.bind(view)
//      Bu yerda manashu fragmentga berib yuborilgan qiymatni oldim,u aniq null emas deb 2 ta !! qo`ydim,chunki agar qymat topilmasa null kelishi mumkin
        val args = arguments?.getInt("pos")!!

        binding.apply {
            introTitle.text = resources.getStringArray(R.array.intro_titles)[args]
            introDescription.text = resources.getStringArray(R.array.intro_subtitles)[args]
            introImage.setImageResource(IntroImages.images[args])
        }

    }
}