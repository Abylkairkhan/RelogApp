package kz.abyl.relogapp.presentation.sign_up

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kz.abyl.relogapp.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = koinViewModel(),
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
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
                    .padding(horizontal = 12.dp)
            ) {
                Text(
                    text = "Register",
                    fontFamily = FontFamily(Font(R.font.nunito_semibold)),
                    fontSize = 36.sp,
                    color = colorResource(id = R.color.blue)
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    singleLine = true,
                    label = {
                        Text(
                            text = "Email",
                            color = colorResource(id = R.color.blue)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.blue),
                        unfocusedBorderColor = colorResource(id = R.color.blue),
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    singleLine = true,
                    label = {
                        Text(
                            text = "Password",
                            color = colorResource(id = R.color.blue)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.blue),
                        unfocusedBorderColor = colorResource(id = R.color.blue),
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val visibilityIcon =
                            if (passwordVisibility) painterResource(id = R.drawable.visibility_off_icon) else painterResource(
                                id = R.drawable.visibility_icon
                            )
                        IconButton(
                            onClick = { passwordVisibility = !passwordVisibility }
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(32.dp),
                                painter = visibilityIcon,
                                contentDescription = "Password Visibility",
                                tint = colorResource(id = R.color.blue)
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    value = confirmPassword,
                    onValueChange = {
                        confirmPassword = it
                    },
                    singleLine = true,
                    label = {
                        Text(
                            text = "Confirm password",
                            color = colorResource(id = R.color.blue)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.blue),
                        unfocusedBorderColor = colorResource(id = R.color.blue),
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val visibilityIcon =
                            if (confirmPasswordVisibility) painterResource(id = R.drawable.visibility_off_icon) else painterResource(
                                id = R.drawable.visibility_icon
                            )
                        IconButton(
                            onClick = { confirmPasswordVisibility = !confirmPasswordVisibility }
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(32.dp),
                                painter = visibilityIcon,
                                contentDescription = "Password Visibility",
                                tint = colorResource(id = R.color.blue)
                            )
                        }
                    }
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
                        viewModel.onEvent(
                            SignUpEvent.RegisterButtonClicked(
                                email = email,
                                password = password,
                                repeatPassword = confirmPassword
                            )
                        )
                    }
                ) {
                    Text(
                        text = "Register",
                        fontFamily = FontFamily(Font(R.font.nunito_semibold)),
                        fontSize = 24.sp,
                        color = Color.White
                    )
                }
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Already Member?",
                        fontFamily = FontFamily(Font(R.font.nunito_medium)),
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(
                        modifier = Modifier
                            .clickable {
                                navController.popBackStack()
                            },
                        text = "Login",
                        fontFamily = FontFamily(Font(R.font.nunito_semibold)),
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .width(160.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .size(45.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 10.dp
                        ),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = R.drawable.google_icon),
                                contentDescription = "google_icon"
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .size(45.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 10.dp
                        ),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = R.drawable.facebook_icon),
                                contentDescription = "facebook_icon"
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .size(45.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 10.dp
                        ),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = R.drawable.apple_icon),
                                contentDescription = "apple_icon"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(
        navController = rememberNavController()
    )
}