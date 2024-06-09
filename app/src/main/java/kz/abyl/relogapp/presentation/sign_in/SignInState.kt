package kz.abyl.relogapp.presentation.sign_in

data class SignInState (
    val success: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)