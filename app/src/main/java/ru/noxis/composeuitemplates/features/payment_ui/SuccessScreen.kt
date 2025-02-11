package ru.noxis.composeuitemplates.features.payment_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.noxis.composeuitemplates.features.payment_ui.components.CustomizedButton
import ru.noxis.composeuitemplates.features.payment_ui.components.HeaderCircles
import ru.noxis.composeuitemplates.features.payment_ui.components.SuccessCard
import ru.noxis.composeuitemplates.ui.theme.ComposeUITemplatesTheme

@Composable
fun SuccessScreen(modifier: Modifier = Modifier,onHomeClicked:()->Unit) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(26.dp)
        ) {
            HeaderCircles()
            Spacer(modifier = Modifier.height(16.dp))
            SuccessCard()
        }
        CustomizedButton(
            modifier = Modifier.align(Alignment.BottomCenter),
            text = "Back to Home",
            onClick = onHomeClicked)
    }
}

@Preview
@Composable
private fun SuccessScreenPreview() {
    ComposeUITemplatesTheme {
        SuccessScreen {  }
    }
}