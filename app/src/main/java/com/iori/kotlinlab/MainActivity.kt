package com.iori.kotlinlab

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.iori.kotlinlab.adapter.MyAdapter
import com.iori.kotlinlab.model.AppItem
import com.iori.kotlinlab.model.NetRespond
import com.iori.kotlinlab.net.NetApi
import com.iori.kotlinlab.net.NetCore
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Callback
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var adapter:MyAdapter
    var data:MutableList<AppItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate")
        setContentView(R.layout.activity_main)


        fetchData()
        initView()
    }

    @SuppressLint("CheckResult")
    fun fetchData(){
        val api = NetCore.createService(NetApi::class.java)
        api.getApplist()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    for (i in it.app_list){
                        Log.d(TAG,"name:${i.app_name} url:${i.url}")
                        data.add(i)
                    }
                },{
                  it.printStackTrace()
                },{
                    Log.d(TAG,"success")
                    adapter.notifyDataSetChanged()
                })

        Service
    }

    fun initView(){
        title_view.text = "测试"

        adapter = MyAdapter(data)
        recycler_view.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        recycler_view.adapter = adapter

        adapter.listener = object : MyAdapter.OnClickItemListener{
            override fun onClickItem(appInfo: AppItem) {
                Log.d(TAG,"click $appInfo")
            }
        }



        val a:(Int,(Int)->Int) -> Unit = { c,t ->
            t(2)
            print("")
        }

        val b = a(1) { x -> x*x }

        with("String",{

        })
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

        var appInfo = AppItem("","")
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
