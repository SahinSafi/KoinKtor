package com.safi.koinktor.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safi.koinktor.core.domain.usecase.UserApiUseCase
import com.safi.koinktor.core.model.entity.UserEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val userApiUseCase: UserApiUseCase) : ViewModel() {

    private val _uiState: MutableStateFlow<MainUiState<*>> = MutableStateFlow(MainUiState.Loading)
    val uiState: StateFlow<MainUiState<*>> = _uiState

    fun loadItems() {
        viewModelScope.launch {
            _uiState.value = MainUiState.Loading
            userApiUseCase.execute(Unit).fold(
                onSuccess = { users ->
                    _uiState.value = MainUiState.Success(users)
                }, onFailure = {
                    _uiState.value = MainUiState.Error(it.message?:"")
                })
        }
    }

}

sealed interface MainUiState<out Type> {
    data class Success(val data: List<UserEntity>) : MainUiState<Success>
    data class Error(val message: String) : MainUiState<Error>
    data object Loading : MainUiState<Loading>
}