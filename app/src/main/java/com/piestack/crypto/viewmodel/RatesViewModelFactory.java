package com.piestack.crypto.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.piestack.crypto.di.qualifiers.RateScope;
import com.piestack.crypto.repository.LocalRepository;
import com.piestack.crypto.repository.RemoteRepository;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.disposables.CompositeDisposable;

@RateScope
public class RatesViewModelFactory implements ViewModelProvider.Factory {

    @Inject
    LocalRepository localRepository;
    @Inject
    RemoteRepository remoteRepository;
    @Inject
    @Named("vm")
    CompositeDisposable compositeDisposable;

    @Inject
    public RatesViewModelFactory() {
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(RatesViewModel.class)) {
            return (T) new RatesViewModel(remoteRepository, localRepository, compositeDisposable);
        }
        throw new IllegalArgumentException("Wrong ViewModel class");
    }
}
