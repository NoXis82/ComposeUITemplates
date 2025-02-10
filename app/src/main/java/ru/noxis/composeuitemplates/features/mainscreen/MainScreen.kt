package ru.noxis.composeuitemplates.features.mainscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun MainScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn {
            items(screens) { screen ->
                Item(name = screen.name) {
                    navController.navigate(screen.route)
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun Item(
    name: String,
    onclick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        onClick = onclick
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(16.dp)
        )
    }
}


data class ScreenNames(
    val name: String,
    val route: String
)

val screens = listOf(
    ScreenNames("Chat Screen", Screen.ChatScreen.route),
    ScreenNames("Profile Screen", Screen.ProfileScreen.route),
    ScreenNames("Profile Screen 2", Screen.ProfileScreen2.route),
    ScreenNames("Ecommerce Ui", Screen.EcommerceScreen.route),
    ScreenNames("Login Signup", Screen.SignupScreen.route),
    ScreenNames("Payment Screen", Screen.PaymentScreen.route),
    ScreenNames("Bottom Navigation", Screen.BottomNavigationScreen.route)
)