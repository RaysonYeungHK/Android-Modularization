package com.codedeco.feature.activityresultsample

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.codedeco.feature.activityresultsample.databinding.FragmentActivityResultSampleBinding
import com.codedeco.framework.navigation.navigator.ActivityResultSampleNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityResultSampleFragment : Fragment() {
    private lateinit var binding: FragmentActivityResultSampleBinding
    private val viewModel by activityViewModels<ActivityResultSampleFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActivityResultSampleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.finishWithResultButton.setOnClickListener {
            activity?.let { activity ->
                viewModel.navigatorFactory.get(ActivityResultSampleNavigator::class.java)
                    ?.createResult(ActivityResultSampleNavigator.Result(isSuccess = true))
                    ?.run {
                        activity.setResult(Activity.RESULT_OK, this)
                        activity.finish()
                    }
            }
        }

        binding.finishWithoutResultButton.setOnClickListener {
            activity?.finish()
        }
    }
}