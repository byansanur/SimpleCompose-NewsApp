package com.byandev.mysubmissioncomposechampion.ui.navigation

sealed class ScreenNavigation(val route: String) {
    object Home: ScreenNavigation("home")
    object Detail: ScreenNavigation("home/detail?data={newsData}") {
        fun createRoute(newsData: String) = "home/detail?data=${newsData}"
    }
    object About: ScreenNavigation("about")
}
