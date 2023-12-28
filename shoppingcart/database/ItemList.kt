package com.example.shoppingcart.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ItemList_table")
data class ItemList(
    var item:String?
){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}
