package ru.noxis.composeuitemplates.features.chat_ui.data

import androidx.compose.runtime.mutableStateListOf

data class Chat(
    val message: String,
    val time: String,
    val isOutgoing: Boolean
)

val chats = mutableStateListOf(
    Chat("Hi", "10:00 pm", true),
    Chat("Hello", "10:00 pm", false),
    Chat("What's up", "10:02 pm", false),
    Chat("I am fine", "10:02 pm", true),
    Chat("How are you doing", "10:06 pm", true),
    Chat("I am good", "10:11 pm", false),
)
