package com.example.viewpager

class ArrayTest {

    //数组的定义
    var short_array: ShortArray = shortArrayOf(1, 2, 3)
    var int_array: IntArray = intArrayOf(1, 2, 3)
    var long_array: LongArray = longArrayOf(1, 2, 3)
    var float_array: FloatArray = floatArrayOf(1.0f, 2.0f, 3.0f)
    var double_array: DoubleArray = doubleArrayOf(1.0, 2.0, 3.0)
    var byte_array: ByteArray = byteArrayOf(1, 2, 3)
    var char_array: CharArray = charArrayOf('a', 'b', 'c')
    var boolean_array: BooleanArray = booleanArrayOf(true, false, true)

    //String 不是基本数据类型，所以定义方式有所不同
    var string_array: Array<String> = arrayOf("How", "Are", "You")
}