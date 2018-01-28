package com.airecodes.jacobchapman.kotlincrypto.models

import com.airecodes.jacobchapman.kotlincrypto.models.api.CoinMarketCapService
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

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
        return cryptoCurrencyDao.getAllCurrencies()
                .toObservable()
    }

    fun getCurrenciesFromApi(): Observable<List<CryptoCurrency>> {
        return coinMarketCapService.getCurrencies()
                .doOnNext { storeCurrenciesInDb(it) }
    }

    fun storeCurrenciesInDb(currencies: List<CryptoCurrency>){
        Observable.fromCallable{ cryptoCurrencyDao.insertCurrencies(currencies)}
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
    }
}