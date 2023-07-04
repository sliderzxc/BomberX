package com.main.services.core

import android.util.Log

abstract class BaseService {
    private val emails = listOf("@gmail.com", "@mail.ru", "@yandex.ru")
    private val chars = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    fun generateEmail(): String {
        var email = ""
        repeat(20) { email += chars.random() }
        email += emails.random()
        Log.d("MyLog", "email: generateEmail $email")
        return email
    }

}