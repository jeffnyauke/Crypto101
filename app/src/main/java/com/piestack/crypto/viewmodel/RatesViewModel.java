package com.piestack.crypto.viewmodel;


import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.piestack.crypto.model.RateResponse;
import com.piestack.crypto.repository.LocalRepository;
import com.piestack.crypto.repository.RemoteRepository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class RatesViewModel extends ViewModel {

    private RemoteRepository remoteRepository;
    private LocalRepository localRepository;

    private CompositeDisposable compositeDisposable;


    public RatesViewModel(RemoteRepository remoteRepository, LocalRepository localRepository, CompositeDisposable disposable) {
        this.remoteRepository = remoteRepository;
        this.localRepository = localRepository;
        compositeDisposable = disposable;
    }

    public Single<RateResponse> getOneRateResponse(int id){
        return localRepository.getOneRateResponse(id);
    }

    public void insertRate(RateResponse rateResponse){
        localRepository.insertRate(rateResponse);
    }

    public void deleteAllRates(){
        localRepository.deleteAllRates();
    }

    public void getRatesFromService(String cryptoSymbol, String currencyArray,int type){
        //add observable to CompositeDisposable so that it can be dispose when ViewModel is ready to be destroyed
        //Call retrofit client on background thread and update database with response from service using Room
        compositeDisposable.add(io.reactivex.Single.just(1)
                .subscribeOn(Schedulers.computation())
                .flatMap(i -> { return remoteRepository.getRates(cryptoSymbol, currencyArray);}).subscribeOn(Schedulers.io())
                .subscribe(rateResponse -> {
                    if(type == 1)
                    rateResponse.setId(1);
                    else
                        rateResponse.setId(2);
                    localRepository.insertRate(rateResponse);
                }, throwable -> Log.e("RatesViewModel", "exception getting rates", throwable)));

    }

    @Override
    public void onCleared() {
        //prevents memory leaks by disposing pending observable objects
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
        }
    }

}
