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
        Point2D w1 = new Point2D(4,3);
        Point2D w2 = new Point2D(1,3);
        Point2D w3 = new Point2D(9,3);
        Point2D w4 = new Point2D(1,4);
        Point2D w5 = new Point2D(10,4);
        Point2D w6 = new Point2D(1,5);
        Point2D w7 = new Point2D(10,5);
        Point2D w8 = new Point2D(1,6);
        Point2D w9 = new Point2D(10,6);
        Point2D w10 = new Point2D(1,7);
        Point2D w11 = new Point2D(10,7);
        Point2D w12 = new Point2D(1,8);
        Point2D w13 = new Point2D(9,7);
        Point2D w14 = new Point2D(2,8);
        Point2D w15 = new Point2D(8,7);
        Point2D w16 = new Point2D(3,8);
        Point2D w17 = new Point2D(7,7);
        Point2D w18 = new Point2D(4,8);
        Point2D w19 = new Point2D(6,7);
        Point2D w20 = new Point2D(5,9);
        Point2D w21 = new Point2D(5,6);
        Point2D w22 = new Point2D(6,9);
        Point2D w23 = new Point2D(4,6);
        Point2D w24 = new Point2D(7,9);
        Point2D w25 = new Point2D(3,6);
        Point2D w26 = new Point2D(8,9);
        Point2D w27 = new Point2D(3,5);
        Point2D w28 = new Point2D(9,9);
        Point2D w29 = new Point2D(3,4);
        Point2D w30 = new Point2D(10,9);
        Point2D w31 = new Point2D(2,2);
        Point2D w32 = new Point2D(11,9);
        Point2D w33 = new Point2D(11,2);
        Point2D w34 = new Point2D(12,9);
        Point2D w35 = new Point2D(10,1);
        Point2D w36 = new Point2D(12,8);
        Point2D w37 = new Point2D(12,3);
        Point2D w38 = new Point2D(12,4);
        Point2D w39 = new Point2D(12,5);
        Point2D w40 = new Point2D(12,6);
        Point2D w41 = new Point2D(12,7);
        Point2D w42 = new Point2D(3,1);





        Point2D p1 = new Point2D(4,3);
        Point2D p2 = new Point2D(4,1);
        Point2D p3 = new Point2D(4,3);
        Point2D p4 = new Point2D(4,1);
        ArrayList<Point2D> partenza = new ArrayList<>();
        partenza.add(p1);
        partenza.add(p2);
        List<Point2D> arrivo = new ArrayList<>();
        arrivo.add(p3);
        arrivo.add(p4);
        //TODO aggiungere controllo: al punto di partenza la macchina deve stare in linea con i punti di partenza.
        Point2D l = new Point2D(4,3);
        DefaultTrack2D<Point2D, DefaultStateCar> tr = new DefaultTrack2D<>(2,20, partenza, arrivo,
                w1,w2,w3,w4,w5,w6,w7,w8,w9,w10,w11,w12,w13,w14,w15,w16,w17,w18,w19,w20,w21,w22,w23,w24,w25,w26,
                w27,w28,w29,w30,w31,w32,w33,w34,w35,w36,w37,w38,w39,w40,w41,w42);
        Car<Point2D, DefaultStateCar> car1 = new DefaultCar<>(tr, null);
        tr.addCar(car1);
        //controllo ulteriore
        assertNotNull(tr.getCarAt(l));
        //TODO non va bene che gia inzia e tocca sul muro del circuito.
        this.printNextPoint(car1);
        //prima mossa.
        Point2D next = new Point2D(5,4);
        car1.moveUp(next);

        this.printNextPoint(car1);
        Point2D next1 = new Point2D(7,6);
        car1.moveUp(next1);

        this.printNextPoint(car1);
        Point2D next2 = new Point2D(10,9);
        car1.moveUp(next2);
        this.printNextPoint(car1);

        //controlli ulteriori
        assertSame(car1.getLocation(), next);
        assertNotNull(tr.getCarAt(next));
        assertNull(tr.getCarAt(l));

        this.printNextPoint(car1);
    }

    private void printNextPoint(Car<Point2D, DefaultStateCar>  car){
        car.getLocation().getNextPoint(car,0).forEach(System.out::println);
        System.out.println("\n");
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