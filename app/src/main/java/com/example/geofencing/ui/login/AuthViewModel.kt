package com.example.geofencing.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// 세션(로그아웃) 담당. 로그아웃 처리 후 onComplete로 화면 이동을 알린다.
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val auth: AuthRepository
) : ViewModel() {
    fun logout(onComplete: () -> Unit) {
        viewModelScope.launch {
            auth.logout()
            onComplete()
        }
    }
}
