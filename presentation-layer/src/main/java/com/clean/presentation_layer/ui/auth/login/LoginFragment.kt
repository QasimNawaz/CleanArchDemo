package com.clean.presentation_layer.ui.auth.login

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.clean.domain_layer.model.BaseResponse
import com.clean.domain_layer.model.User
import com.clean.domain_layer.model.state.Resource
import com.clean.presentation_layer.R
import com.clean.presentation_layer.base.BaseFragment
import com.clean.presentation_layer.databinding.LoginFragmentBinding
import com.clean.presentation_layer.ui.bottomnav.MainActivity
import com.clean.presentation_layer.utils.observe
import com.clean.presentation_layer.utils.viewbinding.viewBinding
import org.jetbrains.anko.support.v4.longToast
import org.jetbrains.anko.support.v4.startActivity

class LoginFragment : BaseFragment(R.layout.login_fragment) {

    private val binding by viewBinding(LoginFragmentBinding::bind)
    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.uiState(), ::handleAuthResponse)
        with(binding) {
            login.setOnClickListener {
                viewModel.login(binding.emailIp.text.toString(), binding.passwordIp.text.toString())
            }
            signUpLink.setOnClickListener {
                navController.navigate(R.id.action_login_screen_to_sign_up)
            }
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