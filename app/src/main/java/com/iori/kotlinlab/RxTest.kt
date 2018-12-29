package com.iori.kotlinlab

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe

class RxDemo {

    @SuppressLint("CheckResult")
    fun test() {
        val array = listOf<String>("a","b","c","d")
        val o:Observable<String> = Observable.fromIterable(array)

        o.subscribe {
            print(it)
        }

        customObservableBlocking(fun(s: String): Int{
            return@customObservableBlocking 1
        })
                .subscribe(
                        {
            print(it)
        },
                        {
            it.printStackTrace()
        },
                        {
            print("complete")
        })



    }

    fun customObservableBlocking(foo:(String)->Int):Observable<String>{
        return Observable.create {
            it.onNext("a")
            it.onComplete()
        }
    }
}