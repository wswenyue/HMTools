package vip.wswenyue.hmtools

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "鸿蒙工具包",
    ) {
        App()
    }
}