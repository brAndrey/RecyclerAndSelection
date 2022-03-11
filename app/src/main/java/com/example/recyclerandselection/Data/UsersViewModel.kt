package com.example.viewmodelkt

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UsersViewModel:ViewModel() {


    var flag:Int=0

    var userList: MutableLiveData<List<User>> = MutableLiveData()

    lateinit var userListKonst:List<User>

    var onTimeStart:String

    lateinit var ouner:String

    private var filterName:String=""

    init {
        onTimeStart = System.currentTimeMillis().toString()
        Log.i("init UsersViewModel"," "+System.currentTimeMillis() +" "+onTimeStart)
        userList.value = UserData.getUsers()
        userListKonst= UserData.getUsers()
    }

    fun setOunet(ouner:String){
        this.ouner=ouner
        Log.i("ouner"," "+ouner+"  "+flag)
    }

    @JvmName("setFilterName1")
    fun setFilterName(filterName:String){
        this.filterName=filterName
        SetValue(userListKonst)
    }

    fun getListUsers() = userList

    fun updateListUsers(){
        Log.i("updateLIstUsers"," UsersViewModel "+System.currentTimeMillis() +" "+onTimeStart+"  "+flag)
        if (flag==0)
        { SetValue(UserData.getAnotherUsers());flag=1} else {
            SetValue(UserData.getUsers());flag = 0
        }
    }

    fun SetValue(list: List<User>) {
        userListKonst=list
        userList.value=FilterName(userListKonst)
    }

    fun FilterName(list: List<User>): List<User> {

        if (!filterName.isEmpty()
        //        .equals("")
        ) {
            var resList = ArrayList<User>()
            for (user in list) {
               //гыук for ()
                  // Log.i("String","user.name - "+user.name+" filterName "+filterName)
                  // Log.i("String","startsWith - "+user.name.toLowerCase().startsWith(filterName.toLowerCase()))
                  // Log.i("String","contains - "+user.name.contains(filterName))
                if (user.name.toLowerCase().startsWith(filterName.toLowerCase()))
                    resList.add(user)
            }
            return resList
        }
        return list
    }
}