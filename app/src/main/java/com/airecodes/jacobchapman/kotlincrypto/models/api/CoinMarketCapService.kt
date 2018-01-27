package com.airecodes.jacobchapman.kotlincrypto.models.api

import com.airecodes.jacobchapman.kotlincrypto.models.CryptoCurrency
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by jacobchapman on 1/27/18.
 */


interface CoinMarketCapService {

    @GET("ticker")
    fun getCurrencies(): Observable<List<CryptoCurrency>>
}