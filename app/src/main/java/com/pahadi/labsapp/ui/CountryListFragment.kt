package com.pahadi.labsapp.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.pahadi.labsapp.R
import com.pahadi.labsapp.databinding.FragmentCountryListBinding
import com.pahadi.labsapp.models.CountryListReponseData

class CountryListFragment : Fragment() {

    companion object {
        val TAG = "CountryList_d"
    }

    private lateinit var viewModel: CountryListViewModel
    private var _binding: FragmentCountryListBinding? = null
    private lateinit var countryAdapter: CountryAdapter
    private lateinit var recCountryList : ArrayList<CountryListReponseData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountryListBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(CountryListViewModel::class.java)

        return _binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        _binding?.includePart?.txtToolbarHead?.text = "Country List"
        _binding?.progressBar?.visibility = View.VISIBLE

        recItemLoad()

        searchBarFilter()

    }

    private fun searchBarFilter() {
        _binding?.searchView?.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterByCountryName(newText)
                return false
            }

        })

    }

    private fun filterByCountryName(text: String?) {
        val filteredList: ArrayList<CountryListReponseData> = ArrayList()
        for (item in recCountryList) {
            // checking if the entered string matched with any item of our recycler view.
            if (text?.toLowerCase()?.let { item.countriesName?.toLowerCase()?.contains(it) } == true) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredList.add(item)
            }
        }
        if (filteredList.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(requireContext(), "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            countryAdapter.submitList(filteredList)
        }
    }



    private fun recItemLoad() {
        countryAdapter = CountryAdapter {
            val countryName = it
            Toast.makeText(requireContext(), "$countryName Clicked", Toast.LENGTH_SHORT).show()
        }
        _binding?.recView?.layoutManager = LinearLayoutManager(context)
        _binding?.recView?.adapter = countryAdapter

        viewModel.countryList.observe({ lifecycle }) {
            Log.d(TAG, "FRG reading..: " + it)
            recCountryList = it?.data as ArrayList<CountryListReponseData>

            countryAdapter.submitList(it?.data)
            _binding?.progressBar?.visibility = View.GONE
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
