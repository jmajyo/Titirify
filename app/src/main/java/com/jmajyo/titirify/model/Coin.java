package com.jmajyo.titirify.model;

import io.realm.RealmObject;

public class Coin extends RealmObject{
    public Coin() {
    }

    private float value;
    private int image;

    public Coin(float value, int image) {
        this.value = value;
        this.image = image;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
