package it.unicam.cs.pa.jraceTrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.junit.*;
import static org.junit.Assert.*;


public class DefaultCarTest{

    @Test
    public void testMoveUp() {
        Point2D p1 = new Point2D(0,0);
        Point2D p2 = new Point2D(0,20);
        Point2D p3 = new Point2D(20,0);
        Point2D p4 = new Point2D(0,20);
        ArrayList<Point2D> partenza = new ArrayList<>();
        partenza.add(p1);
        partenza.add(p2);
        List<Point2D> arrivo = new ArrayList<>();
        arrivo.add(p3);
        arrivo.add(p4);
        Point2D l = new Point2D(1,1);
        DefaultTrack2D<Point2D, DefaultStateCar> tr = new DefaultTrack2D<>(20,20, partenza, arrivo);
        Car<Point2D, DefaultStateCar> car1 = new DefaultCar<>(tr, null, l);
        tr.addCar(car1);
        assertNotNull(tr.getCarAt(l));
        Set<Point2D> a = car1.getLocation().getNextPoint(20, 20);
    /*    for(Point2D p : a){
            System.out.println(p.toString());
        }*/
        Point2D next = new Point2D(4,1);
        car1.moveUp(next);
        assertSame(car1.getLocation(), next);
        assertNotNull(tr.getCarAt(next));
        assertNull(tr.getCarAt(l));
        Set<Point2D> a1 = car1.getLocation().getNextPoint(20, 20);
        for(Point2D p : a1){
            System.out.println(p.toString());
        }
    }
}