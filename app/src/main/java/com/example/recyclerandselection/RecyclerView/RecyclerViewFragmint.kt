package com.example.recyclerandselection.RecyclerView

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentexamplekt.BaseExample.Utils.MyObserverFragment
import com.example.recyclerandselection.Adapter.RecyclerViewUserAdapter
import com.example.recyclerandselection.R
import com.example.viewmodelkt.UsersViewModel

class RecyclerViewFragmint : Fragment() {

    lateinit var myObserverLifecycler: MyObserverFragment

    // это ленивая инициализация
    //private val userViwModel by lazy { ViewModelProvider(this).get(UsersViewModel::class.java)}

    // это инициализация от activity
    private val userViwModel: UsersViewModel by activityViewModels()

    lateinit var adapter: RecyclerViewUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //getActivity().getApplicationContext()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        myObserverLifecycler = MyObserverFragment()
        lifecycle.addObserver(myObserverLifecycler)

        val view = inflater!!.inflate(R.layout.fragment_recyclerview, container, false)
        //val
        adapter = RecyclerViewUserAdapter()
        var userList: RecyclerView = view.findViewById(R.id.userList)

        // context
        requireActivity().application
        var contextUApp = view.getContext()
        // context

        userList.layoutManager = LinearLayoutManager(getActivity())
        userList.adapter = adapter
//
//        var searchView=view.findViewById<SearchView>(R.id.searchView_recycler_fragment)
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                //Performs search when user hit the search button on the keyboard
////                if (bestCities.contains(p0)) {
////                    adapter.filter.filter(p0)
////                } else {
////                    Toast.makeText(this@MainActivity, "No match found", Toast.LENGTH_SHORT).show()
////                }
//                return false
//            }
//            override fun onQueryTextChange(p0: String?): Boolean {
//                //Start filtering the list as user start entering the characters
//                userViwModel.setFilterName(p0.toString())
//                return false
//            }
//        })

//        userViwModel.getListUsers().observe(viewLifecycleOwner, Observer {
//            it?.let {
//                Log.i("RecyclerViewFragmint", "onCreateView it.size= " + it.size)
//                adapter.refreshingUsers(it)
//            }
//        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // https://developer.android.com/topic/libraries/architecture/viewmodel
        userViwModel.getListUsers()
            .observe(viewLifecycleOwner, Observer {
                Log.i("RecyclerViewFragmint", "onViewCreated it.size= " + it.size)
                it?.let { adapter.refreshingUsers(it) }
            })
    }

}