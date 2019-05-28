package com.example.iambirdmotherf


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SimilarFragment : Fragment() {
/*

    val jsons=Jsons()

    private lateinit var data: ArrayList<Bird>

    companion object {
        private const val DATA_KEY = "data"
       // private const val LIST_KEY = "test"

        @JvmStatic
        fun newInstance(element: Bird, array: ArrayList<Bird>) =
            SimilarFragment().apply {
                arguments = Bundle().apply {
                    putString(DATA_KEY, jsons.itemToJson(element))
                  //  putParcelableArrayList(LIST_KEY, array)
                }
            }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_similar, container, false)

        val element =jsons.itemFromJson(arguments?.getString(DATA_KEY)!!)
       // val list = arguments?.getParcelableArrayList<DataItem>(LIST_KEY)

        val img1 = view.findViewById<ImageView>(R.id.img1)
        val img2 = view.findViewById<ImageView>(R.id.img2)
        val img3 = view.findViewById<ImageView>(R.id.img3)
        val img4 = view.findViewById<ImageView>(R.id.img4)
        val img5 = view.findViewById<ImageView>(R.id.img5)
        val img6 = view.findViewById<ImageView>(R.id.img6)

        val imgList: ArrayList<ImageView> = arrayListOf(img1, img2, img3, img4, img5, img6)

        val similars = getSimilars(list!!, element!!)

        for (i in 0 until minOf(similars.size, 6)) {
            imgList[i].visibility = View.VISIBLE
            Picasso.get().load(similars[i].url).into(imgList[i])

        }

        return view
    }

    private fun getSimilars(data: ArrayList<Bird>, element: Bird): List<Bird> {
        val index = data.indexOf(element)
        val result = data
      result.removeAt(index)
        return result.filter { !it.tags.intersect(element.tags).isEmpty() }
    }
*/
}
