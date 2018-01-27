package com.airecodes.jacobchapman.kotlincrypto.models

/**
 * Created by jacobchapman on 1/27/18.
 */

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.ColumnInfo


@Entity(tableName="cryptoCurrency")
data class CryptoCurrency(

    @PrimaryKey
    @ColumnInfo(name = "symbol")
    val symbol: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "price_usd")
    val priceUSD: Double,
    @ColumnInfo(name = "price_btc")
    val priceBTC: Double,
    @ColumnInfo(name = "rank")
    val rank: Int
)