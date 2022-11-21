package com.byandev.mysubmissioncomposechampion.ui.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.byandev.mysubmissioncomposechampion.ui.theme.MySubmissionComposeChampionTheme

@Composable
fun NewsItem(
    title: String,
    date: String,
    photoUrl: String,
    modifier: Modifier = Modifier
) {
    Row (modifier = modifier.padding(4.dp).fillMaxWidth(),) {
        AsyncImage(
            model = photoUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8))
                .fillMaxSize()
        )
        Column(
            modifier = modifier.padding(8.dp)
        ) {
            Text(
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                modifier = modifier.fillMaxWidth()
            )
            Text(
                text = date,
                style = MaterialTheme.typography.subtitle2,
                modifier = modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewsItem() {
    MySubmissionComposeChampionTheme {
        NewsItem(
            title = "Title test preview",
            date = "Date test preview",
            photoUrl = ""
        )
    }
}