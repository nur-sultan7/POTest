package com.example.potest.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.potest.data.database.model.ProfileModel


@Dao
interface DatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profile: ProfileModel)

    @Query("select * from profile_table where id=:id limit 1")
    suspend fun getProfile(id: String): ProfileModel

}