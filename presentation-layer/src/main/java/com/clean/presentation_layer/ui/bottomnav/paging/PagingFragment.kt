package com.clean.presentation_layer.ui.bottomnav.paging

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.clean.presentation_layer.R
import com.clean.presentation_layer.base.BaseFragment
import com.clean.presentation_layer.databinding.PagingFragmentBinding
import com.clean.presentation_layer.utils.viewbinding.viewBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PagingFragment : BaseFragment(R.layout.paging_fragment) {

    private val binding by viewBinding(PagingFragmentBinding::bind)
    private val viewModel: PagingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewLifecycleOwner.lifecycleScope.launch {
//            viewModel.getUsers().collectLatest { }
//        }

    }
}