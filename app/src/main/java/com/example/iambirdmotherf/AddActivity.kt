package com.example.iambirdmotherf

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.provider.MediaStore
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.google.android.gms.tasks.Task
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_add.*
import java.time.LocalDate

class AddActivity : AppCompatActivity() {


    // Create an ArrayAdapter using a simple spinner layout and languages array
    val jsons = Jsons()
    var birds = ArrayList<Bird>()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        birds = jsons.arrayFromJson(intent.getStringExtra("wBird"))



        addButton.setOnClickListener {
            if (nameData.text.isNotEmpty() && picData.text.isNotEmpty())
            this.getTagsFromUrl(picData.text.toString())
        }
        preButton.setOnClickListener {
            if (nameData.text.isNotEmpty() && picData.text.isNotEmpty())
                Picasso.get().load(picData.text.toString()).into(imageView)
        }

    }

    fun getTagsFromUrl(url: String) {


        Picasso.get().load(url).into(object : com.squareup.picasso.Target {


            @TargetApi(Build.VERSION_CODES.O)
            @androidx.annotation.RequiresApi(Build.VERSION_CODES.O)
            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {

                //imageView.setImageBitmap(bitmap)
                val vision = FirebaseVisionImage.fromBitmap(bitmap!!)
                val labeler = FirebaseVision.getInstance().getOnDeviceImageLabeler()
                labeler.processImage(vision)

                    .addOnSuccessListener {


                        val intent = Intent(this@AddActivity, MainActivity::class.java)




                            birds.add(
                                Bird(
                                    nameData.text.toString(),
                                    picData.text.toString(),
                                    it.map { it.text }.joinToString(" "),
                                    LocalDate.now().toString()
                                )
                            )


                            intent.putExtra("sBird", jsons.arrayToJson(birds))
                            startActivity(intent)

                            setResult(RESULT_OK, intent)
                            finish()

                    }
                    .addOnFailureListener {


                        Log.wtf("LAB", it.message)

                    }

                Log.wtf("Pizdos:", "Zagruzivs")
            }

            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                Log.wtf("Pizdos:", "Gruzus")

            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                Log.wtf("Pizdos:", "Ebanulsya")
                Toast.makeText(this@AddActivity,"Invalid URL",Toast.LENGTH_SHORT).show()

            }
        })


    }
}
