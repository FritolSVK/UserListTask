package com.example.userlisttask

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    val usersList : ArrayList<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_UserList.layoutManager = LinearLayoutManager(this)
        recyclerView_UserList.adapter = UserListAdapter(usersList)

        fetchData()


    }

    fun fetchData() {
        fun getContext(): Context {
            return this
        }

        val url = "https://reqres.in/api/users?page=1&per_page=5"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        //make a thread to execute
        client.newCall(request).enqueue(object : Callback {
            //create a toast to inform a user
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread() {
                    Toast.makeText(
                        getContext(),
                        "Unable to fetch list of users",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            //write down users to inform user its successful
            override fun onResponse(call: Call, response: Response) {
                val text = response.body?.string()
                val gson = GsonBuilder().create()
                val users = gson.fromJson(text, UserList::class.java)
                usersList.addAll(users.data)
                runOnUiThread {
                    recyclerView_UserList.adapter?.notifyDataSetChanged()
                }

            }
        })

    }

    //names of vals are to be exactly the same as in json file (i.e. the same as in response)
    class UserList(val data : List<User>)
    class User(val id: Int, val first_name: String, val last_name: String)
}
