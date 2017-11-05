package com.piestack.crypto.repository;

import com.piestack.crypto.local.CryptoDAO;
import com.piestack.crypto.model.RateResponse;

import java.util.concurrent.Executor;

import io.reactivex.Single;

public class LocalRepositoryImpl implements LocalRepository {
    private CryptoDAO cryptoDAO;
    private Executor executor;

    public LocalRepositoryImpl(CryptoDAO cryptoDAO, Executor exec) {
        this.cryptoDAO = cryptoDAO;
        executor = exec;
    }

    public Single<RateResponse> getOneRateResponse(int id) {
        return cryptoDAO.getOneRateResponse(String.valueOf(id));
    }

    public void insertRate(RateResponse rateResponse) {
        executor.execute(() -> {
            cryptoDAO.insertRate(rateResponse);
        });
    }

    public void deleteAllRates() {
        executor.execute(() -> {
            cryptoDAO.deleteAllRates();
        });
    }
}
