package com.iori.kotlinlab

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test()
        // Example of a call to a native method
        sample_text.text = stringFromJNI()
    }

    fun test() {

        val rect = Rectangle(10.0,20.0)


        //对一个实例调用多个方法
        var testKotlin = TestKotlin()
        with(testKotlin){
            test()
            test1(123)
            test2(1,"8")
        }


        var num = testKotlin.parseInt("2")
        if (num != null){
            Log.d(TAG,"num is ${num * num}")
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        val TAG = "Test"
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
