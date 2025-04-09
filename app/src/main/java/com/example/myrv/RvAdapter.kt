package com.example.myrv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myrv.databinding.RvItemLayoutBinding

class RvAdapter (val userList: ArrayList<ItemData>):RecyclerView.Adapter<RvAdapter.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val itemBinding=RvItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        anim(holder.itemView)
        holder.binding.profile.setImageResource(userList[position].image)
        holder.binding.name.text=userList[position].name
        holder.binding.address.text=userList[position].address
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context,userList[position].name,Toast.LENGTH_SHORT).show()
        }
      holder.bind(userList[position])

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class ViewHolder(val binding: RvItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user:ItemData){
            binding.profile.setImageResource(user.image)
            binding.name.text=user.name
            binding.address.text=user.address

        }
    }
    fun anim(view:View){
        var animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration= 1200
        view.startAnimation(animation)
    }
}