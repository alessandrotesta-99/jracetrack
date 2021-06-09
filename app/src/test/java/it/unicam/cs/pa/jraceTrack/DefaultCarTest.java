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
        Point2D w1 = new Point2D(1,1);
        Point2D w2 = new Point2D(1,16);
        Point2D w3 = new Point2D(20,1);
        Point2D w4 = new Point2D(20,16);

        Point2D w5 = new Point2D(5,5);
        Point2D w6 = new Point2D(5,12);
        Point2D w7 = new Point2D(16,5);
        Point2D w8 = new Point2D(16,12);

        Point2D p1 = new Point2D(16,6);
        Point2D p2 = new Point2D(20,6);

        Point2D p3 = new Point2D(1,11);
        Point2D p4 = new Point2D(5,11);

        List<Point2D> start = new ArrayList<>();
        start.add(p1);
        start.add(p2);
        List<Point2D> finish = new ArrayList<>();
        finish.add(p3);
        finish.add(p4);

        Track<Point2D, DefaultStateCar> tr = new DefaultTrack2D<>(start,finish,w1,w2,w3,w4,w5,w6,w7,w8);
        Car<Point2D, DefaultStateCar> car1 = new DefaultCar<>(tr, null);
        tr.addCar(car1);
        //TODO non va bene che gia inzia e tocca sul muro del circuito.
        this.printNextPoint(car1);
        //prima mossa.
        Point2D next = new Point2D(4,10);
        car1.moveUp(next);

        this.printNextPoint(car1);
        Point2D next1 = new Point2D(5,5);
        car1.moveUp(next1);

        this.printNextPoint(car1);
        Point2D next2 = new Point2D(10,9);
        car1.moveUp(next2);
        this.printNextPoint(car1);
    }

    private void printNextPoint(Car<Point2D, DefaultStateCar>  car){
        car.getLocation().getNextPoint(car,2).forEach(System.out::println);
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