package com.example.potest.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.potest.data.database.model.ProfileModel


@Dao
interface DatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profile: ProfileModel)
//
//    @Query("select * from pizzas_list order by id asc")
//    fun getPizzasListAsc(): LiveData<List<PizzaInfoModel>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertDessertInfoList(priceList: List<DessertInfoModel>)
//
//    @Query("select * from desserts_list order by id asc")
//    fun getDessertsListAsc(): LiveData<List<DessertInfoModel>>

}