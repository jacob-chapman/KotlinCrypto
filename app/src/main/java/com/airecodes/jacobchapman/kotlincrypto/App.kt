package com.airecodes.jacobchapman.kotlincrypto

import android.app.Application
import com.airecodes.jacobchapman.kotlincrypto.models.AppDatabase
import com.airecodes.jacobchapman.kotlincrypto.models.api.CoinMarketCapService
import retrofit2.Retrofit

/**
 * Created by jacobchapman on 1/27/18.
 */


class App : Application {

    companion object {
        private lateinit var retrofit: Retrofit
        private lateinit var coinMarketCapServie: CoinMarketCapService
        private lateinit var appDatabase: AppDatabase

    }

}