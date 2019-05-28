package com.example.iambirdmotherf

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [RandomFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [RandomFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class RandomFragment : Fragment() {
    val jsons=Jsons()
    companion object {
        const val DATA_KEY = "data"
        @JvmStatic
        fun newInstance(element: Bird) =
            RandomFragment().apply {
                arguments = Bundle().apply {
                    putString(DATA_KEY, jsons.itemToJson(element))
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_random, container, false)
        val name = view.findViewById<TextView>(R.id.name)
        val date = view.findViewById<TextView>(R.id.date)
        val tags = view.findViewById<TextView>(R.id.tags)

        val element = jsons.itemFromJson(arguments?.getString(DATA_KEY)!!)

        name.text = element.name
        date.text = element.date

       // val tgs = element?.tags!!.joinToString(" #", prefix = "#")
        tags.text = element.tags

        return view
    }
}
