package com.byandev.mysubmissioncomposechampion.ui.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.byandev.mysubmissioncomposechampion.model.Articles
import com.byandev.mysubmissioncomposechampion.model.ArticlesData
import com.byandev.mysubmissioncomposechampion.ui.theme.MySubmissionComposeChampionTheme

@Composable
fun DetailScreen(
    newsData: Articles,
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
) {
    DetailContent(articles = newsData, onBackClick = { navigateBack }, modifier = modifier)
}

@Composable
fun DetailContent(
    articles: Articles,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Log.e("TAG", "DetailContent: ${articles.title}")
}

@Composable
@Preview(showBackground = true)
fun PreviewDetailScreen() {
    MySubmissionComposeChampionTheme {
        DetailContent(
            articles = Articles("aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa"),
            onBackClick = {}
        )
    }
}