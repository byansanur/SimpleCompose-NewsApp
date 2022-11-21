package com.byandev.mysubmissioncomposechampion.ui.widget

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.byandev.mysubmissioncomposechampion.R
import com.byandev.mysubmissioncomposechampion.ui.navigation.ScreenNavigation

@Composable
fun TopBarHome(
    modifier: Modifier = Modifier,
    title: String,
    navController: NavHostController,
    route: String?
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        actions = {
            if (route != ScreenNavigation.About.route) {
                IconButton(onClick = {
                    navController.navigate(ScreenNavigation.About.route)
                }) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = stringResource(R.string.about),
                    )
                }
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 10.dp,
    )
}

@Composable
fun TopBarNotHome(
    modifier: Modifier = Modifier,
    title: String,
    navController: NavHostController,
    route: String?
) {
    val showBackButton = rememberSaveable(inputs = arrayOf(route)) {
        when (route) {
            ScreenNavigation.Home.route -> false
            else -> true
        }
    }
    TopAppBar(
        title = {
            Text(text = title)
        },
        actions = {
            if (route != ScreenNavigation.About.route) {
                IconButton(onClick = {
                    navController.navigate(ScreenNavigation.About.route)
                }) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = stringResource(R.string.about),
                    )
                }
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 10.dp,
        navigationIcon = {
            if (showBackButton) {
                IconButton(
                    onClick = { navController.navigateUp() }
                ) { Icon(Icons.Default.ArrowBack, "Back") }
            }
        },
    )
}