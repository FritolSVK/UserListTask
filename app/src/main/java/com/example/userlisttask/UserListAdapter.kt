package com.example.userlisttask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.single_user_layout.view.*

class UserListAdapter: RecyclerView.Adapter<SingleUserView>() {

    val listOfNames = listOf("Peder", "Jozef", "Marek")

    override fun getItemCount(): Int {
        return listOfNames.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleUserView {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.single_user_layout, parent, false)

        return SingleUserView(cellForRow)
    }

    override fun onBindViewHolder(holder: SingleUserView, position: Int) {
        holder.view.userName.text = listOfNames.get(position)
    }
}

class SingleUserView(val view: View) : RecyclerView.ViewHolder(view)