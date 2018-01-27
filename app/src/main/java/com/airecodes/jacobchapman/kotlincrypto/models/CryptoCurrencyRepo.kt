package com.airecodes.jacobchapman.kotlincrypto.models

import com.airecodes.jacobchapman.kotlincrypto.models.api.CoinMarketCapService
import io.reactivex.Observable

/**
 * Created by jacobchapman on 1/27/18.
 */


class CryptoCurrencyRepo(val coinMarketCapService: CoinMarketCapService, val cryptoCurrencyDao: CryptoCurrencyDao){

    fun getCurrencies(): Observable<List<CryptoCurrency>> {
        return Observable.concatArray(
                getCurrenciesFromDb(),
                getCurrenciesFromApi())
    }


    fun getCurrenciesFromDb(): Observable<List<CryptoCurrency>> {
        return cryptoCurrencyDao.getAllCurrencies().toObservable()
    }

    fun getCurrenciesFromApi(): Observable<List<CryptoCurrency>> {
        return coinMarketCapService.getCurrencies()
    }
}