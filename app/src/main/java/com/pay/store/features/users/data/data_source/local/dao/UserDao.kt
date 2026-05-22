package com.pay.store.features.users.data.data_source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pay.store.features.users.data.data_source.local.entities.UserEntity


@Dao
interface  UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun addUser(user: UserEntity)

    @Query(" SELECT * FROM user_table ORDER BY id ASC")
    fun readUsers():LiveData<List<UserEntity>>

}