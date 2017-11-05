package com.piestack.crypto;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.piestack.crypto.di.module.NetModule;
import com.piestack.crypto.di.module.RateModule;
import com.piestack.crypto.model.Rate;
import com.piestack.crypto.viewmodel.RatesViewModel;
import com.piestack.crypto.viewmodel.RatesViewModelFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 * <p>
 * This fragment will have BTC as the base currency
 */
public class BtcFragment extends Fragment implements RateAdapter.RateAdapterListener {

    public static final String MyPREFERENCES = "MyPrefs";
    @Inject
    @Named("activity")
    CompositeDisposable compositeDisposable;
    @Inject
    RatesViewModelFactory ratesViewModelFactory;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    private RatesViewModel ratesViewModel;
    private Unbinder unbinder;
    private RateAdapter rateAdapter;


    public BtcFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rates, container, false);
        unbinder = ButterKnife.bind(this, view);

        MyApplication.getComponent(getContext())
                .getNetComponent(new NetModule(Config.API_HOST), new RateModule(getContext())).inject(this);

        //instantiate view model
        ratesViewModel = ViewModelProviders.of(this, ratesViewModelFactory).get(RatesViewModel.class);

        sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        Set<String> defaults = new HashSet<>();
        defaults.add("ETH");

        Set<String> set = sharedpreferences.getStringSet("btcs", defaults);

        getRates(set);

        //recyclerView to show list of data items from database
        RecyclerView.LayoutManager couponLayoutManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(couponLayoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setHasFixedSize(true);

        return view;
    }

    private void getRates(Set<String> set) {
        //call retrofit service to get latest data and update database
        //runs in the background thread
        ratesViewModel.getRatesFromService("BTC", EthFragment.setToString(set), 1);
        Log.e("trail", EthFragment.setToString(set));
    }

    @Override
    public void onStart() {
        super.onStart();
        compositeDisposable.add(ratesViewModel.getOneRateResponse(1)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(rates -> {
                    if (rates != null) {
                        List<Rate> arrayRates = rates.toRateArray();
                        rateAdapter = new RateAdapter(getContext(), arrayRates, BtcFragment.this, 0);
                        recycler.setAdapter(rateAdapter);
                        Log.e("BTC Ftragment",rates.toString());
                    }
                }, throwable -> Log.e("BTC Fragment", "exception getting rates", throwable)));
    }

    @OnClick(R.id.fab)
    public void newCurrencies() {
        showDialog();
    }

    public void showDialog() {
        Set<String> selecteds = new HashSet<String>();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add currencies");

        //list of items
        String[] items = getResources().getStringArray(R.array.btc_currencies);
        String[] symbols = getResources().getStringArray(R.array.symbols_btc);
        boolean[] selectedItemsArray = new boolean[]{true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        builder.setMultiChoiceItems(items, selectedItemsArray,
                (dialog, which, isChecked) -> {
                    //item checked logic
                    // Update the current focused item's checked status
                    selectedItemsArray[which] = isChecked;
                });

        String positiveText = getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                (dialog, which) -> {
                    // positive button logic
                    for (int i = 0; i < selectedItemsArray.length; i++) {
                        boolean checked = selectedItemsArray[i];
                        if (checked) {
                            selecteds.add(symbols[i]);
                        }
                    }
                    editor = sharedpreferences.edit();
                    editor.putStringSet("btcs", selecteds);
                    editor.commit();

                    getRates(selecteds);
                });

        String negativeText = getString(android.R.string.cancel);
        builder.setNegativeButton(negativeText,
                (dialog, which) -> {
                    // negative button logic
                    dialog.cancel();
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }

    @Override
    public void onDestroy() {
        //dispose subscriptions
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
        }
        unbinder.unbind();
        super.onDestroy();
    }

    @Override
    public void onRateClicked(int position) {
        Rate rate = rateAdapter.rates.get(position);
        Intent intent = new Intent(getActivity(), ExchangeActivity.class);
        intent.putExtra("symbol", rate.getSymbol());
        intent.putExtra("name", rate.getName());
        intent.putExtra("rate", rate.getRate());
        intent.putExtra("type", "0");
        startActivity(intent);
    }
}
