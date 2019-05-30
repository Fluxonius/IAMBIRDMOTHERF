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
    companion object {

        private const val KEY = "data"

        @JvmStatic
        fun newInstance(url: String) =
            SimilarFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY, url)
                }
            }
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_similar, container, false)

        val img1 = view.findViewById<ImageView>(R.id.img1)
        val img2 = view.findViewById<ImageView>(R.id.img2)
        val img3 = view.findViewById<ImageView>(R.id.img3)
        val img4 = view.findViewById<ImageView>(R.id.img4)
        val img5 = view.findViewById<ImageView>(R.id.img5)
        val img6 = view.findViewById<ImageView>(R.id.img6)
        val imgList: ArrayList<ImageView> = arrayListOf(img1, img2, img3, img4, img5, img6)

        var urls: ArrayList<String> = ArrayList()
        urls.add("https://pp.userapi.com/c846323/v846323365/1ce85/Pbb6Ok8XDk0.jpg?ava=1")
        urls.add("https://memepedia.ru/wp-content/uploads/2018/06/zhmyh-valakas.jpg")
        urls.add("https://v-s.mobi/cITYLDjUMm9K5N9esBfv_tInFYfQS0N184WIse1WmX3uvYmDMOWs41VU9-r_KtHb/HQ.jpg")
        urls.add("https://img.youtube.com/vi/zTLmrOr8RxU/mqdefault.jpg")
        urls.add("https://scontent-yyz1-1.cdninstagram.com/vp/0ce97df59059677686a7e5abcc134e62/5D80933C/t51.2885-15/e35/43338301_260332068170042_2837399119156014424_n.jpg?_nc_ht=scontent-yyz1-1.cdninstagram.com")
        urls.add("https://pbs.twimg.com/media/Dnw2u9IWkAAnJzV.jpg")

        for (i in 0..5) {
            imgList[i].visibility = View.VISIBLE
            Picasso.get().load(urls[i]).into(imgList[i])
        }

        return view
    }
}
