package com.piestack.crypto.repository;

import com.piestack.crypto.model.RateResponse;

import io.reactivex.Single;

public interface LocalRepository {

    public void insertRate(RateResponse rateResponse);

    public Single<RateResponse> getOneRateResponse(int id);

    public void deleteAllRates();

}
