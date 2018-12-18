package com.iori.kotlinlab

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.iori.kotlinlab.adapter.MyAdapter
import com.iori.kotlinlab.model.AppInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter:MyAdapter? = null
    var data:MutableList<AppInfo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate")
        setContentView(R.layout.activity_main)

        fetchData()
        initView()
    }

    fun fetchData(){
        data.add(AppInfo("腾讯视频","http://img5.imgtn.bdimg.com/it/u=709985803,4008626984&fm=26&gp=0.jpg"))
        data.add(AppInfo("腾讯音乐","http://img5.imgtn.bdimg.com/it/u=709985803,4008626984&fm=26&gp=0.jpg"))
        data.add(AppInfo("腾讯读书","http://img5.imgtn.bdimg.com/it/u=709985803,4008626984&fm=26&gp=0.jpg"))
    }

    fun initView(){
        title_view.text = "测试"

        adapter = MyAdapter(data)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
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

        var appInfo = AppInfo("","");
        var t = appInfo.copy()
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
