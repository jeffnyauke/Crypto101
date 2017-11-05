package com.piestack.crypto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExchangeActivity extends AppCompatActivity {

    @BindView(R.id.tvBase)
    TextView tvbase;
    @BindView(R.id.tvChange)
    TextView tvchange;
    @BindView(R.id.tvRate)
    TextView tvrate;
    @BindView(R.id.tvBaseEx)
    EditText edBase;

    private String type;
    private String symbol;
    private String name;
    private String rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);
        ButterKnife.bind(this);


        TextWatcher watch = new TextWatcher(){

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onTextChanged(CharSequence s, int a, int b, int c) {
                // TODO Auto-generated method stub
                String entry = edBase.getText().toString().trim();
                double answer = Double.valueOf(rate)*Double.valueOf(entry.isEmpty() ? "0": entry);
                String value = String.valueOf(answer);
                edBase.setText(value);

            }};

        edBase.addTextChangedListener(watch);

        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        symbol = intent.getStringExtra("symbol");
        name = intent.getStringExtra("name");
        rate = intent.getStringExtra("rate");

        if (Integer.valueOf(type) == 0)
            tvbase.setText("Bitcoin");
        else
            tvbase.setText("Etherethum");
        tvchange.setText(symbol+ " | " + name);
        tvrate.setText(rate);
    }
}
