package com.byandev.mysubmissioncomposechampion

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.byandev.mysubmissioncomposechampion.model.Articles
import com.byandev.mysubmissioncomposechampion.ui.navigation.ScreenNavigation
import com.byandev.mysubmissioncomposechampion.ui.screen.AboutScreen
import com.byandev.mysubmissioncomposechampion.ui.screen.DetailScreen
import com.byandev.mysubmissioncomposechampion.ui.screen.HomeScreen
import com.byandev.mysubmissioncomposechampion.ui.theme.MySubmissionComposeChampionTheme
import com.google.gson.Gson

@Composable
fun NewsApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    when(currentRoute) {
                        ScreenNavigation.Home.route -> Text(text = "News App")
                        ScreenNavigation.Detail.route -> Text(text = "News Detail")
                        ScreenNavigation.About.route -> Text(text = "About Us")
                    }
                },
                actions = {
                    if (currentRoute != ScreenNavigation.About.route) {
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
                elevation = 10.dp
            )
        }, content = {
            Box(
                modifier = modifier
                    .padding(it)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                NavHost(
                    navController = navController,
                    startDestination = ScreenNavigation.Home.route,
                ) {
                    composable(
                        route = ScreenNavigation.Home.route
                    ) {
                        HomeScreen(
                            navigateToDetail = { articles ->
                                val stringJson = StringBuilder(Gson().toJson(articles))
                                navController.navigate(ScreenNavigation.Detail.createRoute(stringJson.toString()))
                            }
                        )
                    }
                    composable(
                        route = ScreenNavigation.Detail.route,
                        arguments = listOf(navArgument("newsData") { type = NavType.StringType }),
                    ) { nav ->
                        val articleAsJson = nav.arguments?.getString("newsData")
                        val article = Gson().fromJson(articleAsJson, Articles::class.java)
                        DetailScreen(
                            newsData = article,
                            navigateBack = {
                                navController.navigateUp()
                            },
                        )

                    }
                    composable(
                        route = ScreenNavigation.About.route
                    ) {
                        AboutScreen(
                            navigateBack = {
                                navController.navigateUp()
                            }
                        )
                    }
                }

            }
        }
    )
}

@Preview(showBackground = true, device = Devices.PIXEL_4, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NewsAppPreview() {
    MySubmissionComposeChampionTheme {
        NewsApp()
    }
}