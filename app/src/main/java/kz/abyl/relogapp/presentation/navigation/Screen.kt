package kz.abyl.relogapp.presentation.navigation

sealed class Screen(val route: String) {
    data object SignUp : Screen(route = "signup_screen")
    data object SignIn : Screen(route = "signin_screen")
    data object Forgot : Screen(route = "forgot_screen")
    data object Welcome : Screen(route = "welcome_screen")
}