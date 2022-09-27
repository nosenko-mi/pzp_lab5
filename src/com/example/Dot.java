package com.example;

public class Dot {

    private Double x;
    private Double y;

    public Dot(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getDistanceTo(Dot dot){
        return Math.sqrt(Math.pow((x - dot.x), 2) + Math.pow((y - dot.y), 2));
    }

    public Dot minus(Dot d){
//      a.x-b.x, a.y-b.y;
        return new Dot(this.x - d.x, this.y - d.y);
    }

    public Double crossProduct(Dot d){
//      a.x*b.y - b.x*a.y;
        return this.x * d.y - d.x * this.y;
    }

//    def rotate(this,b,c):
//            return (b[0]-this[0])*(c[1]-b[1])-(b[1]-this[1])*(c[0]-b[0])

    public Double rotate(Dot b, Dot c){
        return (b.x-this.x)*(c.y-b.y)-(b.y-this.y)*(c.x-b.x);
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Dot{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
