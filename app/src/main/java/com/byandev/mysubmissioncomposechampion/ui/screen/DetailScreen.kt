package com.byandev.mysubmissioncomposechampion.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.byandev.mysubmissioncomposechampion.model.Articles
import com.byandev.mysubmissioncomposechampion.ui.theme.MySubmissionComposeChampionTheme

@Composable
fun DetailScreen(
    newsData: Articles,
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
) {
    DetailContent(
        articles = newsData,
        onBackClick = { navigateBack },
        modifier = modifier
    )
}

@Composable
fun DetailContent(
    articles: Articles,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    var isExpanded by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            Box {
               AsyncImage(
                   model = articles.urlToImage,
                   contentDescription = null,
                   contentScale = ContentScale.Crop,
                   modifier = Modifier
                       .size(400.dp)
                       .clip(RoundedCornerShape(8))
                       .fillMaxWidth()
               )
            }
            Spacer(modifier = modifier.height(8.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = articles.title,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                )
                Spacer(modifier = modifier.height(4.dp))
                Row {
                    Text(
                        text = articles.publishedAt,
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        text = if (articles.author != "-")" - ${articles.author}" else articles.author,
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Start,
                    )
                }
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    text = articles.description,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = articles.content,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    overflow = if (isExpanded) TextOverflow.Visible else TextOverflow.Ellipsis
                )
                Text(
                    text = if (!isExpanded) "Read More" else "",
                    color = MaterialTheme.colors.secondary,
                    modifier = modifier.clickable {
                        isExpanded = true
                    }
                )

            }
            Spacer(modifier = modifier.height(8.dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewDetailScreen() {
    MySubmissionComposeChampionTheme {
        DetailContent(
            articles = Articles(
                "aa",
                "aaa",
                "aaaa",
                "aaaaa",
                "aaaaaa",
                "aaaaaaa",
                "aaaaaaaa"
            ),
            onBackClick = {}
        )
    }
}