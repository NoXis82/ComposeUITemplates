package ru.noxis.composeuitemplates.features.login_signup_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.noxis.composeuitemplates.features.login_signup_ui.util.primaryColor
import ru.noxis.composeuitemplates.features.login_signup_ui.util.textLightColor
import ru.noxis.composeuitemplates.features.login_signup_ui.util.textWhite

@Composable
fun BackButton(
    icon: Int,
    iconDescription: String?,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(textWhite, CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = iconDescription
        )
    }
}

@Composable
fun TitleSection(
    title: String,
    description: String
) {
    Column(
        modifier = Modifier.padding(start = 4.dp)
    ) {
        Text(
            text = title,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(text = description, color = textLightColor, fontSize = 16.sp)
    }
}

@Composable
fun SignupTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    hintTitle: String,
) {
    Column{
        Text(text = hintTitle, modifier = Modifier.padding(start = 4.dp, bottom = 4.dp), color = textLightColor)
        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(text = hint)
            },
            colors = TextFieldDefaults.colors(
//                backgroundColor = textWhite,
                focusedIndicatorColor = primaryColor
            ),
            modifier = Modifier.fillMaxWidth().background(textWhite),
        )
    }
}

@Composable
fun ContinueButtonSection(
    text: String,
    icon: Int,
    iconDescription: String?
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )
        Surface(
            color = primaryColor,
            shape = CircleShape,
            tonalElevation = 8.dp
//            elevation = 8.dp
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = iconDescription,
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun RedirectSection(
    text: String,
    isForgotPassword: Boolean = false,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = primaryColor,
            modifier = Modifier.clickable(onClick = onClick)
        )
        if(isForgotPassword) {
            Text(text = "Forget password?", fontSize = 16.sp)
        }
    }
}