package com.clean.presentation_layer.ui.bottomnav.pagingroom

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.clean.presentation_layer.R
import com.clean.presentation_layer.base.BaseFragment
import com.clean.presentation_layer.databinding.PagingWithRoomFragmentBinding
import com.clean.presentation_layer.utils.viewbinding.viewBinding

class PagingWithRoomFragment : BaseFragment(R.layout.paging_with_room_fragment) {

    private val binding by viewBinding(PagingWithRoomFragmentBinding::bind)
//    private val viewModel: PagingWithRoomViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}