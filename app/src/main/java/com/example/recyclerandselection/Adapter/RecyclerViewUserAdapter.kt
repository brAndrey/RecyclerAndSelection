package com.example.recyclerandselection.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.recyclerandselection.R
import com.example.viewmodelkt.User

class RecyclerViewUserAdapter : RecyclerView.Adapter<RecyclerViewUserAdapter.UserHolder>() {

    private var users: List<User> = ArrayList()
    private var lastSelectedPosition = -1

    fun refreshingUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false))
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bild(users[position])
        holder.userRadioButton.setChecked(lastSelectedPosition == position);
    }

    fun updateList(post: Int) {
        lastSelectedPosition = post
        notifyDataSetChanged()
    }

    override fun getItemCount() = users.size

//***************************************************************************************

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var userRadioButton: RadioButton

        fun bild(user: User) = with(itemView) {
            var userName: TextView = itemView.findViewById(R.id.userName)
            userName.text = user.name
            var userDescription: TextView = itemView.findViewById(R.id.userDescription)
            userDescription.text = user.description
            userRadioButton = itemView.findViewById(R.id.userRadioButton)
            var userCheckBox: CheckBox = itemView.findViewById(R.id.userCheckBox)

            //http://developer.alexanderklimov.ru/android/views/radiobutton.php

            //http://developer.alexanderklimov.ru/android/views/checkbox.php

            // общее нажатие на элемент
            itemView.setOnClickListener(View.OnClickListener(){
                Log.i("itemView.setOnClickLis", "" + getAdapterPosition())
                Log.i("itemView.setOnClickLis", "" + position)
            })

            userCheckBox.setOnClickListener {
                if (userCheckBox.isChecked)
                    Log.i("userCheckBox.setOnClick",
                        " userCheckBox.isChecked " + userCheckBox.isChecked)

                if (userCheckBox.isClickable)
                    Log.i("userCheckBox.setOnClick",
                        " userCheckBox.isClickable " + userCheckBox.isClickable)
            }

            // срабатывает при изменении
            userRadioButton.setOnCheckedChangeListener { _, checkedId ->
                // get the radio group checked radio button
                Log.i("setOnCheckedChangeList",
                    " " + checkedId + " " + user.name + " " + userRadioButton.isChecked)
            }

            // отрабатывает нажатие
            userRadioButton.setOnClickListener(View.OnClickListener() {
                Log.i("setOnClickListener", "  " + user.name)
                Log.i("setOnClickListener", "isChecked   " + userRadioButton.isChecked)
                Log.i("setOnClickListener", "isClickable " + userRadioButton.isClickable)
                //updateList(getAdapterPosition())
            })

        }

    }

}
