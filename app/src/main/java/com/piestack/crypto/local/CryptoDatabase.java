package com.piestack.crypto.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.piestack.crypto.model.RateResponse;

@Database(entities = {RateResponse.class}, version = 1)
public abstract class CryptoDatabase extends RoomDatabase {
    public abstract CryptoDAO cryptoDAO();
}
