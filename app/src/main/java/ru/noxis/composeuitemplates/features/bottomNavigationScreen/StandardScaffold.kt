package ru.noxis.composeuitemplates.features.bottomNavigationScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.FloatingActionButtonElevation
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
//import androidx.compose.material3.BottomAppBar
//import androidx.compose.material3.FabPosition
//import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.noxis.composeuitemplates.features.bottomNavigationScreen.data.BottomNavItem

@Composable
fun StandardScaffold(
    bottomNavItems: List<BottomNavItem>,
    navController: NavController,
    showBottomBar: Boolean = true,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    backgroundColor = Color(0xFFEEEEEE),
                    //cutoutShape = CircleShape,
                    elevation = 10.dp
                ) {
                    StandardBottomNavigation(
                        items = bottomNavItems,
                        navController = navController
                    )
                }
            }
        },
        floatingActionButton = {
            if (showBottomBar) {
                FloatingActionButton(
                    elevation = FloatingActionButtonDefaults.elevation(10.dp),
                    shape = RoundedCornerShape(50),
                    backgroundColor = MaterialTheme.colorScheme.primary,
                    onClick = {
                        Toast.makeText(context, "Add", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                }
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
    ) {
        Box(modifier = Modifier.padding(it)) {
            content()
        }
    }
}