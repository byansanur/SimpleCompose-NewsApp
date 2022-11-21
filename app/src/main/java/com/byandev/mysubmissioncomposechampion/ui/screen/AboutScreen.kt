package com.byandev.mysubmissioncomposechampion.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.byandev.mysubmissioncomposechampion.ui.theme.MySubmissionComposeChampionTheme

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
) {
    AboutContent(onBackClick = { navigateBack }, modifier = modifier)
}

@Composable
fun AboutContent(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {

}

@Composable
@Preview(showBackground = true)
fun PreviewAboutScreen() {
    MySubmissionComposeChampionTheme {
        AboutContent(
            onBackClick = {}
        )
    }
}