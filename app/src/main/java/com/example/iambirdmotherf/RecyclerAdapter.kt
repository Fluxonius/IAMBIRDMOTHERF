package com.example.iambirdmotherf



import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
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

            val intent=Intent(v.context,DescriptionActivity::class.java)

            }



        }


        fun bindBird(bird: Bird){
            name.text=bird.name
            dates.text=bird.date
            tags.text=bird.tags
            Picasso.get().load(bird.pic).into(pic)
        }



}
    fun removeAt(position: Int) {

        birds.removeAt(position)
        notifyItemRemoved(position)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: View= LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount()=birds.size




    override fun onBindViewHolder(holder:ViewHolder, pos: Int) {
        val jsons =Jsons()

      holder.bindBird(birds[pos])
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DescriptionActivity::class.java)
            intent.putExtra("birdD",jsons.itemToJson(birds[pos]))
            holder.itemView.context.startActivity(intent)
        }

      //  holder.tags.text=labels[pos]


    }


}