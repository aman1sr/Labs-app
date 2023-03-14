package com.pahadi.labsapp.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        countryAdapter = CountryAdapter {
            val countryName = it
            Toast.makeText(requireContext(), "$countryName Clicked", Toast.LENGTH_SHORT).show()
        }
        _binding?.recView?.layoutManager = LinearLayoutManager(context)
        _binding?.recView?.adapter = countryAdapter

        viewModel.countryList.observe({lifecycle}){
            Log.d(TAG, "FRG reading..: "+ it)
            // todo: add pb
            countryAdapter.submitList(it?.data)
            _binding?.progressBar?.visibility = View.GONE
        }



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}