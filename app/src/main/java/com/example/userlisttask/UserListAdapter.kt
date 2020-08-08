package com.example.userlisttask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.single_user_for_recycler_view_layout.view.*

class UserListAdapter(val users: List<MainActivity.User>): RecyclerView.Adapter<SingleUserView>() {

    override fun getItemCount(): Int {
        return users.count()
    }

    //creates the row with default values
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleUserView {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.single_user_for_recycler_view_layout, parent, false)

        return SingleUserView(cellForRow)
    }

    //sets the custom data to the row
    override fun onBindViewHolder(holder: SingleUserView, position: Int) {

        holder.view.setOnClickListener(View.OnClickListener {

        })
        holder.view.userName.text = users.get(position).first_name + " " + users.get(position).last_name
    }
}

class SingleUserView(val view: View) : RecyclerView.ViewHolder(view)