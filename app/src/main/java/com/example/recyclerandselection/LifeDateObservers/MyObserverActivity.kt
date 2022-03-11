package com.example.fragmentexamplekt.BaseExample.Utils

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class MyObserverActivity:LifecycleObserver {

    var objectName:String=""

    @JvmName("setObjectName1")
    fun setObjectName(name:String){this.objectName=name}

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(source: LifecycleOwner, event: Lifecycle.Event){
        if (objectName.equals(""))
        Log.d("on Activity",event.toString()+ " " + System.currentTimeMillis())
        else
            Log.d(objectName,event.toString()+ " " + System.currentTimeMillis())
    }

}