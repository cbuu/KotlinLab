package com.iori.kotlinlab

import android.util.Log

typealias AnotherFunName = (a:Int) -> Int

object Single{
    var name:String = "haha"
}

abstract class Shape(val slides:List<Double>){
    val perimeter:Double get() = slides.sum()
    abstract fun calculateArea():Double
}

interface IRect{
    val isRect:Boolean
}

class Rectangle(var height:Double, var width:Double) :
        Shape(listOf(height,width,height,width)),
        IRect{
    override fun calculateArea()=height*width

    override val isRect: Boolean
        get() = height == width

}

interface Source<out T> {
    fun nextT(): T?
}

class NetSource : Source<Int>{
    override fun nextT(): Int? {
        return null
    }

}

class Temp<out T,in X> {
    fun nextT(): T? {return null}
}

class TestKotlin{

    companion object {
        val TAG = "Test"
    }

    fun test() {
        Log.d(TAG,"test()")
    }

    fun test1(x: Int): Int {
        Log.d(TAG, "test1() $x")
        return x
    }

    fun test2(x: Int, y: String) = x + y.toInt()

    fun parseInt(a:String):Int?{
        return a.toIntOrNull()
    }

    fun getList():List<String>{
        val list = listOf("a","b","c")
        for (i in list.indices){
            Log.d(TAG,"$i is ${list[i]}")
        }
        return list
    }

    fun switch(a:Any):Any{
        return when(a){
            1    -> "num"
            "1"  -> 1
            else -> "fuck"
        }
    }

    fun testRange() {
        val x = 10
        val y = 9
        if (x in 1..y+1) {
            println("fits in range")
        }
    }

}