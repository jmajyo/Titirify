package com.jmajyo.titirify.model;

import android.support.annotation.NonNull;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Hat {
    private Date date;
    private List<Coin> coins = new LinkedList<>();

    private int twoEuroCounter;
    private int oneEuroCounter;
    private int fiftyCentCounter;
    private int twentyCentCounter;
    private int tenCentCounter;
    private int fiveCentCounter;

    public void addCoin(@NonNull Coin coin){
        if(coin == null){
            return;
        }
        coins.add(coin);
    }

    public float getTotalValue(){
        float total=0;
        for (Coin c: coins ) {
            total = total + c.getValue();
        }
        return total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTwoEuroCounter() {
        return twoEuroCounter;
    }

    public void setTwoEuroCounter(int twoEuroCounter) {
        this.twoEuroCounter = twoEuroCounter;
    }

    public int getOneEuroCounter() {
        return oneEuroCounter;
    }

    public void setOneEuroCounter(int oneEuroCounter) {
        this.oneEuroCounter = oneEuroCounter;
    }

    public int getFiftyCentCounter() {
        return fiftyCentCounter;
    }

    public void setFiftyCentCounter(int fiftyCentCounter) {
        this.fiftyCentCounter = fiftyCentCounter;
    }

    public int getTwentyCentCounter() {
        return twentyCentCounter;
    }

    public void setTwentyCentCounter(int twentyCentCounter) {
        this.twentyCentCounter = twentyCentCounter;
    }

    public int getTenCentCounter() {
        return tenCentCounter;
    }

    public void setTenCentCounter(int tenCentCounter) {
        this.tenCentCounter = tenCentCounter;
    }

    public int getFiveCentCounter() {
        return fiveCentCounter;
    }

    public void setFiveCentCounter(int fiveCentCounter) {
        this.fiveCentCounter = fiveCentCounter;
    }
}
