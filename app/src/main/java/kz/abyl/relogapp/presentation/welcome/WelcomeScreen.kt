package kz.abyl.relogapp.presentation.welcome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kz.abyl.relogapp.R
import kz.abyl.relogapp.presentation.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun WelcomeScreen(
    viewModel: WelcomeViewModel = koinViewModel(),
    navController: NavController
) {
    
    val email = viewModel.email.collectAsState()
    val signOut = viewModel.signOut.collectAsState()

    LaunchedEffect(key1 = signOut.value) {
        if(signOut.value) {
            navController.navigate(Screen.SignIn.route) {
                popUpTo(0)
            }
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.rectangle_1),
                    contentDescription = "rectangle_1",
                    contentScale = ContentScale.Crop
                )
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.rectangle_2),
                    contentDescription = "rectangle_2",
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f)
                    .padding(horizontal = 40.dp)
            ){
                Image(
                    modifier = Modifier
                        .size(height = 80.dp, width = 70.dp),
                    painter = painterResource(id = R.drawable.app_icon),
                    contentDescription = "app_icon"
                )
                Text(
                    text = "Relog",
                    fontFamily = FontFamily(Font(R.font.nunito_semibold)),
                    fontSize = 36.sp,
                    color = colorResource(id = R.color.blue)
                )
                Text(
                    text = stringResource(R.string.hello, email.value),
                    fontFamily = FontFamily(Font(R.font.nunito_medium)),
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.blue)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.20f)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.rectangle_3),
                    contentDescription = "rectangle_3",
                    contentScale = ContentScale.Crop
                )
                OutlinedButton(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color.White),
                    onClick = {
                        viewModel.signOut()
                    }
                ) {
                    Text(
                        text = stringResource(R.string.log_out),
                        fontFamily = FontFamily(Font(R.font.nunito_semibold)),
                        fontSize = 24.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(
        navController = rememberNavController()
    )

}