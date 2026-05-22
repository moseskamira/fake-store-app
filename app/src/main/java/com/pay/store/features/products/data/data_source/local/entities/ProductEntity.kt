package com.pay.store.features.products.data.data_source.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class ProductEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    val title: String?,
    val description: String?,
    val image: String?,
    val category: String?,
    val price: Double?
)
