package com.byandev.mysubmissioncomposechampion.ui.screen

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.byandev.mysubmissioncomposechampion.model.Articles
import com.byandev.mysubmissioncomposechampion.ui.theme.MySubmissionComposeChampionTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val articleFake = Articles(
        author = "Andy Greenberg",
        title = "The Hunt for the Dark Web’s Biggest Kingpin, Part 4: Face to Face",
        description = "The team uses a secret technique to locate AlphaBay’s server. But just as the operation heats up, the agents have an unexpected run-in with their target.",
        url = "https://www.wired.com/story/alphabay-series-part-4-face-to-face/",
        urlToImage = "https://media.wired.com/photos/6369782f3505151fbc0b01cd/191:100/w_1280,c_limit/WI110122_EX_Tracers_AlphaBay2_01.jpg",
        publishedAt = "2022-11-15T11:00:00Z",
        content = "The answer appeared, without fanfare, on Levins screen: an AlphaBay IP address. Or rather, a handful of IP addresses that were likely to belong to the sites wallet server. A quick search revealed tha… [+4733 chars]"
    )

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MySubmissionComposeChampionTheme {
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
        TODO("Not yet implemented")
    }

    @Test
    fun perform_scroll_and_click_read_more() {
        TODO("Not yet implemented")
    }

    @Test
    fun perform_click_about_then_back_again() {
        TODO("Not yet implemented")
    }


}