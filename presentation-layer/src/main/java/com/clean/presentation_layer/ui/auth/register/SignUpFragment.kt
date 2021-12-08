package com.clean.presentation_layer.ui.auth.register

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.clean.domain_layer.model.BaseResponse
import com.clean.domain_layer.model.User
import com.clean.domain_layer.model.state.Resource
import com.clean.presentation_layer.R
import com.clean.presentation_layer.base.BaseFragment
import com.clean.presentation_layer.databinding.SignUpFragmentBinding
import com.clean.presentation_layer.ui.bottomnav.MainActivity
import com.clean.presentation_layer.utils.observe
import com.clean.presentation_layer.utils.viewbinding.viewBinding
import org.jetbrains.anko.support.v4.longToast
import org.jetbrains.anko.support.v4.startActivity

class SignUpFragment : BaseFragment(R.layout.sign_up_fragment) {

    private val binding by viewBinding(SignUpFragmentBinding::bind)
    private val viewModel: SignUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.uiState(), ::handleAuthResponse)
        with(binding) {
            signUp.setOnClickListener {
                viewModel.register(binding.nameIp.text.toString(), binding.emailIp.text.toString(), binding.passwordIp.text.toString())
            }
            loginLink.setOnClickListener { popStack() }
        }
    }

    private fun handleAuthResponse(status: Resource<BaseResponse<User?>>) {
        when (status) {
            is Resource.Loading -> {
                showLoader()
            }
            is Resource.Success -> status.data?.let {
                hideLoader()
                it.data?.let { user ->
                    viewModel.saveUser(user)
                    Log.d("handleAuthResponse", "$user")
                    startActivity<MainActivity>()
                    requireActivity().finish()
                }
            }
            is Resource.DataError -> {
                hideLoader()
                longToast(status.e.message.toString())
            }

        }
    }

}