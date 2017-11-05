package com.piestack.crypto.di.module;

import android.app.Application;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Jeffrey Nyauke on 9/10/2017.
 */

@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    public CompositeDisposable provideCompositeSubscription() {
        return new CompositeDisposable();
    }

    @Singleton
    @Provides
    public Executor getExecutor(){
        return  Executors.newFixedThreadPool(2);
    }
}
