package com.example.adt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var items = ArrayList<RecyclerData>()

    fun setListData(data: List<RecyclerData>) {
        this.items = data as ArrayList<RecyclerData>
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)

        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // TODO: include Name, Status, Species and an image of the character
        val tvName = view.tvName
        val tvStatus = view.tvStatus
        val tvSpecies = view.tvSpecies

        //    val imgCharacter = view.imgCharacter
        fun bind(data: RecyclerData) {
            tvName.text = data.name
            tvStatus.text = data.status
            tvSpecies.text = data.species
            //    tvStatus.text = data.status
        }

    }
}