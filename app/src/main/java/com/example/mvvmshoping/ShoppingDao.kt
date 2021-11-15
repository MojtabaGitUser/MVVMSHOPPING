package com.example.mvvmshoping

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("select * from  shopping_items")
    fun getAllShoppingItems():LiveData<List<ShoppingItem>>
}