package com.example.navigationdrawer

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DemoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        view.recylerView.layoutManager = LinearLayoutManager(activity)
        val items = fetchData()
        view.recylerView.adapter = RecyclerAdapter(items)
        return view




    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?): ArrayList<String> {
        super.onViewCreated(view, savedInstanceState){
            recylerView.apply {
               layoutManager = LinearLayoutManager(this)
                val
                

            }
        }*/
    }

private fun fetchData(): ArrayList<String> {
    val list = ArrayList<String>()
    for(i in 0 until 100){
        list.add("Item $i ")
    }
    return list
}