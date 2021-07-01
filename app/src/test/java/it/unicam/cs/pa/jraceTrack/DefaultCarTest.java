package it.unicam.cs.pa.jraceTrack;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


public class DefaultCarTest{

    @Test
    public void testMoveUp() {
        Car<TrackLocation2D> car1 = getCarWithDefaultTrack();

        this.printNextPoint(car1);
        //prima mossa.
        TrackLocation2D next = new TrackLocation2D(2,10);
        car1.moveUp(next);

        this.printNextPoint(car1);
        TrackLocation2D next1 = new TrackLocation2D(3,12);
        car1.moveUp(next1);

        this.printNextPoint(car1);
        TrackLocation2D next2 = new TrackLocation2D(4,13);
        car1.moveUp(next2);

        this.printNextPoint(car1);
        TrackLocation2D next3 = new TrackLocation2D(5,13);
        car1.moveUp(next3);

        this.printNextPoint(car1);
        TrackLocation2D next4 = new TrackLocation2D(7,14);
        car1.moveUp(next4);


        this.printNextPoint(car1);
        TrackLocation2D next5 = new TrackLocation2D(8,15);
        car1.moveUp(next5);


        this.printNextPoint(car1);
        TrackLocation2D next6 = new TrackLocation2D(9,15);
        car1.moveUp(next6);


        this.printNextPoint(car1);
        TrackLocation2D next7 = new TrackLocation2D(11,15);
        car1.moveUp(next7);

        this.printNextPoint(car1);
        TrackLocation2D next8 = new TrackLocation2D(14,15);
        car1.moveUp(next8);

        this.printNextPoint(car1);
        TrackLocation2D next9 = new TrackLocation2D(17,14);
        car1.moveUp(next9);

        this.printNextPoint(car1);
        TrackLocation2D next10 = new TrackLocation2D(18,12);
        car1.moveUp(next10);

        this.printNextPoint(car1);
        TrackLocation2D next11 = new TrackLocation2D(18,9);
        car1.moveUp(next11);

        this.printNextPoint(car1);
        TrackLocation2D next12 = new TrackLocation2D(17,7);
        car1.moveUp(next12);

        this.printNextPoint(car1);
        TrackLocation2D next13 = new TrackLocation2D(17,5);
        car1.moveUp(next13);

        this.printNextPoint(car1);
        TrackLocation2D next14 = new TrackLocation2D(16,4);
        car1.moveUp(next14);

        this.printNextPoint(car1);
        TrackLocation2D next15 = new TrackLocation2D(15,4);
        car1.moveUp(next15);

        this.printNextPoint(car1);
        TrackLocation2D next16 = new TrackLocation2D(13,4);
        car1.moveUp(next16);

        this.printNextPoint(car1);
        TrackLocation2D next17 = new TrackLocation2D(10,4);
        car1.moveUp(next17);

        this.printNextPoint(car1);
        TrackLocation2D next18 = new TrackLocation2D(7,4);
        car1.moveUp(next18);

        this.printNextPoint(car1);
        TrackLocation2D next19 = new TrackLocation2D(4,5);
        car1.moveUp(next19);

        this.printNextPoint(car1);
        TrackLocation2D next20 = new TrackLocation2D(3,8);
        car1.moveUp(next20);

    }


    private void printNextPoint(Car<TrackLocation2D>  car){
        car.getLocation().getNextLocations(car).forEach(System.out::println);
        System.out.println("\n");
    }

    @Test
    public void testGetLastCheckPoint() {
        Car<TrackLocation2D> car = getCarWithDefaultTrack();
        TrackLocation2D next = new TrackLocation2D(2,10);
        car.moveUp(next);
        TrackLocation2D next1 = new TrackLocation2D(3,12);
        car.moveUp(next1);
        TrackLocation2D next2 = new TrackLocation2D(4,13);
        car.moveUp(next2);
        TrackLocation2D next3 = new TrackLocation2D(5,13);
        car.moveUp(next3);
        assertEquals(next2, car.getLastCheckPoint());
    }

    @Test
    public void testGetPath() {
        Car<TrackLocation2D> car = getCarWithDefaultTrack();
        TrackLocation2D next = new TrackLocation2D(2,10);
        car.moveUp(next);
        TrackLocation2D next1 = new TrackLocation2D(3,12);
        car.moveUp(next1);
        TrackLocation2D next2 = new TrackLocation2D(4,13);
        car.moveUp(next2);
        TrackLocation2D next3 = new TrackLocation2D(5,13);
        car.moveUp(next3);
        assertEquals(5, car.getPath().size());
    }

    private Car<TrackLocation2D> getCarWithDefaultTrack() {
        TrackLocation2D w1 = new TrackLocation2D(1, 1);
        TrackLocation2D w2 = new TrackLocation2D(1, 16);
        TrackLocation2D w3 = new TrackLocation2D(20, 1);
        TrackLocation2D w4 = new TrackLocation2D(20, 16);

        TrackLocation2D w5 = new TrackLocation2D(5, 5);
        TrackLocation2D w6 = new TrackLocation2D(5, 12);
        TrackLocation2D w7 = new TrackLocation2D(16, 5);
        TrackLocation2D w8 = new TrackLocation2D(16, 12);

        TrackLocation2D p1 = new TrackLocation2D(1, 9);
        TrackLocation2D p2 = new TrackLocation2D(5, 9);
        TrackLocation2D p3 = new TrackLocation2D(1, 8);
        TrackLocation2D p4 = new TrackLocation2D(5, 8);

        TrackLocation2D p5 = new TrackLocation2D(1, 9);
        TrackLocation2D p6 = new TrackLocation2D(5, 9);
        TrackLocation2D p7 = new TrackLocation2D(1, 8);
        TrackLocation2D p8 = new TrackLocation2D(5, 8);

        List<TrackLocation2D> start = new ArrayList<>();
        start.add(p1);
        start.add(p2);
        start.add(p3);
        start.add(p4);
        List<TrackLocation2D> finish = new ArrayList<>();
        finish.add(p5);
        finish.add(p6);
        finish.add(p7);
        finish.add(p8);

        Track<TrackLocation2D> tr = new DefaultTrack2D<>(start, finish, w1, w2, w3, w4, w5, w6, w7, w8);
        return new DefaultCar<>(tr, null);
    }

    @Test
    public void testHitsWall() {
        Car<TrackLocation2D> car = getCarWithDefaultTrack();

        TrackLocation2D next = new TrackLocation2D(2,10);
        car.moveUp(next);
        TrackLocation2D next1 = new TrackLocation2D(3,12);
        car.moveUp(next1);
        TrackLocation2D next2 = new TrackLocation2D(4,13);
        car.moveUp(next2);
        TrackLocation2D next3 = new TrackLocation2D(5,13);
        car.moveUp(next3);
        TrackLocation2D next4 = new TrackLocation2D(7,14);
        car.moveUp(next4);
        //muro
        TrackLocation2D next5 = new TrackLocation2D(8,16);
        car.moveUp(next5);
        //todo non porta al momento perche bisognerebbe aggiungere i punti al circuito.
        assertTrue(car.hitsWall());
    }

}