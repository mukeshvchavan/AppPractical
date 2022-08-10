package com.example.apppractical

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*

class UserAdapter (
    var context: Context,
    var data: List<UserData>
        ): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        return viewHolder.bindView(context, data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindView(context: Context, userData: UserData) {

            if ( userData.avatar != null) {
                Glide.with(context)
                    .load(userData.avatar)
                .into(itemView.imageView)

            }
            if ( userData.first_name != null) {
                itemView.firstName.text = userData.first_name
            }
            if ( userData.last_name != null) {
                itemView.lastName.text = userData.last_name
            }
            if ( userData.email != null) {
                itemView.emaiID.text = userData.email
            }

        }

    }

}