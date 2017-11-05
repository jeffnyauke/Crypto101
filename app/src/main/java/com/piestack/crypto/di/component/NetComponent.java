package com.piestack.crypto.di.component;

import com.piestack.crypto.BtcFragment;
import com.piestack.crypto.EthFragment;
import com.piestack.crypto.di.module.NetModule;
import com.piestack.crypto.di.module.RateModule;
import com.piestack.crypto.di.qualifiers.RateScope;

import dagger.Subcomponent;


/**
 * Created by Jeffrey Nyauke on 9/10/2017.
 */

@RateScope
@Subcomponent(modules = {NetModule.class, RateModule.class})
public interface NetComponent {
    void inject(BtcFragment fragment);
    void inject(EthFragment fragment);
}
