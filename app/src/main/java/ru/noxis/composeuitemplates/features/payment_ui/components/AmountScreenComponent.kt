package ru.noxis.composeuitemplates.features.payment_ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.noxis.composeuitemplates.features.payment_ui.components.Data.noRippleClickable
import ru.noxis.composeuitemplates.features.payment_ui.components.Data.tipAmounts


val YellowLight = Color(0xFFf7d452)
val GreenLight = Color(0xFF20b7b4)

@Composable
@Preview
fun HeaderCircles() {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp),
        onDraw = {
            val canvasHeight = size.height
            drawCircle(
                color = YellowLight,
                center = Offset(
                    x = 170f,
                    y = -50f
                ),
                radius = canvasHeight,
            )
            drawCircle(
                color = GreenLight,
                center = Offset(
                    x = 0f,
                    y = 0f
                ),
                radius = canvasHeight
            )
        })
}

@Composable
fun WalletAmount() {
    Column(Modifier.padding(vertical = 16.dp)) {
        Text(
            text = "Compose Wallet",
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 30.sp
        )
        Text(
            text = "$20",
            color = GreenLight,
            fontWeight = FontWeight.Bold,
            fontSize = 33.sp
        )
    }
}

@Composable
@Preview
fun AmountEnterCard() {
    var amount by remember {
        mutableStateOf("")
    }
    var selectedTips by remember {
        mutableStateOf("")
    }
    var message by remember {
        mutableStateOf("")
    }

    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            1.dp, Color.LightGray
        ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Paying to John Doe", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            AmountTextField(value = amount, onValueChange = {
                amount = it
            }, placeholder = "Enter Amount")
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Add some tips")
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                tipAmounts.forEach {
                    TipButton(title = it, isToggled = selectedTips == it) { title, change ->
                        selectedTips = if (change) {
                            title
                        } else {
                            ""
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = message, onValueChange = {
                    message = it
                }, colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.LightGray,
                    unfocusedLabelColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ), modifier = Modifier
                    .align(CenterHorizontally)
                    .background(Color.White),
                placeholder = {
                    Text(text = "Add Message")
                }
            )
        }
    }

}

@Composable
@Preview
private fun TipButton(
    title: String = "$10",
    isToggled: Boolean = false,
    onToggleChange: (String, Boolean) -> Unit = { it, change ->
    }
) {
    val color = if (isToggled) GreenLight else Color.Gray
    Card(
        shape = CircleShape,
        border = BorderStroke(1.dp, color = color),
        modifier = Modifier.noRippleClickable {
            onToggleChange(title, isToggled.not())
        }
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            color = color
        )
    }
}

@Composable
private fun AmountTextField(value: String, onValueChange: (String) -> Unit, placeholder: String) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.DarkGray,
            unfocusedLabelColor = Color.Gray,
        ),
        placeholder = {
            Text(text = placeholder, color = Color.Gray)
        },
        leadingIcon = {
            Icon(imageVector = Icons.Filled.AttachMoney, contentDescription = "Money")
        }, keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        textStyle = TextStyle(fontSize = 20.sp)
    )
}

@Composable
fun CustomizedButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = GreenLight,
            ),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            Text(text = text)
        }
    }
}

object Data {
    val tipAmounts = listOf("$10", "$20", "$30")
    inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit): Modifier =
        composed {
            clickable(indication = null,
                interactionSource = remember { MutableInteractionSource() }) {
                onClick()
            }
        }
}