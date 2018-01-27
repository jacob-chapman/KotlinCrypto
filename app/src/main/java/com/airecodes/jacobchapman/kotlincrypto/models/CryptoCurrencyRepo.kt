package com.airecodes.jacobchapman.kotlincrypto.models

import com.airecodes.jacobchapman.kotlincrypto.models.api.CoinMarketCapService

/**
 * Created by jacobchapman on 1/27/18.
 */


class CryptoCurrencyRepo(val coinMarketCapService: CoinMarketCapService, val cyrpotCurrencyDao: CryptoCurrencyDao){

    fun getCurrencies(){}

}