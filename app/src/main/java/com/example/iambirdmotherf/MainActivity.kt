package com.example.iambirdmotherf

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    val gson=Gson()
    var birds:ArrayList<Bird> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadDataFromJson("sBird")

        layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        adapter = RecyclerAdapter(birds)
        recycler_view.adapter = adapter


    }
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        val sBirds=gson.toJson(birds)
        outState?.putString("isBirds",sBirds)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        val sBirds = savedInstanceState?.getString("isBird")
        val type = object :TypeToken<ArrayList<Bird>>(){}.type
        if (sBirds!=null)
            birds=gson.fromJson(sBirds,type)
    }




    fun loadDataFromJson(name:String){
       val savedString= intent.getStringExtra(name)
        val type = object :TypeToken<Bird>(){}.type
        if(savedString!=null)
        birds.add(gson.fromJson<Bird>(savedString,type))
    }
   /* fun loadData(){
        val sp=getSharedPreferences("savedData", Context.MODE_PRIVATE)
        birdString=sp.getString("sBirds",gson.toJson(birds))

        val type = object :TypeToken<ArrayList<Bird>>(){}.type

        birds=gson.fromJson(birdString,type)
    }*/
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_action_info, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_about-> {
            val intentAbout = Intent(this,AddActivity::class.java)
            startActivity(intentAbout)
            true

        }
        else->false

    }}
