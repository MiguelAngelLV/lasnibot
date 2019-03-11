package org.lasni.telegram


class LasniConversation() {


    fun newMessage(message: String, username: String): String {


        return when {

            askingFor(message, GREETING) -> responseGreetings(message, username)
            askingFor(message, WORK) -> responseWorking(message, username)
            askingFor(message, MUSIC) -> responseListening(message, username)
            askingFor(message, BE_A_PAIN) -> responseBeAPainInTheNeck(message, username)

            else -> whats()


        }


    }

    private fun askingFor(message: String, list: List<String>) : Boolean {
        return list.any { message.contains(it, true) }
    }


    fun whats(): String {
        return listOf(
            """¿Qué leches es eso?""",
            """Un tortazo para ti""",
            "A PASTAR!!"

        ).random()
    }



    private fun responseGreetings(message: String, username: String): String {
        return listOf(
            "Holap ^_^",
            "Holii",
            "¿Qué pasa ahora?"
        ).random()
    }



    private fun responseWorking(message: String, username: String): String {
        return listOf(
            "Estoy poniendo un JOTA-PANEL",
            "Acabo de hacer un BOTONACO",
            "El ${listOf("dreamwaver", "netbeans", "eclipse", "git").random()} me odia"
            ).random()
    }



    private fun responseListening(message: String, username: String): String {
        return listOf(
            "Estoy escuchando kapo tecno de tíos que parecen tías",
            "78987294834 canciones y tiene que salir justo esa. MY FEEELINGSSSS",
            "Pues quería escuchar música pero se me han roto los cascos :( je..."
            ).random()
    }



    private fun askingBeAPainInTheNeck(message: String): Boolean {
        return listOf("Telegram", "Android", "el DVD-RW")
            .any { message.contains(it, true) }
    }

    private fun responseBeAPainInTheNeck(message: String, username: String): String {

        val askingFor = BE_A_PAIN.first { message.contains(it, true) }

        return listOf(
            "$username, que pesado con $askingFor, que me deje ya",
            "Que me dejeh yaaaaa",
            "No insistas más, soy una rebelde",
            "Te rajo con el $askingFor"
        ).random()
    }



    companion object {
        val BE_A_PAIN = listOf("Telegram", "Android", "DVD-RW")
        val WORK = listOf("Currando", "Curro", "Trabajo", "Que haces", "haciendo")
        val GREETING = listOf("Buenas", "Hola", "Saludos", "Nas", "Buenos")
        val MUSIC = listOf("Música", "Musica", "Escucha", "Cancion", "Canción")

    }

}