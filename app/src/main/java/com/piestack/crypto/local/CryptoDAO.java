package com.piestack.crypto.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.piestack.crypto.model.RateResponse;

import io.reactivex.Single;

@Dao
public interface CryptoDAO {

    @Query("SELECT * FROM RateResponse WHERE id = :id LIMIT 1")
    Single<RateResponse> getOneRateResponse(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRate(RateResponse rateResponse);

    @Query("DELETE FROM RateResponse")
    void deleteAllRates();
}
