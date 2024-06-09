package kz.abyl.relogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import kz.abyl.relogapp.domain.usecase.CheckUserLoggedInUseCase
import kz.abyl.relogapp.presentation.navigation.NavGraph
import kz.abyl.relogapp.ui.theme.RelogAppTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    val checkUserLoggedInUseCase: CheckUserLoggedInUseCase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            val isUserLoggedIn = checkUserLoggedInUseCase.invoke()
            setContent {
                RelogAppTheme {
                    val navController = rememberNavController()
                    NavGraph(
                        navController = navController,
                        isUserLoggedIn = isUserLoggedIn
                    )
                }
            }
        }
    }
}