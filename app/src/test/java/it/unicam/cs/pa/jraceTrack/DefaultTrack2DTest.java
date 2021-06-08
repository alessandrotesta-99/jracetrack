package it.unicam.cs.pa.jraceTrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DefaultTrack2DTest{

    @Test
    public void testGetCarAt() {
        Point2D p1 = new Point2D(0,0);
        Point2D p2 = new Point2D(0,20);
        Point2D p3 = new Point2D(20,0);
        Point2D p4 = new Point2D(20,20);
        List<Point2D> partenza = new ArrayList<>();
        partenza.add(p1);
        partenza.add(p2);
        List<Point2D> arrivo = new ArrayList<>();
        arrivo.add(p3);
        arrivo.add(p4);

        //test costruttore.
        Point2D a1 = new Point2D(1,1);
        Point2D a2 = new Point2D(1,2);
        Point2D a3 = new Point2D(1,3);
        Point2D a4 = new Point2D(2,1);
        Point2D a5 = new Point2D(2,2);
        Point2D a6 = new Point2D(2,3);
        Point2D a7 = new Point2D(3,2);
        Point2D a8 = new Point2D(3,3);
        partenza.forEach(System.out::println);
        DefaultTrack2D<Point2D, DefaultStateCar> tr = new DefaultTrack2D<>( partenza, arrivo,
                a1, a2, a3, a4, a5, a6, a7, a8);
        tr.getWalls().forEach(System.out::println);
    }

    @Test
    public void testCreateTrackCircle(){
        Point2D w1 = new Point2D(1,1);
        Point2D w2 = new Point2D(1,8);
        Point2D w3 = new Point2D(10,1);
        Point2D w4 = new Point2D(10,8);

        Point2D w5 = new Point2D(3,3);
        Point2D w6 = new Point2D(3,6);
        Point2D w7 = new Point2D(8,3);
        Point2D w8 = new Point2D(8,6);

        Point2D p1 = new Point2D(5,6);
        Point2D p2 = new Point2D(5,8);

        Point2D p3 = new Point2D(5,6);
        Point2D p4 = new Point2D(5,8);

        List<Point2D> start = new ArrayList<>();
        start.add(p1);
        start.add(p2);
        List<Point2D> finish = new ArrayList<>();
        finish.add(p3);
        finish.add(p4);

       new DefaultTrack2D<>(start,finish,w1,w2,w3,w4,w5,w6,w7,w8);
    }

    @Test
    public void testCreateTrackNotCircle(){
        Point2D w1 = new Point2D(1,1);
        Point2D w2 = new Point2D(1,8);
        Point2D w3 = new Point2D(10,1);
        Point2D w4 = new Point2D(10,8);

        Point2D w5 = new Point2D(3,3);
        Point2D w6 = new Point2D(3,6);
        Point2D w7 = new Point2D(8,3);
        Point2D w8 = new Point2D(8,6);

        Point2D p1 = new Point2D(5,6);
        Point2D p2 = new Point2D(5,8);

        Point2D p3 = new Point2D(1,4);
        Point2D p4 = new Point2D(3,4);

        List<Point2D> start = new ArrayList<>();
        start.add(p1);
        start.add(p2);
        List<Point2D> finish = new ArrayList<>();
        finish.add(p3);
        finish.add(p4);

        new DefaultTrack2D<>(start,finish,w1,w2,w3,w4,w5,w6,w7,w8);
    }

    @Test
    public void testApply() {
    }

    @Test
    public void testGetNextLocs() {
    }

    @Test
    public void testConstructor(){
    }
}