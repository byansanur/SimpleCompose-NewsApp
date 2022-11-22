package com.byandev.mysubmissioncomposechampion.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.byandev.mysubmissioncomposechampion.R
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
    Column(modifier = modifier.fillMaxWidth(1f)) {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.my_profile),
                    contentDescription = stringResource(R.string.my_image_profile),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(300.dp)
                        .clip(CircleShape)
                        .fillMaxWidth(),
                    alignment = Alignment.CenterStart
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    text = stringResource(R.string.my_name_is),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    modifier = modifier.testTag(stringResource(id = R.string.my_name_is))
                )
                Text(
                    text = stringResource(R.string.my_email),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                )
            }

        }
    }

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