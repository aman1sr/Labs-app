package com.pahadi.labsapp.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pahadi.labsapp.R
import com.pahadi.labsapp.databinding.FragmentCountryListBinding

class CountryListFragment : Fragment() {

    companion object {
        val TAG = "CountryList_d"
    }

    private lateinit var viewModel: CountryListViewModel
    private var _binding: FragmentCountryListBinding? = null

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

        viewModel.countryList.observe({lifecycle}){
            Log.d(TAG, "FRG reading..: "+ it)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}