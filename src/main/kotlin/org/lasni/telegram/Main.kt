package org.lasni.telegram

import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.meta.TelegramBotsApi

fun main() {


    ApiContextInitializer.init()
    val bots = TelegramBotsApi()
    bots.registerBot(LasniBot())



}