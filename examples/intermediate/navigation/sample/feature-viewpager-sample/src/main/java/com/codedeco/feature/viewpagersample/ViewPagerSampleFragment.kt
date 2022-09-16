package com.codedeco.feature.viewpagersample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.codedeco.feature.viewpagersample.databinding.FragmentViewPagerSampleBinding
import com.codedeco.feature.viewpagersample.viewpager.ViewPagerFragmentStateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewPagerSampleFragment : Fragment() {
    private lateinit var binding: FragmentViewPagerSampleBinding
    private val viewModel by activityViewModels<ViewPagerSampleFragmentViewModel>()
    private val adapter by lazy {
        ViewPagerFragmentStateAdapter(
            this@ViewPagerSampleFragment,
            viewModel.navigatorFactory
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerSampleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = adapter
    }
}