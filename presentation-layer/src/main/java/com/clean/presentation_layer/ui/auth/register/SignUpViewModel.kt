package com.clean.presentation_layer.ui.auth.register

import androidx.lifecycle.viewModelScope
import com.clean.data_layer.local.SharedPrefs
import com.clean.domain_layer.model.BaseResponse
import com.clean.domain_layer.model.User
import com.clean.domain_layer.model.state.Resource
import com.clean.domain_layer.usecase.auth.SignUpUseCase
import com.clean.presentation_layer.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val sharedPrefs: SharedPrefs
) : BaseViewModel<Resource<BaseResponse<User?>>>() {

    //    private val authResponse = MutableLiveData<Resource<BaseResponse<User?>>>()
//    val authResponseLiveData: LiveData<Resource<BaseResponse<User?>>> get() = authResponse

    fun register(name: String, email: String, password: String) {
        viewModelScope.launch {
            uiState.value = Resource.Loading()
            signUpUseCase.execute(SignUpUseCase.Params(name, email, password)).collect {
                uiState.value = it
            }
        }
    }

    fun saveUser(user: User) {
        viewModelScope.launch {
            sharedPrefs.setUser(user)
        }
    }
}