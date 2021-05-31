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
        Point2D p4 = new Point2D(0,20);
        List<Point2D> partenza = new ArrayList<>();
        partenza.add(p1);
        partenza.add(p2);
        List<Point2D> arrivo = new ArrayList<>();
        arrivo.add(p3);
        arrivo.add(p4);
        Point2D l1 = new Point2D(1,1);
        Point2D l3 = new Point2D(3,1);
        DefaultTrack2D<Point2D, DefaultStateCar> tr = new DefaultTrack2D<>(20,20, partenza, arrivo);
        Car<Point2D, DefaultStateCar> car1 = new DefaultCar<>(tr, null, l1);
        Car<Point2D, DefaultStateCar> car2 = new DefaultCar<>(tr, null, l3);
        tr.addCar(car1);
        tr.addCar(car2);
        Point2D l2 = new Point2D(2,2);
        car1.setLocation(l2);
        tr.apply(l2,null);
        assertNull(tr.getCarAt(l1));
        assertNotNull(tr.getCarAt(l2));
    }
}