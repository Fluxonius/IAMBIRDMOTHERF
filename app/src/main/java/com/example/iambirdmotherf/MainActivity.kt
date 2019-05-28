package com.example.iambirdmotherf

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_layout.*

class MainActivity : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    val gson = Gson()
    val jsons = Jsons()
    var birds = ArrayList<Bird>()

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadDataFromJson("sBird")



        recycler_view.layoutManager = LinearLayoutManager(this)

        recycler_view.adapter = RecyclerAdapter(birds)



        val swipeHandler = object : SwipeToDeleteCallback(this) {
            override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
                val adapter = recycler_view.adapter as RecyclerAdapter
                adapter.removeAt(p0.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recycler_view)

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString("isBirds", jsons.arrayToJson(birds))

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        val sBirds = savedInstanceState?.getString("isBirds")

        if (sBirds != null)
            birds = jsons.arrayFromJson(sBirds)

    }


    fun loadDataFromJson(name: String) {
        val savedString = intent.getStringExtra(name)

        val type = object : TypeToken<ArrayList<Bird>>() {}.type

        if (savedString != null)
            birds = gson.fromJson(savedString, type)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_action_info, menu)
        return true
    }

    fun <T> toJson(list: ArrayList<T>): String {
        val objString = gson.toJson(list)
        return objString
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_about -> {
            val intentAbout = Intent(this, AddActivity::class.java)

            intentAbout.putExtra("wBird", toJson(birds))

            startActivityForResult(intentAbout, 1)
            true

        }
        else -> false

    }
}
