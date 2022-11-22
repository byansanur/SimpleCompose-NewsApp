package com.byandev.mysubmissioncomposechampion.ui.screen

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.byandev.mysubmissioncomposechampion.R
import com.byandev.mysubmissioncomposechampion.model.ArticlesData
import com.byandev.mysubmissioncomposechampion.ui.theme.MySubmissionComposeChampionTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    private val articleFake = ArticlesData.articleList[9]

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MySubmissionComposeChampionTheme {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())
                DetailContent(
                    articles = articleFake,
                    onBackClick = {  }
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }

    @Test
    fun make_sure_detail_content_displayed() {
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.news_image)).assertIsDisplayed()
        composeTestRule.onNodeWithText(articleFake.title).assertIsDisplayed()
        composeTestRule.onNodeWithText(articleFake.publishedAt).assertIsDisplayed()
    }

    @Test
    fun perform_click_read_more() {
        composeTestRule.onNodeWithText(articleFake.content).assertIsDisplayed()
        composeTestRule.onNodeWithTag("ReadMoreText").performClick()
    }


}