package com.example.iambirdmotherf

import android.content.Context
import android.net.Uri
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
 * Activities that contain this fragment must implement the
 * [InfoFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [InfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class InfoFragment : Fragment() {
    companion object {

        private const val KEY = "data"

        @JvmStatic
        fun newInstance(url: String) =
            InfoFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY, url)
                }
            }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view  = inflater.inflate(R.layout.fragment_info, container, false)
        val photo = view.findViewById<ImageView>(R.id.bigPic)

        Picasso.get().load(arguments?.getString(KEY)).into(photo)

        return view
    }


}
