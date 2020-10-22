package com.example.adt

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adt.network.RetrofitInstance
import com.example.adt.network.RetrofitService
import kotlinx.android.synthetic.main.activity_recycler_view.*
import retrofit2.Call
import retrofit2.Response

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter: RecyclerViewAdapter

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


    fun createData() {
//        val item = ArrayList<RecyclerData>()
//        item.add(RecyclerData("temp1", "description"))
//        item.add(RecyclerData("temp2", "description"))
//        item.add(RecyclerData("temp3", "description"))
//
//        recyclerViewAdapter.setListData(item)
//        recyclerViewAdapter.notifyDataSetChanged()

        val retroInstance =
            RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        val call = retroInstance.getDataFromAPI() // AMANI TODO
        call.enqueue(object : retrofit2.Callback<RecyclerList> {
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if (response.isSuccessful) {
                    recyclerViewAdapter.setListData(response.body()?.results!!)
                    recyclerViewAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                Toast.makeText(
                    this@RecyclerViewActivity,
                    "Error getting data from api.",
                    Toast.LENGTH_LONG
                ).show()
            }
        })

    }
}