package com.piestack.crypto;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.piestack.crypto.model.Rate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RateAdapter extends RecyclerView.Adapter<RateAdapter.ViewHolder> {

    private Context mContext;
    public List<Rate> rates;
    private RateAdapterListener listener;
    public int type;

    public RateAdapter(Context mContext, List<Rate> rates, RateAdapterListener listener, int type) {
        this.mContext = mContext;
        this.rates = rates;
        this.listener = listener;
        this.type = type;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_rate, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Rate rate = rates.get(position);
        if (type == 0)
            holder.base.setText("Bitcoin");
        else
            holder.base.setText("Etherethum");
        holder.change.setText(rate.getSymbol() + " | " + rate.getName());
        holder.rate.setText(rate.getRate());
        applyClickEvents(holder, position);
    }

    @Override
    public int getItemCount() {
        return rates.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void removeData(int position) {
        rates.remove(position);
        notifyItemRemoved(position);
    }

    private void applyClickEvents(ViewHolder holder, final int position) {

        holder.container.setOnClickListener(view -> listener.onRateClicked(position));

    }

    public interface RateAdapterListener {
        void onRateClicked(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvBase)
        TextView base;
        @BindView(R.id.tvChange)
        TextView change;
        @BindView(R.id.tvRate)
        TextView rate;
        @BindView(R.id.container)
        FrameLayout container;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
