package ru.noxis.composeuitemplates.features.bottomNavigationScreen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.noxis.composeuitemplates.features.bottomNavigationScreen.sample.SampleScreen1
import ru.noxis.composeuitemplates.features.bottomNavigationScreen.sample.SampleScreen2
import ru.noxis.composeuitemplates.features.bottomNavigationScreen.sample.SampleScreen3
import ru.noxis.composeuitemplates.features.bottomNavigationScreen.sample.SampleScreen4

@Composable
fun BottomNavigationScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background) {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        StandardScaffold(
            bottomNavItems = bottomNavItems,
            navController = navController,
//            showBottomBar = shouldShowBottomBar(navBackStackEntry)
        ) {
//            Navigation(navController = navController)
            NavHost(navController = navController, startDestination = "sample_screen-1" ) {
                composable(route = "sample_screen-1") {
                    SampleScreen1()
                }
                composable(route = "sample_screen-2") {
                    SampleScreen2()
                }
                composable(route = "sample_screen-3") {
                    SampleScreen3()
                }
                composable(route = "sample_screen-4") {
                    SampleScreen4()
                }
            }
        }
    }
}