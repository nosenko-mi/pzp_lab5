package com.example;

import java.util.ArrayList;

public class ConvexHull extends Polygon {

    public ConvexHull(ArrayList<Dot> coordinates) {
        super(coordinates);
        this.coordinates = createHull(coordinates);
    }

    private ArrayList<Dot> createHull(ArrayList<Dot> dots){
//        Dot p0 = dots.get(0);
//        for (Dot p : dots)
//            if (p.getX() < p0.getX())
//                p0 = p;
//
//        ArrayList<Dot> hull = new ArrayList<>();
//        hull.add(p0);
//
//        while (true) {
//            Dot t = p0; // кандидат на следующую точку
//            for (Dot p : dots){
//                // лучше никакие полярные углы не считать
//                Dot tmp1 = p.minus(p0);
//                Dot tmp2 = t.minus(p0);
//                if (tmp1.crossProduct(tmp2) > 0)
//                    t = p;
//            }
//            if (t == p0)
//                break;
//            else {
//                p0 = t;
//                hull.add(t);
//            }
//        }
//        return hull;
//        System.out.println("dots before: \n" + dots);

//        ok
        Dot p0 = dots.get(0);
        int len = dots.size();
        for (Dot p : dots)
            if (p.getX() < p0.getX())
                p0 = p;
        ArrayList<Dot> hull = new ArrayList<>();
        hull.add(p0);
//        System.out.println("start point: " + hull);
//        think about stack
        dots.remove(p0);
        dots.add(p0);
//        System.out.println("dots after: \n" + dots);

        while (true) {
//            Dot t = p0; // кандидат на следующую точку
//            for (Dot p : dots){
//                // лучше никакие полярные углы не считать
//                if (rotate(p0, t, p) < 0)
//                    t = p;
//            }
//            if (t == p0)
//                break;
//            else {
//                p0 = t;
//                hull.add(t);
//            }
            int right = 0;
            for (int i = 0; i < dots.size(); i++){
                if (rotate(hull.get(hull.size()- 1), dots.get(right), dots.get(i)) > 0)
                    right = i;
            }
            if (dots.get(right)==hull.get(0)){
                break;
            }
            else{
                hull.add(dots.get(right));
                dots.remove(right);
            }
        }

        return hull;
//        while True:
//            right = 0
//            for i in range(1,len(P)):
//                if rotate(A[H[-1]],A[P[right]],A[P[i]])<0:
//                    right = i
//                if P[right]==H[0]:
//                    break
//                else:
//                    H.append(P[right])
//                    del P[right]
//        return H
    }

    public Double getAreaByTriangles() {
        if (coordinates.size() < 4) return super.getArea();

        // 3 dots a b c -> 2 vectors AB AC
        // S = 1/2 ((b.x - a.x)(c.y - b.y) - (b.y - a.y)(c.x - b.x))
        Dot a, b, c;
        a = coordinates.get(0);
        double area = 0.0;
        for (int i = 1; i < coordinates.size() - 1; i++){
            b = coordinates.get(i);
            c = coordinates.get(i + 1);

            area += 0.5 * Math.abs((b.getX() - a.getX()) * (c.getY() - b.getY())
                    - (b.getY() - a.getY()) * (c.getX() - b.getX()));

        }
        return area;
    }

    private Double rotate(Dot a, Dot b, Dot c){
        return (b.getX()-a.getX())*(c.getY()-b.getY())-(b.getY()-a.getY())*(c.getX()-b.getX());
    }
}
