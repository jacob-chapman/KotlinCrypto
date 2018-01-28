package com.airecodes.jacobchapman.kotlincrypto.viewmodels

import com.airecodes.jacobchapman.kotlincrypto.models.CryptoCurrency
import com.airecodes.jacobchapman.kotlincrypto.models.CryptoCurrencyRepo
import io.reactivex.Observable

/**
 * Created by jacobchapman on 1/27/18.
 */


class CurrencyListViewModel(val cryptoCurrencyRepo: CryptoCurrencyRepo){

    //Get the currencies from the repo and create the individual view list
    fun getCurrencies(): Observable<CurrencyList> {
        return cryptoCurrencyRepo.getCurrencies()
                .map { CurrencyList(it.sortedByDescending { x -> x.rank }.take(50), "Top CryptoCurrencies") }
                .onErrorReturn { CurrencyList(emptyList(), "Shit something happened") }
    }

}