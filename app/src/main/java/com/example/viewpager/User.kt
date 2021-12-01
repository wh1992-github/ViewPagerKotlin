package com.example.viewpager

open class User(var name: String) {//主构造函数,可以直接这么写,不必另外单独写构造方法，open代表可以被继承
init {
    this.name = name
}

//    constructor(name: String) : this() {//this() 调用主构造函数
//        this.name = name
//    }

    var nickName: String? = null
    var id: String? = null

    //    constructor(name: String) : this() {
//        this.name = name
//    }
//
    constructor(id: String, name: String) : this(name) {
        this.name = name
        this.id = id
    }
    /******************这些get set不用写，都是自动就有的，直接使用********************/
    //    var name: String
//        get() = name // 注意：这里一旦写成定值，set方法将失效，因为每次调用name实际上都是调用其get()方法的
//        set(value) {
//            // 这里可以根据需要添加各种条件判断
//            name = value
//        }
//
//    var id: String
//        get() = id
//        set(value) {
//            id = value
//        }
    /******************这些get set不用写，都是自动就有的，直接使用********************/

//静态方法的写法
    companion object {
        fun getStatic(str: String): String {
            return str + str
        }
    }
}
