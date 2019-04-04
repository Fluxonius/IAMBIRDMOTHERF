package com.example.iambirdmotherf

import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_add.*
import java.time.LocalDate

class AddActivity : AppCompatActivity(){

    var pictures = arrayOf("Bird1","Bird2","Bird3","Bird4")
    var picUrls=arrayOf("https://d1ia71hq4oe7pn.cloudfront.net/og/75335251-1200px.jpg",
        "https://www.birdlife.org/sites/default/files/styles/1600/public/news/european_turtle_dove_streptopelia_turtur_websitec_revital_salomon.jpg?itok=FaPEfAzi",
        "https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/04/10/19/pinyon-jay-bird.jpg",
        "https://content.presspage.com/uploads/1763/1920_year-of-the-bird-george-grall.jpg?10000")
    // Create an ArrayAdapter using a simple spinner layout and languages array








    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)



if(picData.text.isNotEmpty()){
        Picasso.get().load(picData.text.toString()).into(imageView)}
        addButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)

            if (nameData.text.isNotEmpty()&&tagsData.text.isNotEmpty()&&picData.text.isNotEmpty()){
                val bird=Bird(nameData.text.toString(),picData.text.toString(),tagsData.text.toString(),LocalDate.now().toString())

                //birdList.add(Bird(nameData.text.toString(),picData.text.toString(),tagsData.text.toString(),LocalDate.now().toString()))
                saveDataToJson("sBird",intent,bird)

               startActivity(intent)
        }

    }
}
    fun <T>saveDataToJson(name:String,intent: Intent,obj:T){
        val gson = Gson()
        val objString=gson.toJson(obj)
        intent.putExtra(name,objString)
    }}
