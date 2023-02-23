package com.deromang.rick

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner

class App : Application(), LifecycleObserver {


    override fun onCreate() {
        super.onCreate()

        ProcessLifecycleOwner.get().lifecycle.addObserver(this)

        // Init instance
        instance = this
    }

    companion object {
        private var instance: App? = null
        fun getInstance(): App? {
            if (instance == null) {
                throw Error()
            }
            return instance
        }
    }


}