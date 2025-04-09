package com.example.myrv

import kotlin.collections.addAll

object Constant {
    internal var itemData: ArrayList<ItemData> = ArrayList()
    fun getData(): ArrayList<ItemData> {
        itemData.addAll(
            arrayListOf(
                ItemData(R.drawable.diet, "Indus  wallah", "dwarahat"),
                ItemData(R.drawable.img1, "In Chaiallah", "haldwani"),
                ItemData(R.drawable.img2, "Induai llah", "haldwani"),
                ItemData(R.drawable.img3, "Indus hai wallah", "haldwani"),
                ItemData(R.drawable.img4, "Indus iwallah", "haldwani"),
                ItemData(R.drawable.img5, "Indus Chai wallah", "haldwani"),
                ItemData(R.drawable.img6, "Induh allah", "haldwani"),
                ItemData(R.drawable.img7, "Indus hwalah", "haldwani"),
                ItemData(R.drawable.img8, "Indus  Ci wallah", "haldwani"),
                ItemData(R.drawable.img9, "Indus  Ci wallah", "haldwani"),
                ItemData(R.drawable.img10, "Indus  Ci wallah", "haldwani"),
                ItemData(R.drawable.diet, "IndusChi wallah", "haldwani"),
                ItemData(R.drawable.diet, "Indu wallah", "haldwani"),
                ItemData(R.drawable.diet, "Ins Chai wallah", "haldwani"),
                ItemData(R.drawable.diet, "Indus Chai wallah", "Drawable")
            )
        )
        return itemData
    }
    fun addItem(item: ItemData){
        itemData.add(item)
    }
}