package ru.noxis.composeuitemplates.features.mainscreen

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import ru.noxis.composeuitemplates.features.chat_ui.ChatScreen
import ru.noxis.composeuitemplates.features.ecommerce_ui.EcommerceHomeScreen
import ru.noxis.composeuitemplates.features.ecommerce_ui.ProductScreen
import ru.noxis.composeuitemplates.features.login_signup_ui.LoginScreen
import ru.noxis.composeuitemplates.features.login_signup_ui.SignupScreen
import ru.noxis.composeuitemplates.features.payment_ui.PaymentScreen
import ru.noxis.composeuitemplates.features.payment_ui.SuccessScreen
import ru.noxis.composeuitemplates.features.profile_ui.ProfileScreen
import ru.noxis.composeuitemplates.features.profile_ui_2.ProfileScreen2

@Composable
fun Navigation(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController, Modifier.padding(innerPadding))
        }
        composable(route = Screen.BottomNavigationScreen.route) {
         //   BottomNavigationScreen()
        }
        composable(route = Screen.ChatScreen.route){
            ChatScreen(Modifier.padding(innerPadding),navController = navController)
        }
        composable(route = Screen.ProfileScreen.route){
            ProfileScreen(navController = navController, Modifier.padding(innerPadding))
        }

        composable(route = Screen.ProfileScreen2.route){
            ProfileScreen2(navController = navController, Modifier.padding(innerPadding))
        }

        composable(route = Screen.EcommerceScreen.route) {
            EcommerceHomeScreen(Modifier.padding(innerPadding),navController = navController)
        }
        composable(
            route = Screen.EcommerceProductScreen.route + "/{productId}",
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("productId")
            Toast.makeText(LocalContext.current, "ProductID: $id", Toast.LENGTH_SHORT).show()
            ProductScreen(Modifier.padding(innerPadding),navController, id!!)
        }

        composable(route = Screen.SignupScreen.route) {
            SignupScreen(navController = navController, Modifier.padding(innerPadding))
        }

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController, Modifier.padding(innerPadding))
        }

        navigation(
            route = Screen.PaymentScreen.route,
            startDestination = PaymentScreens.AmountScreen.route
        ) {
            composable(PaymentScreens.AmountScreen.route) {
                PaymentScreen(modifier = Modifier.padding(innerPadding)) {
                    navController.navigate(PaymentScreens.SuccessScreen.route)
                }
            }

            composable(PaymentScreens.SuccessScreen.route) {
                SuccessScreen(Modifier.padding(innerPadding)) {
                    navController.navigate(Screen.MainScreen.route)
                }
            }
        }
    }
}