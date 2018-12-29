package com.iori.kotlinlab.net

import com.iori.kotlinlab.model.NetRespond
import io.reactivex.Observable
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET

interface NetApi {

    @GET("applist")
    fun getApplist():Observable<NetRespond>
}