package com.example.shoppingcart.database


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemListDao {

    @Insert
    suspend fun insert(itemList: ItemList)

    @Delete
    suspend fun delete(itemList: ItemList)

    @Query("SELECT * FROM ItemList")
    fun getAllItemListItems():List<ItemList>

    @Query("SELECT * FROM ItemList WHERE id=:id")
    fun getOne(id:Int):ItemList
}