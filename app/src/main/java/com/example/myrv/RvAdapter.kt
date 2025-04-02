package com.example.myrv

import android.view.LayoutInflater
import android.view.ViewGroup
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
        holder.binding.rvText.text=userList[position].name
        holder.binding.rvAge.text=userList[position].age.toString()
        holder.binding.rvEmail.text=userList[position].email

      holder.bind(userList[position])

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class ViewHolder(val binding: RvItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user:ItemData){
            binding.rvText.text=user.name
            binding.rvAge.text=user.age.toString()
            binding.rvEmail.text=user.email

        }
    }
}