package com.example.adt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        initRecyclerView()
        createData()
    }


    private fun initRecyclerView() {

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter
        }
    }

    private fun createData() {
        val item = ArrayList<RecyclerData>()
        item.add(RecyclerData("id1", "name1"))
        item.add(RecyclerData("id2", "name2"))
        item.add(RecyclerData("id3", "name3"))
        item.add(RecyclerData("id4", "name4"))

        recyclerViewAdapter.setListData(item)
        recyclerViewAdapter.notifyDataSetChanged()

    }
}