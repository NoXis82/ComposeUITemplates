package ru.noxis.composeuitemplates.features.login_signup_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.noxis.composeuitemplates.R
import ru.noxis.composeuitemplates.features.login_signup_ui.components.BackButton
import ru.noxis.composeuitemplates.features.login_signup_ui.components.ContinueButtonSection
import ru.noxis.composeuitemplates.features.login_signup_ui.components.RedirectSection
import ru.noxis.composeuitemplates.features.login_signup_ui.components.SignupTextField
import ru.noxis.composeuitemplates.features.login_signup_ui.components.TitleSection
import ru.noxis.composeuitemplates.features.mainscreen.Screen

@Composable
fun SignupScreen(navController: NavController? = null, modifier: Modifier = Modifier) {
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
            TitleSection("Welcome", "Lets get started by creating your account with email")
        }
        SignupSection("Name", "Email address", "Password")
        ContinueButtonSection("Sing up", R.drawable.ic_round_arrow_forward, null)
        RedirectSection("Login") { navController?.navigate(Screen.LoginScreen.route) }
    }
}

@Composable
private fun SignupSection(
    hintName: String,
    hintEmail: String,
    hintPassword: String
) {
    Column {
        SignupTextField(name.value, { name.value = it }, "", hintName)
        Spacer(modifier = Modifier.height(12.dp))
        SignupTextField(email.value, { email.value = it }, "", hintEmail)
        Spacer(modifier = Modifier.height(12.dp))
        SignupTextField(password.value, { password.value = it }, "", hintPassword)
    }
}

@PreviewLightDark
@Composable
fun Preview() {
    SignupScreen()
}