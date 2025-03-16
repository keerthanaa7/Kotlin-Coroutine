package com.example.asyncawaitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.Main).launch {
            Log.i("MainActivity", "calculations started")
            val stock1 = async(Dispatchers.IO) { calculateStock1() }
            val stock2 = async(Dispatchers.IO) { calculateStock2() }
            val total = stock1.await() + stock2.await()
            Log.i("Main Activity ", "total stock value is ${total}")
        }
        val getdatabutton = findViewById<Button>(R.id.getDataButton)
        val tvViewOutput = findViewById<TextView>(R.id.tvViewOutput)
        val getdataUnstructured: GetdataUnstructured = GetdataUnstructured()
        val getdataStructured  = GetdataStructured()
        getdatabutton.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
               // tvViewOutput.text = getdataUnstructured.getdata().toString()
                tvViewOutput.text = getdataStructured.getdata().toString()
            }

        }
    }

}

private suspend fun calculateStock1(): Int {
    delay(10000)
    Log.i("MainActivity", "calculatestock1")
    return 1

}

private suspend fun calculateStock2(): Int {
    delay(8000)
    Log.i("MainActivity", "calculatestock2")
    return 2

}