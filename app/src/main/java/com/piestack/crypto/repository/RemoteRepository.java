package com.piestack.crypto.repository;

import com.piestack.crypto.model.RateResponse;

import io.reactivex.Observable;
import io.reactivex.Single;


public interface RemoteRepository {
    Single<RateResponse> getRates(final String cryptoSymbol, final String currencyArray);
}
