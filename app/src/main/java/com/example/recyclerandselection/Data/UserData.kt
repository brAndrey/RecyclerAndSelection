package com.example.viewmodelkt

object UserData {
    fun getUsers() = listOf(
        User("Marilyn Monroe", "American actress, singer, model","actress"),
        User("Abraham Lincoln", "US President during American civil war","President"),
        User("Mother Teresa", "Macedonian Catholic missionary nun"),
        User("John F. Kennedy ", "US President 1961 – 1963","President")
    )

    fun getAnotherUsers() = listOf(
        User("Martin Luther King", "American civil rights campaigner"),
        User("Nelson Mandela", "South African President anti-apartheid campaigner","President"),
        User("Queen Elizabeth", "British monarch since 1954","President"),
        User("Winston Churchill", "British Prime Minister during WWII"),
        User("Donald Trump", "Businessman, US President."),
        User("Bill Gates", "American businessman, founder of Microsoft"),
        User("Muhammad Ali", "American Boxer and civil rights campaigner"),
        User("Mahatma Gandhi", "Leader of Indian independence movement"),
        User("Margaret Thatcher", "British Prime Minister 1979 – 1990"),
        User("Christopher Columbus", "Italian explorer"),
        User("Charles Darwin", "British scientist, theory of evolution"),
        User("Elvis Presley", "American musician"),
        User("Albert Einstein", "German scientist, theory of relativity"),
        User("Paul McCartney", "British musician, member of Beatles")
    )
}