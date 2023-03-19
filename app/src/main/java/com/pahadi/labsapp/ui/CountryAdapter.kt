package com.pahadi.labsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pahadi.labsapp.R
import com.pahadi.labsapp.databinding.CountryItemBinding
import com.pahadi.labsapp.databinding.FragmentCountryListBinding
import com.pahadi.labsapp.extensions.loadImage
import com.pahadi.labsapp.models.CountryListReponseData

class CountryAdapter (val onItemClicked: (slug: String) -> Unit): 
    ListAdapter<CountryListReponseData, CountryAdapter.CountryViewHolder>(
    object : DiffUtil.ItemCallback<CountryListReponseData>(){
        override fun areItemsTheSame(
            oldItem: CountryListReponseData,
            newItem: CountryListReponseData
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CountryListReponseData,
            newItem: CountryListReponseData
        ): Boolean {
           return oldItem.toString() == newItem.toString()
        }
    }
){
    
    inner class CountryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            parent.context.getSystemService(LayoutInflater::class.java).inflate(
                R.layout.country_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
       
        CountryItemBinding.bind(holder.itemView).apply {
            val countryItem = getItem(position)
            
            tvCountryName.text = countryItem.countriesName
            tvCountryCountryCode.text = countryItem.countryCode
            tvCountryIsoCode.text = countryItem.countriesIsoCode

            countryItem.flag?.let { avatarImageView.loadImage(it) }

            root.setOnClickListener {
                if (!clItemClick.isVisible) {
                    clItemClick.visibility = View.VISIBLE
                    onItemClicked(countryItem.countriesName.toString())
                } else {
                    clItemClick.visibility = View.GONE
                }

            }


        }
        
    }


}