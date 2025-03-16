package com.example.asyncawaitdemo

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GetdataUnstructured {
    var count = 1
    public suspend fun getdata():Int {
        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            count = 50
        }
        val deferred = CoroutineScope(Dispatchers.IO).async {
            delay(3000)
            return@async 70
        }
        return count + deferred.await()
    }

}