package ru.noxis.composeuitemplates.features.bottomNavigationScreen

import androidx.compose.foundation.layout.fillMaxWidth
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.noxis.composeuitemplates.features.bottomNavigationScreen.data.BottomNavItem


@Composable
fun StandardBottomNavigation(
    navController: NavController,
    items: List<BottomNavItem>,
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xFFEEEEEE),
//        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route)
                },
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = Color.Gray,
                enabled = item.icon != null,
                icon = {
                    if (item.icon != null /*&& item.selectedIcon != null*/) {
//                        var icons = painterResource(id = item.icon)
                        /*if (selected) {
                            icons = painterResource(id = item.selectedIcon)
                        }*/
                        Icon(imageVector = item.icon, contentDescription = item.contentDescription)
                    }
                }
            )
        }
    }
}