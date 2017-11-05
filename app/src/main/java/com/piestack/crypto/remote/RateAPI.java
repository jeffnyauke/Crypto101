package com.piestack.crypto.remote;


import com.piestack.crypto.model.RateResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RateAPI {

    @GET("data/price")
    Call<RateResponse> getRates(@Query("fsym") String cryptoSymbol, @Query("tsyms") String currencyArray);

}
