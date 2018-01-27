package com.airecodes.jacobchapman.kotlincrypto.models

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

/**
 * Created by jacobchapman on 1/27/18.
 */


@Dao
interface CryptoCurrencyDao {

    @Query("select * from cryptoCurrency")
    fun getAllCurrencies(): List<CryptoCurrency>

    @Query("select * from cryptoCurrency where symbol = :p0")
    fun getCurrency(symbol: String)
}