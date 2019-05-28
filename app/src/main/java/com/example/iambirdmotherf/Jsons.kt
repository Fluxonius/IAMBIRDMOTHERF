package com.example.iambirdmotherf

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Jsons {

    val gson=Gson()
    fun <T> arrayToJson(list:ArrayList<T>):String{
        val stringObj=gson.toJson(list)
        return stringObj

    }
    fun itemToJson(item:Bird):String{
        val stringObj=gson.toJson(item)
        return stringObj
    }

    fun <T> arrayFromJson(stringObj:String): T {
        val type = object : TypeToken<ArrayList<T>>(){}.type
        val list=gson.fromJson<T>(stringObj,type)
        return list
    }
    fun  itemFromJson(stringObj: String):Bird{
        val type=object :TypeToken<Bird>(){}.type
        val item=gson.fromJson<Bird>(stringObj,type)
        return item
    }

}