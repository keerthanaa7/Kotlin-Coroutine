package com.example.asyncawaitdemo

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GetdataStructured {
    var count = 1
    lateinit var deferred:Deferred<Int>
    public suspend fun getdata():Int {
        coroutineScope {
            launch {
                delay(3000)
                count = 50
            }
            deferred = CoroutineScope(Dispatchers.IO).async {
                delay(3000)
                return@async 70
            }
        }

        return count + deferred.await()
    }

}