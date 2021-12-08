package com.clean.presentation_layer.ui.bottomnav.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.clean.domain_layer.model.DataItem
import com.clean.domain_layer.usecase.users.UsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PagingViewModel @Inject constructor(
    private val usersUseCase: UsersUseCase
) : ViewModel() {

    fun getUsers(): Flow<PagingData<DataItem>> {
        return usersUseCase.execute(Unit).cachedIn(viewModelScope)
    }
}