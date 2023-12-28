package com.example.shoppingcart.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized


@Database(entities = [ItemList::class], version = 1)
abstract class ItemListDatabase: RoomDatabase() {
    abstract fun getItemListDao():ItemListDao

    companion object{
        @Volatile
        private var INSTANCE:ItemListDatabase? = null
        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(context: Context): Any {
            synchronized(this){
                return INSTANCE?:Room.databaseBuilder(
                    context,
                    ItemListDatabase::class.java,
                    "itemlist_db"
                ).build().also{
                    INSTANCE = it
                }
            }
        }
    }
}