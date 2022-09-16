package com.codedeco.feature.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.codedeco.feature.main.databinding.FragmentMainBinding
import com.codedeco.framework.navigation.navigator.ActivityResultSampleNavigator
import com.codedeco.framework.navigation.navigator.ViewPagerSampleNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel by activityViewModels<MainFragmentViewModel>()

    private val activityLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        viewModel.navigatorFactory.get(ActivityResultSampleNavigator::class.java)
            ?.getResult(result.data)
            ?.run {
                Log.d("MainFragment", "onActivityResult: $this")
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.activityResultButton.setOnClickListener {
            context?.let { context ->
                viewModel.navigatorFactory.get(ActivityResultSampleNavigator::class.java)
                    ?.createIntent(context)
                    ?.run {
                        activityLauncher.launch(this)
                    }
            }
        }

        binding.viewPagerButton.setOnClickListener {
            context?.let { context ->
                viewModel.navigatorFactory.get(ViewPagerSampleNavigator::class.java)
                    ?.createIntent(context)
                    ?.run {
                        context.startActivity(this)
                    }
            }
        }
    }
}