package com.airecodes.jacobchapman.kotlincrypto.models

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single

/**
 * Created by jacobchapman on 1/27/18.
 */


@Dao
interface CryptoCurrencyDao {

    @Query("select * from cryptoCurrency")
    fun getAllCurrencies(): Single<List<CryptoCurrency>>

    @Query("select * from cryptoCurrency where symbol = :symbol")
    fun getCurrency(symbol: String) : CryptoCurrency

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrencies(currencies: List<CryptoCurrency>)
}