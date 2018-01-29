package com.airecodes.jacobchapman.kotlincrypto.models

/**
 * Created by jacobchapman on 1/27/18.
 */

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.migration.Migration


@Database(entities= arrayOf(CryptoCurrency::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cryptoCurrencyDao() : CryptoCurrencyDao

    companion object {
        @JvmField
        val MIGRATION_1_2 = Migration1To2()
    }
}


class Migration1To2 : Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        //just drop the table
        database.execSQL("DROP TABLE cryptoCurrency")
    }
}