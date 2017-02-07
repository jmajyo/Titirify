package com.jmajyo.titirify.model;

import com.jmajyo.titirify.R;

public class Coins {

    public static Coin getTwoEuro() {
        return new Coin(2, R.drawable.doseuro);
    }

    public static Coin getOneEuro() {
        return new Coin(1, R.drawable.uneuro);
    }

    public static Coin getFiftyCent() {
        return new Coin(0.5f, R.drawable.cincuentacents);
    }

    public static Coin getTwentyCent() {
        return new Coin(0.2f, R.drawable.veintecents);
    }

    public static Coin getTenCent() {
        return new Coin(0.1f, R.drawable.diezcent);
    }

    public static Coin getFiveCent() {
        return new Coin(0.05f, R.drawable.cincocents);
    }
}
