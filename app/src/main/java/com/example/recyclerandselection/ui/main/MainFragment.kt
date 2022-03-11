package com.example.recyclerandselection.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.widget.SearchView
import com.example.recyclerandselection.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewF =inflater.inflate(R.layout.main_fragment, container, false)

        var editText= viewF.findViewById<EditText>(R.id.messageEditText)

        editText.setOnKeyListener(object : View.OnKeyListener{
            override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {

                Log.i("View.OnKeyListener","p0 "+p0+" p1 "+p1+" p2 "+p2 )
                return true
            }
        })

        var editText2= viewF.findViewById<EditText>(R.id.messageEditText2)

        editText2.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               // TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               // TODO("Not yet implemented")
                Log.i("addTextChangedListener"," p0 "+p0 +" p1 "+p1+ " p2 "+p2+" p3 "+p3)

            }

            override fun afterTextChanged(p0: Editable?) {
               // TODO("Not yet implemented")
            }
        })

        val bestCities =
            listOf("Lahore", "Berlin", "Lisbon", "Tokyo", "Toronto", "Sydney", "Osaka", "Istanbul")


        var listView=viewF.findViewById<ListView>(R.id.listView_main_fragment)
        var searchView=viewF.findViewById<SearchView>(R.id.searchView_main_fragment)
        var adapter = ArrayAdapter(requireActivity().application, android.R.layout.simple_list_item_1, bestCities)

        listView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                //Performs search when user hit the search button on the keyboard
//                if (bestCities.contains(p0)) {
//                    adapter.filter.filter(p0)
//                } else {
//                    Toast.makeText(this@MainActivity, "No match found", Toast.LENGTH_SHORT).show()
//                }
                return false
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                //Start filtering the list as user start entering the characters
                adapter.filter.filter(p0)
                return false
            }
        })


        return viewF
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}




