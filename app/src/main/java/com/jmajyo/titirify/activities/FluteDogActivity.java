package com.jmajyo.titirify.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmajyo.titirify.R;
import com.jmajyo.titirify.model.Coins;
import com.jmajyo.titirify.model.Hat;
import com.jmajyo.titirify.util.Temblator;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;

public class FluteDogActivity extends AppCompatActivity {

    private ImageView dosEuroButton;
    private ImageView unEuroButton;
    private ImageView cincuentaCentButton;
    private ImageView veinteCentButton;
    private ImageView diezCentButton;
    private ImageView cincoCentButton;
    private Button hatButton;

    private TextView dosEuroText;
    private TextView unEuroText;
    private TextView cincuentaCentText;
    private TextView veinteCentText;
    private TextView diezCentText;
    private TextView cincoCentText;
    private TextView totalMoneyAmount;

    private Hat gorra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //elimina la barra de notificaciones
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_flute_dog);
        dosEuroButton = (ImageView) findViewById(R.id.activity_flute_dog___2_euros);
        unEuroButton = (ImageView) findViewById(R.id.activity_flute_dog___1_euros);
        cincuentaCentButton = (ImageView) findViewById(R.id.activity_flute_dog___50_cent);
        veinteCentButton = (ImageView) findViewById(R.id.activity_flute_dog___20_cent);
        diezCentButton = (ImageView) findViewById(R.id.activity_flute_dog___10_cent);
        cincoCentButton = (ImageView) findViewById(R.id.activity_flute_dog___5_cent);
        hatButton = (Button) findViewById(R.id.activity_flute_dog___hat_button);

        dosEuroText = (TextView) findViewById(R.id.activity_flute_dog___2_euros_text);
        unEuroText = (TextView) findViewById(R.id.activity_flute_dog___1_euros_text);
        cincuentaCentText = (TextView) findViewById(R.id.activity_flute_dog___50_cent_text);
        veinteCentText = (TextView) findViewById(R.id.activity_flute_dog___20_cent_text);
        diezCentText = (TextView) findViewById(R.id.activity_flute_dog___10_cent_text);
        cincoCentText = (TextView) findViewById(R.id.activity_flute_dog___5_cent_text);
        totalMoneyAmount = (TextView) findViewById(R.id.activity_flute_dog___total_money_text_count);



        gorra = new Hat();

        dosEuroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gorra.addCoin(Coins.getTwoEuro());
                gorra.setTwoEuroCounter(gorra.getTwoEuroCounter()+1);
                dosEuroText.setText("" + gorra.getTwoEuroCounter());
                refresh();
            }
        });
        unEuroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gorra.addCoin(Coins.getOneEuro());
                gorra.setOneEuroCounter(gorra.getOneEuroCounter()+1);
                unEuroText.setText("" + gorra.getOneEuroCounter());
                refresh();
            }
        });
        cincuentaCentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gorra.addCoin(Coins.getFiftyCent());
                gorra.setFiftyCentCounter(gorra.getFiftyCentCounter()+1);
                cincuentaCentText.setText("" + gorra.getFiftyCentCounter());
                refresh();
            }
        });
        veinteCentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gorra.addCoin(Coins.getTwentyCent());
                gorra.setTwentyCentCounter(gorra.getTwentyCentCounter()+1);
                veinteCentText.setText("" + gorra.getTwentyCentCounter());
                refresh();
            }
        });
        diezCentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gorra.addCoin(Coins.getTenCent());
                gorra.setTenCentCounter(gorra.getTenCentCounter()+1);
                diezCentText.setText("" + gorra.getTenCentCounter());
                refresh();
            }
        });
        cincoCentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gorra.addCoin(Coins.getFiveCent());
                gorra.setFiveCentCounter(gorra.getFiveCentCounter()+1);
                cincoCentText.setText("" + gorra.getFiveCentCounter());
                refresh();
            }
        });
        hatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveHat();
                resetHat();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_main___action_statistics) {

            Intent i = new Intent(FluteDogActivity.this, ProfitActivity.class);
            startActivityForResult(i, 1);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveHat() {
        gorra.setDate(new Date());
        gorra.setTotal(gorra.getTotalValue());

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        realm.copyToRealm(gorra);
        realm.commitTransaction();

        //listar todos los hats de la tabla de HATS
        RealmResults<Hat> hats = realm.where(Hat.class).findAll();
        for (Hat h:hats ) {
            Log.d("REALM","Date: " + h.getDate() + " - monedas 2 € " + h.getTwoEuroCounter());
        }

    }

    private void resetHat() {
        gorra = new Hat();
        refresh();

        dosEuroText.setText("" + gorra.getTwoEuroCounter());
        unEuroText.setText("" + gorra.getOneEuroCounter());
        cincuentaCentText.setText("" + gorra.getFiftyCentCounter());
        veinteCentText.setText("" + gorra.getTwentyCentCounter());
        diezCentText.setText("" + gorra.getTenCentCounter());
        cincoCentText.setText("" + gorra.getFiveCentCounter());
    }

        private void refresh() {
        String formatDigit = String.format("%.2f €",gorra.getTotalValue());
        totalMoneyAmount.setText(formatDigit);
        Temblator.tremble(this,200);
    }
}
