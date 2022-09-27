package com.example;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;

public class Polygon {

    protected ArrayList<Dot> coordinates;

    public Polygon(ArrayList<Dot> coordinates) {
        this.coordinates = coordinates;
    }

    public Double getArea() {
//        Shoelace formula
        double x = 0;
        double y = 0;

        for (int i = 0; i < coordinates.size() - 1; i++) {
            double ax, ay;
            ax = coordinates.get(i).getX();
            ay = coordinates.get(i + 1).getY();
            x += coordinates.get(i).getX() * coordinates.get(i + 1).getY();

            double by, bx;
            by = coordinates.get(i).getY();
            bx = coordinates.get(i + 1).getX();
            y += coordinates.get(i).getY() * coordinates.get(i + 1).getX();
        }
//        ще одне додавання тому, що це вихід за межі масиву
        double ax, ay;
        ax = coordinates.get(coordinates.size() - 1).getX();
        ay = coordinates.get(0).getY();
        x += coordinates.get(coordinates.size() - 1).getX() * coordinates.get(0).getY();

        double by, bx;
        by = coordinates.get(coordinates.size() - 1).getY();
        bx = coordinates.get(0).getX();
        y += coordinates.get(coordinates.size() - 1).getY() * coordinates.get(0).getX();

        return Math.abs((x - y) / 2);
    }

    public Double getAmountOfDots(){
        Double amount = 0.0;
        for (int i = 0; i < coordinates.size() - 1; i++){
            Double x, y;
            x = Math.abs(coordinates.get(i + 1).getX() - coordinates.get(i).getX());
            y = Math.abs(coordinates.get(i + 1).getY() - coordinates.get(i).getY());
            double tmp = gcd(x.intValue(), y.intValue());
            amount += gcd(x.intValue(), y.intValue());
        }
        Double x, y;
        x = Math.abs(coordinates.get(coordinates.size() - 1).getX() - coordinates.get(0).getX());
        y = Math.abs(coordinates.get(coordinates.size() - 1).getY() - coordinates.get(0).getY());
        amount += gcd(x.intValue(), y.intValue());

        return amount;
    }

    public Integer getAmountOfInnerDots(){
        double result = getArea() - getAmountOfDots() / 2 + 1;
        return (int) result;
    }

    private Integer gcd(int n1, int n2){
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "coordinates=" + coordinates +
                '}';
    }

    public String pretty(){
        return "Coordinates={" + coordinates +
                '}';
    }
}
