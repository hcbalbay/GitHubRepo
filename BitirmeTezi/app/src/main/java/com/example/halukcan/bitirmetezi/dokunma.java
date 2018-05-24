package com.example.halukcan.bitirmetezi;

public class dokunma {
    Canvas canvas;
    String isim ;
    int X, Y ;
    int id;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public dokunma(String isim, int x, int y, int id) {
        this.isim = isim;
        X = x;
        Y = y;
        this.id = id;
    }

}
