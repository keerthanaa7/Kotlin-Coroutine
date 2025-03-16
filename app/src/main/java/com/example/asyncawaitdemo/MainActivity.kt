package com.example.asyncawaitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    companion object{
        private val TAG = "MainActivity"
    }
    private lateinit var activityViewModel:MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      /*  val mainFragment = MainFragment()
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment())
                .commitNow()
        }*/

        activityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        activityViewModel.users.observe(this, Observer {myusers ->
            myusers.forEach { Log.d(TAG, "name is ${it.name}") }
        })


     /*   val downloadButton = findViewById<Button>(R.id.download_button)
        val incrementButton = findViewById<Button>(R.id.increment_button)
        val countText = findViewById<TextView>(R.id.count_value)
        val downloadText = findViewById<TextView>(R.id.download_data_value)*/
       /* CoroutineScope(Dispatchers.Main).launch {
            Log.d("MainActivity" , "Main thread name " + Thread.currentThread().name )
        }
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("MainACtivity" , "IO thread name " + Thread.currentThread().name )
        }*/
 /*       var count = 0

        incrementButton.setOnClickListener(View.OnClickListener {
           countText.setText(count++.toString())
        })
        downloadButton.setOnClickListener(View.OnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadData(downloadText)
            }
        })*/
       /* CoroutineScope(Dispatchers.IO).launch {
            val stock1 = async { calculateStock1() }
            val stock2 = async { calculateStock2() }
            val total = stock1.await() + stock2.await()
            Log.i("MainActivity" , "stock total + ${total}")
        }*/

       /* CoroutineScope(Dispatchers.Main).launch {
            val stock1 = async(Dispatchers.IO) { calculateStock1() }
            val stock2 = async(Dispatchers.IO) { calculateStock2() }
            val total = stock1.await() + stock2.await()
        }
*/

     /*   val getdatabutton = findViewById<Button>(R.id.getDataButton)
        val tvViewOutput = findViewById<TextView>(R.id.tvViewOutput)
        val getdataUnstructured: GetdataUnstructured = GetdataUnstructured()
        val getdataStructured  = GetdataStructured()
        getdatabutton.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
               // tvViewOutput.text = getdataUnstructured.getdata().toString()
                tvViewOutput.text = getdataStructured.getdata().toString()
            }

        }*/
    }
}

suspend fun downloadData(downloadTextview:TextView) {
    for(i in 0..20000){
        withContext(Dispatchers.Main){
            downloadTextview.text = "thread name + ${Thread.currentThread().name + i}"
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