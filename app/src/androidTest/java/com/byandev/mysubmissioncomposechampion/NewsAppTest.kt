package com.byandev.mysubmissioncomposechampion

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.byandev.mysubmissioncomposechampion.model.ArticlesData
import com.byandev.mysubmissioncomposechampion.ui.navigation.ScreenNavigation
import com.byandev.mysubmissioncomposechampion.ui.theme.MySubmissionComposeChampionTheme

import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NewsAppTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MySubmissionComposeChampionTheme {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())
                NewsApp(navController = navController)
            }
        }
    }

    @Test
    fun verify_home_screen_as_start_destination() {
        navController.assertCurrentRouteName(ScreenNavigation.Home.route)
    }

    @Test
    fun perform_scroll_news_list() {
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.news_list)).performScrollToIndex(9)
    }

    @Test
    fun perform_click_news_item() {
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.news_list)).performScrollToIndex(9)
        composeTestRule.onNodeWithText(ArticlesData.articleList[9].title).performClick()
        navController.assertCurrentRouteName(ScreenNavigation.Detail.route)
    }

    @Test
    fun click_menu_about_navigate_to_about_screen() {
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.about)).performClick()
        navController.assertCurrentRouteName(ScreenNavigation.About.route)
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.my_image_profile)).assertIsDisplayed()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.my_name_is)).assertIsDisplayed()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.my_email)).assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.back)).performClick()
        navController.assertCurrentRouteName(ScreenNavigation.Home.route)
    }
}