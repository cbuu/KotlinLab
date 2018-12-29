package com.iori.kotlinlab.model

data class AppItem(val app_name:String, val url:String)

data class NetRespond(val app_list:List<AppItem>)