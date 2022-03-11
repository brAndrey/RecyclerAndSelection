package com.example.fragmentexamplekt.BaseExample.Utils

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class MyObserverFragment: LifecycleEventObserver {

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.d("on Fragment",event.toString()+ " " + System.currentTimeMillis())
    }
}