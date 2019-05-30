package com.example.iambirdmotherf

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

class DescriptionActivity : AppCompatActivity(){
  /*  override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val birdC =jsons.itemFromJson<Bird>(intent.getStringExtra("birdD"))
    }*/
  companion object {
      const val ARRAY = "lista"
      const val POSITION = "pos"
  }

    private lateinit var fragmentManager: FragmentManager
    private lateinit var bigPhotoFragment: Fragment
    private lateinit var detailsFragment: Fragment
    private lateinit var similarsFragment: Fragment
    private var isSwapped:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        fragmentManager = supportFragmentManager


        val jsons=Jsons()
        val birdC =jsons.itemFromJson(intent.getStringExtra("birdD"))


        bigPhotoFragment = InfoFragment.newInstance(birdC.pic)
        detailsFragment = RandomFragment.newInstance(birdC)
        similarsFragment = SimilarFragment.newInstance(birdC.pic)

        fragmentManager.beginTransaction().add(R.id.activity_description, bigPhotoFragment, "photo").commit()
        fragmentManager.beginTransaction().add(R.id.activity_description, detailsFragment, "details").commit()
       fragmentManager.beginTransaction().add(R.id.activity_description, similarsFragment, "similars").commit()
        fragmentManager.beginTransaction().hide(detailsFragment).commit()
        fragmentManager.beginTransaction().hide(similarsFragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_change, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.change -> {
                swapFragments()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun swapFragments() {
        if (isSwapped){
            fragmentManager.beginTransaction().hide(detailsFragment).commit()
           fragmentManager.beginTransaction().hide(similarsFragment).commit()
            fragmentManager.beginTransaction().show(bigPhotoFragment).commit()
            isSwapped = !isSwapped

        } else{
            fragmentManager.beginTransaction().hide(bigPhotoFragment).commit()
            fragmentManager.beginTransaction().show(detailsFragment).commit()
            fragmentManager.beginTransaction().show(similarsFragment).commit()
            isSwapped = !isSwapped
        }

    }
}
