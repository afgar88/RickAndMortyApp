package com.example.rickandmortyapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.model.locationmodel.Location

class LocationAdapter(
    private var locationList: MutableList<Location> = mutableListOf()
) : RecyclerView.Adapter<LocationViewAdapter>() {

    fun update(locationL: List<Location>) {
        locationList.clear()
        locationList.addAll(locationL)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewAdapter {
        val locationItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_location, parent, false)
        return LocationViewAdapter(locationItem)
    }

    override fun onBindViewHolder(holder: LocationViewAdapter, position: Int) {
        val my_location = locationList[position]
        holder.bind(my_location)
    }

    override fun getItemCount(): Int = locationList.size
}

class LocationViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name: TextView = itemView.findViewById(R.id.location_name_id)
    private val type: TextView = itemView.findViewById(R.id.location_type_id)
    private val dimension: TextView = itemView.findViewById(R.id.location_dimension_id)


    fun bind(locationInfo: Location) {
        name.text = locationInfo.name
        type.text = locationInfo.type
        dimension.text = locationInfo.dimension

    }

}