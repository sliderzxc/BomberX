package com.main.services.some

import com.main.services.some.list.RozetkaService

class ServiceInteractor(
    private val rozetkaService: RozetkaService
) {

    fun startAttack(phone: String) {
        rozetkaService.attack(
            rozetkaData = RozetkaService.Companion.RozetkaData(phone = "+380977854850")
        ).execute()
    }
}