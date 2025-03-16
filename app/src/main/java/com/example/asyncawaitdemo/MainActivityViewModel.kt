package com.example.asyncawaitdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {
    private var userRepository:UserRepository = UserRepository()
  /*  var users:MutableLiveData<List<User>> = MutableLiveData()

    fun getUserData(){
        viewModelScope.launch {
            var result:List<User>? = null
            withContext(Dispatchers.IO){
                result = userRepository.getUsers()
            }
            users.value = result

        }
    }*/

    // live data coroutine builder
    var users = liveData<List<User>>(Dispatchers.IO) {
        var result = userRepository.getUsers()
        emit(result)
    }

}