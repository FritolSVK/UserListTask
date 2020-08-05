package com.example.userlisttask

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import java.time.Duration

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_UserList.layoutManager = LinearLayoutManager(this)
        recyclerView_UserList.adapter = UserListAdapter()

        fetchData()
    }

    fun fetchData() {
        fun getContext(): Context {
            return this
        }

        val url = "https://reqres.in/api/users?page=1&per_page=5"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread() {
                    Toast.makeText(
                        getContext(),
                        "Unable to fetch list of users",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val text = response.body?.string()

                println(text)
            }
        })

    }
}
