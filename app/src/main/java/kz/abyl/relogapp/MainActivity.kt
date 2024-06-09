package kz.abyl.relogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import kz.abyl.relogapp.presentation.navigation.NavGraph
import kz.abyl.relogapp.ui.theme.RelogAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RelogAppTheme {
                val navController = rememberNavController()
                NavGraph(
                    navController = navController
                )
            }
        }
    }
}