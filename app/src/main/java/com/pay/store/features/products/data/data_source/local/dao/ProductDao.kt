package com.pay.store.features.products.data.data_source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pay.store.features.products.data.data_source.local.entities.ProductEntity

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun addProduct(user: ProductEntity)

    @Query(" SELECT * FROM product_table ORDER BY id ASC")
    fun readProducts(): LiveData<List<ProductEntity>>
}