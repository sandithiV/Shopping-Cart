package com.example.shoppingcart.database

class ItemListRepository(
    private val db: Any
) {

    suspend fun insert(itemList: ItemList) = db.getItemListDao().insert(itemList)
    suspend fun delete(itemList: ItemList) = db.getItemListDao().delete(itemList)

    fun getAllItemListItems():List<ItemList> = db.getItemListDao().getAllItemListItems()
}