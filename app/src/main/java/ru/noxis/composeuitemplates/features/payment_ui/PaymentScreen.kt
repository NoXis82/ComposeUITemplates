package ru.noxis.composeuitemplates.features.payment_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import ru.noxis.composeuitemplates.features.payment_ui.components.AmountEnterCard
import ru.noxis.composeuitemplates.features.payment_ui.components.CustomizedButton
import ru.noxis.composeuitemplates.features.payment_ui.components.HeaderCircles
import ru.noxis.composeuitemplates.features.payment_ui.components.WalletAmount
import ru.noxis.composeuitemplates.ui.theme.ComposeUITemplatesTheme

@Composable
fun PaymentScreen(modifier: Modifier = Modifier,onPayClicked: () -> Unit) {
    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TopArea {
            HeaderCircles()
            WalletAmount()
            AmountEnterCard()
        }
        CustomizedButton(
            text = "Pay",
            onClick = onPayClicked
        )
    }
}

@Composable
private fun TopArea(content: @Composable () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        content()
    }
}

@Preview
@Composable
private fun PaymentScreenPreview() {
    ComposeUITemplatesTheme {
        PaymentScreen {  }
    }
}