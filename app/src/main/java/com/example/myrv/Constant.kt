package com.example.myrv

import kotlin.collections.addAll

object Constant {
    internal var itemData: ArrayList<ItemData> = ArrayList()
    fun getData(): ArrayList<ItemData> {
        itemData.addAll(
            arrayListOf(
                ItemData(R.drawable.diet, "Indus Chai wallah", "dwarahat"),
                ItemData(R.drawable.diet, "Indus Chai wallah", "haldwani"),
                ItemData(R.drawable.diet, "Indus Chai wallah", "Drawable")
            )
        )
        return itemData
    }
    fun addItem(item: ItemData){
        itemData.add(item)
    }
}