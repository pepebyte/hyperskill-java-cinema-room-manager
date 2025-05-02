package com.pepebyte.cinema.scene;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CinemaScene implements Scene2D{

    public Place[][] places;
    public final int rows;
    public final int columns;

    public CinemaScene(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.places = new Place[rows][columns];
        Arrays.stream(places).forEach(arr->Arrays.fill(arr, Place.Free));
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public void setPlaces(int i, int j) {
        this.places[i][j] = Place.Busy;

    }

    @Override
    public Place getPlace(int i, int j) {
        return this.places[i][j];
    }

    @Override
    public String scheme() {

        // determine scaling size
        final int rowLength = (int) (Math.log10(rows) + 1);
        final int columnLength = (int) (Math.log10(columns) + 1);

        // first row filled with indices
        String numeration = IntStream.rangeClosed(1, columns)
                .mapToObj(i -> extend("" + i, columnLength))
                .collect(Collectors.joining(" "));

        // rows with starting index
        String scheme = IntStream.rangeClosed(1, rows)
                .mapToObj(i -> extend("" + i, rowLength) + " " + Arrays.stream(places[i - 1])
                        .map(j -> extend(j.sign, columnLength))
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));

        // join indices with rows
        return " " + " ".repeat(rowLength) + numeration + "\n" + scheme;
    }

    private String extend(String elem, int length) {
        return " ".repeat(length - elem.length()) + elem;
    }
}
