package com.example.viewpager

import android.util.Log

class SingleTon private constructor() {
    companion object {
        val TAG = "whMainActivity"
        var singleTon: SingleTon? = null
        fun getA(): SingleTon {
            if (singleTon == null) {
                synchronized(javaClass) {
                    if (singleTon == null) {
                        singleTon = SingleTon()
                        Log.i(TAG, "singleTon = SingleTon()")
                    }
                }
            }
            return singleTon as SingleTon
        }
    }

    fun getS(): String {
        Log.i(TAG, "getS()")
        return "ssssss"
    }
}