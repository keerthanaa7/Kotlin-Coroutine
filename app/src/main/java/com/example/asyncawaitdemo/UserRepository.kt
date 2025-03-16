package com.example.asyncawaitdemo

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers():List<User>{
        delay(8000)
        val users:List<User> = listOf(
            User(1, "keer"),
            User(2, "John"),
            User(3, "Jacob"),
            User(4, "kelly")
        )
        return users
    }
}