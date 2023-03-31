import com.sun.tools.javac.Main;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;
import java.util.*;

public class Quicksort {
    Point[] A;
    public void x() {
        // ArrayList
        A = new Point[10];
        Random r = new Random();
        ArrayList<Point> B = new ArrayList<Point>();
        for (int i = 0; i < A.length; i++) {
            A[i] = new Point();
            A[i].x = r.nextInt(30);
            A[i].y = r.nextInt(30);
            B.add(A[i]);
        }
        Comparator<Point> _comp = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x; //If return 0, position equals equal, if positive, greater than o1, if negative, greater than o2
                //If you change it to o1.y, it will be sorted by y value
                // -(o1.x - o2.x) ascending or descending order
            }
        };
        Collections.sort(B,_comp);
        for (int i = 0; i < B.size(); i++) {
            System.out.println(B.get(i));
        }
    }
    public static void main(String[] args){
        Quicksort m = new Quicksort();
        m.x();

    }




}