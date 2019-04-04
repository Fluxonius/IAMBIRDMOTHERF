package com.example.iambirdmotherf


import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class RecyclerAdapter(private val birds:ArrayList<Bird>):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    inner class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        val pic:ImageView
        val name:TextView
        val tags:TextView
        val dates:TextView

        init {
            pic=itemView.findViewById(R.id.item_image)
           name=itemView.findViewById(R.id.item_name)
            tags=itemView.findViewById(R.id.item_tags)
            dates=itemView.findViewById(R.id.item_date)
            itemView.setOnClickListener { v: View  ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v, "Removed "+birds[position].name,
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
                birds.removeAt(position)
                notifyDataSetChanged()

            }

        }


        fun bindBird(bird: Bird){
            name.text=bird.name
            tags.text=bird.tags
            dates.text=bird.date
            Picasso.get().load(bird.pic).into(pic)
        }


}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: View= LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount()=birds.size




    override fun onBindViewHolder(holder:ViewHolder, pos: Int) {
      holder.bindBird(birds[pos])

    }


}