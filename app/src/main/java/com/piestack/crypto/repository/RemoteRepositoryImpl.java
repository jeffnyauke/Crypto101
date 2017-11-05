package com.piestack.crypto.repository;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.NetworkInfo;

import com.piestack.crypto.MyApplication;
import com.piestack.crypto.model.RateResponse;
import com.piestack.crypto.remote.RateAPI;
import com.piestack.crypto.remote.model.ServiceError;
import com.piestack.crypto.remote.model.ServiceResponse;

import java.io.IOException;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import retrofit2.Call;

import static com.piestack.crypto.remote.model.ServiceError.NETWORK_ERROR;
import static com.piestack.crypto.remote.model.ServiceError.SUCCESS_CODE;
import static com.piestack.crypto.utils.NetworkUtils.getNetworkInfo;

public class RemoteRepositoryImpl implements RemoteRepository {
    private static final String UNDELIVERABLE_EXCEPTION_TAG = "Undeliverable exception";
    private static final int ERROR_UNDEFINED = -1;
    private final RateAPI networkService;

    public RemoteRepositoryImpl(RateAPI networkService) {
        this.networkService = networkService;
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isConnected(final Context context) {
        NetworkInfo info = getNetworkInfo(context);
        return (info == null || !info.isConnected());
    }

    @Override
    public Single<RateResponse> getRates(final String cryptoSymbol, final String currencyArray) {
        return Single.create(singleOnSubscribe -> {
                    if (isConnected(MyApplication.getContext())) {
                        Exception exception = new NetworkErrorException();
                        singleOnSubscribe.onError(exception);
                    } else {
                        try {
                            ServiceResponse serviceResponse = processCall(networkService.getRates(cryptoSymbol, currencyArray), false);
                            if (serviceResponse.getCode() == SUCCESS_CODE) {
                                RateResponse rateResponse = (RateResponse) serviceResponse.getData();
                                singleOnSubscribe.onSuccess(rateResponse);
                            } else {
                                Throwable throwable = new NetworkErrorException();
                                singleOnSubscribe.onError(throwable);
                            }
                        } catch (Exception e) {
                            singleOnSubscribe.onError(e);
                        }
                    }
                }
        );
    }

    @NonNull
    private ServiceResponse processCall(Call call, boolean isVoid) {
        if (isConnected(MyApplication.getContext())) {
            return new ServiceResponse(new ServiceError());
        }
        try {
            retrofit2.Response response = call.execute();
            if (isNull(response)) {
                return new ServiceResponse(new ServiceError(NETWORK_ERROR, ERROR_UNDEFINED));
            }
            int responseCode = response.code();
            if (response.isSuccessful()) {
                return new ServiceResponse(responseCode, isVoid ? null : response.body());
            } else {
                ServiceError ServiceError;
                ServiceError = new ServiceError(response.message(), responseCode);
                return new ServiceResponse(ServiceError);
            }
        } catch (IOException e) {
            return new ServiceResponse(new ServiceError(NETWORK_ERROR, ERROR_UNDEFINED));
        }
    }


}