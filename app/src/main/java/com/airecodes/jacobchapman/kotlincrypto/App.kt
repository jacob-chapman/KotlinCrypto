package com.airecodes.jacobchapman.kotlincrypto

import android.app.Application
import android.arch.persistence.room.Room
import com.airecodes.jacobchapman.kotlincrypto.models.AppDatabase
import com.airecodes.jacobchapman.kotlincrypto.models.CryptoCurrencyRepo
import com.airecodes.jacobchapman.kotlincrypto.models.api.CoinMarketCapService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by jacobchapman on 1/27/18.
 */


class App : Application() {

    companion object {
        private lateinit var retrofit: Retrofit
        private lateinit var coinMarketCapService: CoinMarketCapService
        private lateinit var appDatabase: AppDatabase
        private lateinit var cryptoCurrencyRepo: CryptoCurrencyRepo
    }


    override fun onCreate() {
        super.onCreate()

        retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.coinmarketcap.com/v1/")
                .build()

        coinMarketCapService = retrofit.create(CoinMarketCapService::class.java)
        appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "CryptoCurrencyDb").build()

        cryptoCurrencyRepo = CryptoCurrencyRepo(coinMarketCapService, appDatabase.cryptoCurrencyDao())


    }
}