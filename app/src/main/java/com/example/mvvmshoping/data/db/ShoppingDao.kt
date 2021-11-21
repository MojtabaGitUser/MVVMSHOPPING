package com.example.mvvmshoping.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmshoping.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("select * from  shopping_items")
    fun getAllShoppingItems():LiveData<List<ShoppingItem>>
}