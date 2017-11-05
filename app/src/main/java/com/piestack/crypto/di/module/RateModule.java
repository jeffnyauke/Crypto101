package com.piestack.crypto.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.piestack.crypto.di.qualifiers.RateScope;
import com.piestack.crypto.local.CryptoDAO;
import com.piestack.crypto.local.CryptoDatabase;
import com.piestack.crypto.remote.RateAPI;
import com.piestack.crypto.repository.LocalRepository;
import com.piestack.crypto.repository.LocalRepositoryImpl;
import com.piestack.crypto.repository.RemoteRepository;
import com.piestack.crypto.repository.RemoteRepositoryImpl;

import java.util.concurrent.Executor;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class RateModule {

    private Context context;

    public RateModule(Context ctx) {
        context = ctx;
    }

    @RateScope
    @Provides
    public CryptoDAO getCryptoDAO(CryptoDatabase cryptoDatabase) {
        return cryptoDatabase.cryptoDAO();
    }

    @RateScope
    @Provides
    public CryptoDatabase getCryptoDatabase() {
        return Room.databaseBuilder(context.getApplicationContext(),
                CryptoDatabase.class, "crypto.db")
                .build();
    }

    @RateScope
    @Provides
    public LocalRepository getLocalRepo(CryptoDAO cryptoDAO, Executor exec) {
        return new LocalRepositoryImpl(cryptoDAO, exec);
    }

    @RateScope
    @Provides
    @Named("activity")
    public CompositeDisposable getCompositeDisposable() {
        return new CompositeDisposable();
    }

    @RateScope
    @Provides
    @Named("vm")
    public CompositeDisposable getVMCompositeDisposable() {
        return new CompositeDisposable();
    }

    @RateScope
    @Provides
    public RemoteRepository getRemoteRepo(RateAPI moneyApi) {
        return new RemoteRepositoryImpl(moneyApi);
    }
}
