package com.airecodes.jacobchapman.kotlincrypto.models

/**
 * Created by jacobchapman on 1/27/18.
 */

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase


@Database(entities= arrayOf(CryptoCurrency::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cryptoCurrencyDao() : CryptoCurrencyDao
}