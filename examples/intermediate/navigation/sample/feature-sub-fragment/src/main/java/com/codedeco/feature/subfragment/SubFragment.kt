package com.codedeco.feature.subfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.codedeco.feature.subfragment.databinding.FragmentSubFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubFragment : Fragment() {
    private lateinit var binding: FragmentSubFragmentBinding
    private val viewModel by activityViewModels<SubFragmentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.init(arguments)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSubFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Just make it simplest instead of using livedata
        binding.count.text = "${viewModel.count}"
    }
}