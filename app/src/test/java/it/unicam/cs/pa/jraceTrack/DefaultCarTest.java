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
     /*   Point2D p1 = new Point2D(1,1);
        Point2D p2 = new Point2D(1,10);
        Point2D p3 = new Point2D(10,1);
        Point2D p4 = new Point2D(10,10);
        ArrayList<Point2D> partenza = new ArrayList<>();
        partenza.add(p1);
        partenza.add(p2);
        List<Point2D> arrivo = new ArrayList<>();
        arrivo.add(p3);
        arrivo.add(p4);
        //TODO aggiungere controllo: al punto di partenza la macchina deve stare in linea con i punti di partenza.
        Point2D l = new Point2D(1,2);
        DefaultTrack2D<Point2D, DefaultStateCar> tr = new DefaultTrack2D<>(20,20, partenza, arrivo);
        Car<Point2D, DefaultStateCar> car1 = new DefaultCar<>(tr, null, l);
        tr.addCar(car1);
        //controllo ulteriore
        assertNotNull(tr.getCarAt(l));
        //TODO non va bene che gia inzia e tocca sul muro del circuito.
        this.printNextPoint(car1);
      /*  Point2D next = new Point2D(4,1);
        car1.moveUp(next);
        //controlli ulteriori
        assertSame(car1.getLocation(), next);
        assertNotNull(tr.getCarAt(next));
        assertNull(tr.getCarAt(l));

        this.printNextPoint(car1);*/
    }

    private void printNextPoint(Car<Point2D, DefaultStateCar>  car){
        car.getLocation().getNextPoint(0).forEach(System.out::println);
    }

    @Test
    public void testGetLastCheckPoint() {
    }

    @Test
    public void testGetPath() {
    }

    @Test
    public void testHitsWall() {
    }

}