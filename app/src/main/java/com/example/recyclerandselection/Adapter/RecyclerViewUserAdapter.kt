package com.example.recyclerandselection.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.recyclerandselection.R
import com.example.viewmodelkt.User

class RecyclerViewUserAdapter:RecyclerView.Adapter<RecyclerViewUserAdapter.UserHolder>(){

    private var users:List<User> = ArrayList()

    fun refreshingUsers(users:List<User>){
        this.users=users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false))
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bild(users[position])
    }

    override fun getItemCount()=users.size

//***************************************************************************************

    class UserHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bild(user: User) = with(itemView) {
            var userName:TextView= findViewById(R.id.userName)

                    userName.text=user.name
            var userDescription:TextView= findViewById(R.id.userDescription)
                    userDescription.text=user.description
        }

    }


}