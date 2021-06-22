package it.unicam.cs.pa.jraceTrack;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DefaultCarTest{

    @Test
    public void testMoveUp() {
        TrackLocation2D w1 = new TrackLocation2D(1,1);
        TrackLocation2D w2 = new TrackLocation2D(1,16);
        TrackLocation2D w3 = new TrackLocation2D(20,1);
        TrackLocation2D w4 = new TrackLocation2D(20,16);

        TrackLocation2D w5 = new TrackLocation2D(5,5);
        TrackLocation2D w6 = new TrackLocation2D(5,12);
        TrackLocation2D w7 = new TrackLocation2D(16,5);
        TrackLocation2D w8 = new TrackLocation2D(16,12);


  /*      Point2D w1 = new Point2D(1,1);
        Point2D w2 = new Point2D(1,5);
        Point2D w3 = new Point2D(20,5);
        Point2D w4 = new Point2D(20,1);*/


        TrackLocation2D p1 = new TrackLocation2D(16,5);
        TrackLocation2D p2 = new TrackLocation2D(20,5);

        TrackLocation2D p3 = new TrackLocation2D(1,5);
        TrackLocation2D p4 = new TrackLocation2D(5,5);

        List<TrackLocation2D> start = new ArrayList<>();
        start.add(p1);
        start.add(p2);
        List<TrackLocation2D> finish = new ArrayList<>();
        finish.add(p3);
        finish.add(p4);

        Track<TrackLocation2D> tr = new DefaultTrack2D<>(start,finish,w1,w2,w3,w4,w5,w6,w7,w8);
        Car<TrackLocation2D> car1 = new DefaultCar<>(tr, null);
        tr.addCar(car1);

        this.printNextPoint(car1);
        //prima mossa.
        TrackLocation2D next = new TrackLocation2D(17,6);
        car1.moveUp(next);

        this.printNextPoint(car1);
        TrackLocation2D next1 = new TrackLocation2D(18,8);
        car1.moveUp(next1);

        this.printNextPoint(car1);
        TrackLocation2D next2 = new TrackLocation2D(17,11);
        car1.moveUp(next2);

        this.printNextPoint(car1);
        TrackLocation2D next3 = new TrackLocation2D(15,14);
        car1.moveUp(next3);
        this.printNextPoint(car1);
    }

    @Test
    public void testmoveUpHorizontal(){
        TrackLocation2D w1 = new TrackLocation2D(1,1);
        TrackLocation2D w2 = new TrackLocation2D(1,16);
        TrackLocation2D w3 = new TrackLocation2D(20,1);
        TrackLocation2D w4 = new TrackLocation2D(20,16);

        TrackLocation2D w5 = new TrackLocation2D(5,5);
        TrackLocation2D w6 = new TrackLocation2D(5,12);
        TrackLocation2D w7 = new TrackLocation2D(16,5);
        TrackLocation2D w8 = new TrackLocation2D(16,12);




        TrackLocation2D p1 = new TrackLocation2D(13,1);
        TrackLocation2D p2 = new TrackLocation2D(13,5);

        TrackLocation2D p3 = new TrackLocation2D(1,5);
        TrackLocation2D p4 = new TrackLocation2D(5,5);

        List<TrackLocation2D> start = new ArrayList<>();
        start.add(p1);
        start.add(p2);
        List<TrackLocation2D> finish = new ArrayList<>();
        finish.add(p3);
        finish.add(p4);

        Track<TrackLocation2D> tr = new DefaultTrack2D<>(start,finish,w1,w2,w3,w4,w5,w6,w7,w8);
        Car<TrackLocation2D> car1 = new DefaultCar<>(tr, null);
        tr.addCar(car1);

        this.printNextPoint(car1);
        //prima mossa.
        TrackLocation2D next = new TrackLocation2D(14,2);
        car1.moveUp(next);
        assertEquals(1,car1.getVector().getX());
        assertEquals(1, tr.getCars().stream().filter(c -> car1.getLocation().equals(c.getLocation())).collect(Collectors.toSet()).size());
       // assertTrue();


        this.printNextPoint(car1);
        TrackLocation2D next1 = new TrackLocation2D(16,4);
        car1.moveUp(next1);
        assertEquals(3,car1.getVector().getX());

        this.printNextPoint(car1);
        TrackLocation2D next2 = new TrackLocation2D(17,6);
        car1.moveUp(next2);
        assertEquals(1,car1.getVector().getX());

        this.printNextPoint(car1);
        TrackLocation2D next3 = new TrackLocation2D(17,9);
        car1.moveUp(next3);
        this.printNextPoint(car1);
        assertEquals(1,car1.getVector().getX());


        TrackLocation2D next4 = new TrackLocation2D(17,11);
        car1.moveUp(next4);
        this.printNextPoint(car1);
        assertEquals(1,car1.getVector().getX());

        TrackLocation2D next5 = new TrackLocation2D(16,13);
        car1.moveUp(next5);
        this.printNextPoint(car1);
        assertEquals(2,car1.getVector().getX());

        TrackLocation2D next6 = new TrackLocation2D(15,14);
        car1.moveUp(next6);
        this.printNextPoint(car1);
        assertEquals(3,car1.getVector().getX());

        TrackLocation2D next7 = new TrackLocation2D(13,14);
        car1.moveUp(next7);
        this.printNextPoint(car1);
        assertEquals(1,car1.getVector().getX());

        TrackLocation2D next8 = new TrackLocation2D(11,13);
        car1.moveUp(next8);
        this.printNextPoint(car1);
        assertEquals(2,car1.getVector().getX());

        TrackLocation2D next9 = new TrackLocation2D(8,13);
        car1.moveUp(next9);
        this.printNextPoint(car1);
        assertEquals(2,car1.getVector().getX());

        TrackLocation2D next10 = new TrackLocation2D(6,13); //vettore 1
        car1.moveUp(next10);
        this.printNextPoint(car1);
        assertEquals(2,car1.getVector().getX());

        TrackLocation2D next11 = new TrackLocation2D(4,12);
        car1.moveUp(next11);
        this.printNextPoint(car1);
        assertEquals(3,car1.getVector().getX());


        TrackLocation2D next12 = new TrackLocation2D(3,11);
        car1.moveUp(next12);
        this.printNextPoint(car1);
        assertEquals(2,car1.getVector().getX());

        TrackLocation2D next13 = new TrackLocation2D(2,9);
        car1.moveUp(next13);
        this.printNextPoint(car1);
        assertEquals(2,car1.getVector().getX());

        TrackLocation2D next14 = new TrackLocation2D(3,7);
        car1.moveUp(next14);
        this.printNextPoint(car1);
        assertEquals(3,car1.getVector().getX());

        TrackLocation2D next15 = new TrackLocation2D(2,6);
        car1.moveUp(next15);
        this.printNextPoint(car1);
        assertEquals(2,car1.getVector().getX());

        TrackLocation2D next16 = new TrackLocation2D(2,5);
        car1.moveUp(next16);
        this.printNextPoint(car1);
        assertEquals(2,car1.getVector().getX());

      /*  Point2D next14 = new Point2D(17,10);
        car1.moveUp(next14);
        this.printNextPoint(car1);*/

      /*  Point2D next6 = new Point2D(3,13);
        car1.moveUp(next6);
        this.printNextPoint(car1);*/

//
//        this.printNextPoint(car1);
//        //prima mossa.
//        Point2D next = new Point2D(2,2);
//        car1.moveUp(next);
//        assertEquals(1,car1.getVector().getX());
//
//        this.printNextPoint(car1);
//        Point2D next1 = new Point2D(2,4);
//        car1.moveUp(next1);
//        assertEquals(1,car1.getVector().getX());
//
//        this.printNextPoint(car1);
//        Point2D next2 = new Point2D(2,6);
//        car1.moveUp(next2);
//        assertEquals(1,car1.getVector().getX());
//
//        this.printNextPoint(car1);
//        Point2D next3 = new Point2D(2,9);
//        car1.moveUp(next3);
//        this.printNextPoint(car1);
//        assertEquals(1,car1.getVector().getX());
//
//
//        Point2D next4 = new Point2D(2,11);
//        car1.moveUp(next4);
//        this.printNextPoint(car1);
//        assertEquals(1,car1.getVector().getX());
//
//        Point2D next5 = new Point2D(2,12);
//        car1.moveUp(next5);
//        this.printNextPoint(car1);
//        assertEquals(1,car1.getVector().getX());
//
//        Point2D next6 = new Point2D(4,14);
//        car1.moveUp(next6);
//        this.printNextPoint(car1);
//        assertEquals(3,car1.getVector().getX());
//
//        Point2D next7 = new Point2D(7,15);
//        car1.moveUp(next7);
//        this.printNextPoint(car1);
//        assertEquals(2,car1.getVector().getX());
//
//        Point2D next8 = new Point2D(9,14);
//        car1.moveUp(next8);
//        this.printNextPoint(car1);
//        assertEquals(1,car1.getVector().getX());
//
//        Point2D next9 = new Point2D(12,13);
//        car1.moveUp(next9);
//        this.printNextPoint(car1);
//        assertEquals(2,car1.getVector().getX());
//
//        Point2D next10 = new Point2D(14,13); //vettore 1
//        car1.moveUp(next10);
//        this.printNextPoint(car1);
//        assertEquals(2,car1.getVector().getX());
//
//        Point2D next11 = new Point2D(17,13);
//        car1.moveUp(next11);
//        this.printNextPoint(car1);



    }

    private void printNextPoint(Car<TrackLocation2D>  car){
        car.getLocation().getNextLocations(car).forEach(System.out::println);
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