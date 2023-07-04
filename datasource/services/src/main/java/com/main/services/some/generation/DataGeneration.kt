package com.main.services.some.generation

import android.util.Log
import com.github.javafaker.Faker

private val emails = listOf("@gmail.com", "@mail.ru", "@yandex.ru")
private val chars = ('a'..'z') + ('A'..'Z') + ('0'..'9')

fun Faker.generateEmail(): String {
    var email = ""
    repeat(20) { email += chars.random() }
    email += emails.random()
    Log.d("MyLog", "email: generateEmail $email")
    return email
}