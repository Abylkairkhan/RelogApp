package kz.abyl.relogapp.presentation.sign_up

data class SignUpState(
    val success: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)