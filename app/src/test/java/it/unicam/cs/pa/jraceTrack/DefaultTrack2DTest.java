package it.unicam.cs.pa.jraceTrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
        Point2D l1 = new Point2D(1,1);
        Point2D l3 = new Point2D(3,1);

        //test costruttore.
        Point2D a1 = new Point2D(1,1);
        Point2D a2 = new Point2D(1,2);
        Point2D a3 = new Point2D(1,3);
        Point2D a4 = new Point2D(2,1);
        Point2D a5 = new Point2D(2,2);
        Point2D a6 = new Point2D(2,3);
        Point2D a7 = new Point2D(3,2);
        Point2D a8 = new Point2D(3,3);
        System.out.println(partenza.size());
        partenza.forEach(System.out::println);
        DefaultTrack2D<Point2D, DefaultStateCar> tr = new DefaultTrack2D<>(20,20, partenza, arrivo,
                a1, a2, a3, a4, a5, a6, a7, a8);
        Car<Point2D, DefaultStateCar> car1 = new DefaultCar<>(tr, null);
        Car<Point2D, DefaultStateCar> car2 = new DefaultCar<>(tr, null);
        tr.addCar(car1);
        tr.addCar(car2);
        Point2D l2 = new Point2D(2,2);
        car1.setLocation(l2);
        tr.apply(l2,null);
        assertNull(tr.getCarAt(l1));
        assertNotNull(tr.getCarAt(l2));
        assertEquals(8, tr.getWalls().size());
        tr.getWalls().forEach(System.out::println);
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