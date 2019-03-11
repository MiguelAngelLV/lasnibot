package org.lasni.telegram

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

class LasniBot : TelegramLongPollingBot() {


    val lasni = LasniConversation()

    override fun getBotUsername() = "LasniBot"

    override fun getBotToken() = ""

    override fun onUpdateReceived(update: Update) {

        if (!update.hasMessage())
            return

        val username = update.message.chat.userName
        val message = update.message.text
        val response = lasni.newMessage(message, username)
        val sendMessage = SendMessage()
            .setChatId(update.message.chatId)
            .setText(response)


        println("$username: $message")
        println("Lasni: $response")

        println("--------------------------")

        sendApiMethod(sendMessage)

    }

}