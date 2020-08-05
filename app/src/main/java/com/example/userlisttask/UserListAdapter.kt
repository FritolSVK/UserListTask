package com.example.userlisttask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserListAdapter: RecyclerView.Adapter<SingleUserView>() {

    override fun getItemCount(): Int {
        return 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleUserView {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.single_user_layout, parent, false)

        return SingleUserView(cellForRow)
    }

    override fun onBindViewHolder(holder: SingleUserView, position: Int) {

    }
}

class SingleUserView(view: View) : RecyclerView.ViewHolder(view)