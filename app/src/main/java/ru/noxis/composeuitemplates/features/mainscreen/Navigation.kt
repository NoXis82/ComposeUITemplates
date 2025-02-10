package ru.noxis.composeuitemplates.features.mainscreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.noxis.composeuitemplates.features.login_signup_ui.LoginScreen
import ru.noxis.composeuitemplates.features.login_signup_ui.SignupScreen
import ru.noxis.composeuitemplates.features.profile_ui.ProfileScreen

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
         //   ChatScreen(navController = navController)
        }
        composable(route = Screen.ProfileScreen.route){
            ProfileScreen(navController = navController, Modifier.padding(innerPadding))
        }

        composable(route = Screen.ProfileScreen2.route){
           // ProfileScreen2(navController = navController)
        }

        composable(route = Screen.EcommerceScreen.route) {
           // EcommerceHomeScreen(navController = navController)
        }
        composable(
            route = Screen.EcommerceProductScreen.route + "/{productId}",
//            arguments = listOf(
//                navArgument("productId") {
//                    type = NavType.IntType
//                }
//            )
        ) {
//            val id = it.arguments?.getInt("productId")
//            ProductScreen(navController, id!!)
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
//                PaymentScreen {
//                    navController.navigate(PaymentScreens.SuccessScreen.route)
//                }
            }

            composable(PaymentScreens.SuccessScreen.route) {
//                SuccessScreen {
//                    navController.navigate(Screen.MainScreen.route)
//                }

            }
        }

    }
}