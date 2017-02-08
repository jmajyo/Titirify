package com.jmajyo.titirify.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jmajyo.titirify.R;
import com.jmajyo.titirify.adapters.StadisticAdapter;
import com.jmajyo.titirify.model.Hat;

import io.realm.Realm;
import io.realm.RealmResults;

public class ProfitActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StadisticAdapter adapter;
    Realm realm = Realm.getDefaultInstance();
    private RealmResults<Hat> hat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profit);

        hat = realm.where(Hat.class).findAllSorted("date");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new StadisticAdapter(this, hat);
        recyclerView.setAdapter(adapter);

    }
}
