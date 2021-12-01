package com.example.viewpager

import android.content.Context
import android.widget.Toast

//调用直接 toast(message);
//指定了一个参数的值，就不需要在传值了
fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}
