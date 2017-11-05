package com.piestack.crypto.di.component;

import com.piestack.crypto.di.module.AppModule;
import com.piestack.crypto.di.module.NetModule;
import com.piestack.crypto.di.module.RateModule;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by Jeffrey Nyauke on 9/10/2017.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    NetComponent getNetComponent(NetModule netModule, RateModule rateModule);
}
