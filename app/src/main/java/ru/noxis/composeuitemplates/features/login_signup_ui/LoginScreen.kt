package ru.noxis.composeuitemplates.features.login_signup_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.noxis.composeuitemplates.R
import ru.noxis.composeuitemplates.features.login_signup_ui.components.BackButton
import ru.noxis.composeuitemplates.features.login_signup_ui.components.ContinueButtonSection
import ru.noxis.composeuitemplates.features.login_signup_ui.components.RedirectSection
import ru.noxis.composeuitemplates.features.login_signup_ui.components.SignupTextField
import ru.noxis.composeuitemplates.features.login_signup_ui.components.TitleSection
import ru.noxis.composeuitemplates.features.login_signup_ui.util.textWhite
import ru.noxis.composeuitemplates.features.mainscreen.Screen

val name = mutableStateOf("")
val email = mutableStateOf("")
val password = mutableStateOf("")

@Composable
fun LoginScreen(navController: NavController? = null, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            BackButton(R.drawable.ic_round_arrow_back, null) {
                navController?.navigateUp()
            }
            Spacer(modifier = Modifier.height(32.dp))
            TitleSection("Welcome\nBack", "Login to your account using email")
        }
        LoginSection("Email address", "Password")
        ContinueButtonSection("Login", R.drawable.ic_round_arrow_forward, null)
        OtherOptionSection()
        RedirectSection("Sign up", true) {
            navController?.navigate(Screen.SignupScreen.route)
        }
    }
}

@Composable
private fun OtherOptionSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        OptionItem(R.drawable.google, null)
        OptionItem(R.drawable.apple, null)
        OptionItem(R.drawable.facebook, null)
    }
}

@Composable
private fun OptionItem(
    icon: Int,
    iconDescription: String?
) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .border(2.dp, textWhite, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = iconDescription,
            modifier = Modifier.size(32.dp)
        )
    }
}


@Composable
private fun LoginSection(
    hintEmail: String,
    hintPassword: String
) {
    Column {
        SignupTextField(email.value, { email.value = it }, "", hintEmail)
        Spacer(modifier = Modifier.height(12.dp))
        SignupTextField(password.value, { password.value = it }, "", hintPassword)
    }
}


@PreviewLightDark
@Composable
fun LoginPreview() {
    LoginScreen()
}