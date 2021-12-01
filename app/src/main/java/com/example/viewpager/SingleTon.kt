package com.example.viewpager

class SingleTon private constructor() {
    companion object {
        private var singleTon: SingleTon? = null
        fun getInstance(): SingleTon {
            if (singleTon == null) {
                synchronized(javaClass) {
                    if (singleTon == null) {
                        singleTon = SingleTon()
                    }
                }
            }
            return singleTon as SingleTon
        }
    }

    fun getS(): String {
        return "getS"
    }
}