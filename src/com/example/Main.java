package com.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {



        ArrayList<Dot> dots = new ArrayList<>();
//        dots.add(new Dot(-1., -1.));
//        dots.add(new Dot(-3., -2.));
//        dots.add(new Dot(-2., -3.));
//        dots.add(new Dot(-3., -4.));
//        dots.add(new Dot(-1., -4.));
//        dots.add(new Dot(-2., -6.));
//        dots.add(new Dot(2., -6.));
//        dots.add(new Dot(1., -2.));

//        dots.add(new Dot(1., 1.));
//        dots.add(new Dot(1., 4.));
//        dots.add(new Dot(2., 3.));
//        dots.add(new Dot(3., 5.));
//        dots.add(new Dot(4., 4.));
//        dots.add(new Dot(3., 1.));

        dots = FileController.loadData("input.txt");
        ConvexHull hull = new ConvexHull(dots);
        System.out.println(hull);
        System.out.println(hull.getArea());
        System.out.println(hull.getAreaByTriangles());

        Double area = hull.getAreaByTriangles();
        if (area > 0){
            String resultText = hull.pretty() + "\n\n" + area;
            FileController.saveData("output.txt", resultText);
        }
    }
}
