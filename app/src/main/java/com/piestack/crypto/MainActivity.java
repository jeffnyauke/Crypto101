package com.piestack.crypto;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.piestack.crypto.viewmodel.RatesViewModel;
import com.piestack.crypto.viewmodel.RatesViewModelFactory;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {

    @Inject
    @Named("activity")
    CompositeDisposable compositeDisposable;
    @Inject
    RatesViewModelFactory ratesViewModelFactory;

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_btc:
                changeFragment(0);
                return true;
            case R.id.navigation_eth:
                changeFragment(1);
                return true;
        }
        return false;
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        changeFragment(0);
    }

    /**
     * To load fragments for displaying cards for BTC and
     * ETH respectively
     *
     * @param position menu index
     */
    private void changeFragment(int position) {

        Fragment newFragment = null;

        if (position == 0) {
            newFragment = new BtcFragment();
        } else if (position == 1) {
            newFragment = new EthFragment();
        }

        getSupportFragmentManager().beginTransaction().replace(
                R.id.content, newFragment)
                .commit();
    }

}
