package com.pepebyte.cinema.scene;

public interface Scene2D extends Scene {
    int getRows();
    int getColumns();
    void setPlaces(int i, int j);
    Place getPlace(int i, int j);

    @Override
    default int getPlaces(){
        return getRows()*getColumns();
    }
}
