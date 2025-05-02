package com.pepebyte.cinema.scene;

public enum Place {
    Free("S"),
    Busy("B");

    public final String sign;

    Place(String sign) {
        this.sign = sign;
    }
}
