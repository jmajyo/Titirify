package com.jmajyo.titirify.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jmajyo.titirify.R;
import com.jmajyo.titirify.model.Hat;

import java.text.SimpleDateFormat;

public class StadisticViewHolder extends RecyclerView.ViewHolder{
    private TextView dosEuros;
    private TextView unEuro;
    private TextView cincuentaCents;
    private TextView veinteCents;
    private TextView diezCents;
    private TextView cincoCents;

    private TextView fecha;
    private TextView hora;
    private TextView total;

    private Button hideShow;

    private Hat hat;


    public StadisticViewHolder(View itemView) {
        super(itemView);
        dosEuros = (TextView) itemView.findViewById(R.id.activity_profit___2_euros_text);
        unEuro = (TextView) itemView.findViewById(R.id.activity_profit___1_euro_text);
        cincuentaCents = (TextView) itemView.findViewById(R.id.activity_profit___50_cent_text);
        veinteCents = (TextView) itemView.findViewById(R.id.activity_profit___20_cent_text);
        diezCents = (TextView) itemView.findViewById(R.id.activity_profit___10_cent_text);
        cincoCents = (TextView) itemView.findViewById(R.id.activity_profit___5_cent_text);

        hora = (TextView) itemView.findViewById(R.id.activity_profit___hours_text);
        fecha = (TextView) itemView.findViewById(R.id.activity_profit___date_text);
        total = (TextView) itemView.findViewById(R.id.activity_profit___money_text);

        hideShow = (Button) itemView.findViewById(R.id.activity_profit___hideShow_button);

    }

    public Hat getHat() {
        return hat;
    }

    public void setHat(Hat hat) {
        this.hat = hat;
        showAmountCoins(hat);
    }

    private void showAmountCoins(Hat hat) {

        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MMM");
        String formattedDate = dt1.format(hat.getDate());

        SimpleDateFormat dt2 = new SimpleDateFormat("HH:mm");
        String formattedHour = dt2.format(hat.getDate());

        fecha.setText(formattedDate);
        hora.setText(formattedHour);
        total.setText(String.format("%.2f €",hat.getTotal()));


        dosEuros.setText("" + hat.getTwoEuroCounter());
        unEuro.setText("" + hat.getOneEuroCounter());
        cincuentaCents.setText("" + hat.getFiftyCentCounter());
        veinteCents.setText("" + hat.getTwentyCentCounter());
        diezCents.setText("" + hat.getFiveCentCounter());
        cincoCents.setText("" + hat.getFiveCentCounter());
    }


}
