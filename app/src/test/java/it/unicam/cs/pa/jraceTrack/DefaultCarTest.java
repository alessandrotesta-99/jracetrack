package it.unicam.cs.pa.jraceTrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


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


  /*      Point2D w1 = new Point2D(1,1);
        Point2D w2 = new Point2D(1,5);
        Point2D w3 = new Point2D(20,5);
        Point2D w4 = new Point2D(20,1);*/


        Point2D p1 = new Point2D(16,5);
        Point2D p2 = new Point2D(20,5);

        Point2D p3 = new Point2D(1,5);
        Point2D p4 = new Point2D(5,5);

        List<Point2D> start = new ArrayList<>();
        start.add(p1);
        start.add(p2);
        List<Point2D> finish = new ArrayList<>();
        finish.add(p3);
        finish.add(p4);

        Track<Point2D, DefaultStateCar> tr = new DefaultTrack2D<>(start,finish,w1,w2,w3,w4,w5,w6,w7,w8);
        Car<Point2D, DefaultStateCar> car1 = new DefaultCar<>(tr, null);
        tr.addCar(car1);

        this.printNextPoint(car1);
        //prima mossa.
        Point2D next = new Point2D(17,6);
        car1.moveUp(next);

        this.printNextPoint(car1);
        Point2D next1 = new Point2D(18,8);
        car1.moveUp(next1);

        this.printNextPoint(car1);
        Point2D next2 = new Point2D(17,11);
        car1.moveUp(next2);

        this.printNextPoint(car1);
        Point2D next3 = new Point2D(15,14);
        car1.moveUp(next3);
        this.printNextPoint(car1);
    }

    @Test
    public void testmoveUpHorizontal(){
        Point2D w1 = new Point2D(1,1);
        Point2D w2 = new Point2D(1,16);
        Point2D w3 = new Point2D(20,1);
        Point2D w4 = new Point2D(20,16);

        Point2D w5 = new Point2D(5,5);
        Point2D w6 = new Point2D(5,12);
        Point2D w7 = new Point2D(16,5);
        Point2D w8 = new Point2D(16,12);


  /*      Point2D w1 = new Point2D(1,1);
        Point2D w2 = new Point2D(1,5);
        Point2D w3 = new Point2D(20,5);
        Point2D w4 = new Point2D(20,1);*/


        Point2D p1 = new Point2D(1,1);
        Point2D p2 = new Point2D(5,1);

        Point2D p3 = new Point2D(16,5);
        Point2D p4 = new Point2D(20,5);

        List<Point2D> start = new ArrayList<>();
        start.add(p1);
        start.add(p2);
        List<Point2D> finish = new ArrayList<>();
        finish.add(p3);
        finish.add(p4);

        Track<Point2D, DefaultStateCar> tr = new DefaultTrack2D<>(start,finish,w1,w2,w3,w4,w5,w6,w7,w8);
        Car<Point2D, DefaultStateCar> car1 = new DefaultCar<>(tr, null);
        tr.addCar(car1);

        this.printNextPoint(car1);
        //prima mossa.
        Point2D next = new Point2D(2,2);
        car1.moveUp(next);

        this.printNextPoint(car1);
        Point2D next1 = new Point2D(2,4);
        car1.moveUp(next1);

        this.printNextPoint(car1);
        Point2D next2 = new Point2D(2,6);
        car1.moveUp(next2);

        this.printNextPoint(car1);
        Point2D next3 = new Point2D(2,9);
        car1.moveUp(next3);
        this.printNextPoint(car1);


        Point2D next4 = new Point2D(2,11);
        car1.moveUp(next4);
        this.printNextPoint(car1);

        Point2D next5 = new Point2D(2,12);
        car1.moveUp(next5);
        this.printNextPoint(car1);

        Point2D next6 = new Point2D(4,14);
        car1.moveUp(next6);
        this.printNextPoint(car1);

        Point2D next7 = new Point2D(7,15);
        car1.moveUp(next7);
        this.printNextPoint(car1);

        Point2D next8 = new Point2D(11,14);
        car1.moveUp(next8);
        this.printNextPoint(car1);

        Point2D next9 = new Point2D(14,14);
        car1.moveUp(next9);
        this.printNextPoint(car1);

        Point2D next10 = new Point2D(17,12); //vettore 1
        car1.moveUp(next10);
        this.printNextPoint(car1);

        Point2D next11 = new Point2D(19,10);
        car1.moveUp(next11);
        this.printNextPoint(car1);


        Point2D next12 = new Point2D(17,9);
        car1.moveUp(next12);
        this.printNextPoint(car1);


        Point2D next13 = new Point2D(17,7);
        car1.moveUp(next13);
        this.printNextPoint(car1);


      /*  Point2D next14 = new Point2D(17,10);
        car1.moveUp(next14);
        this.printNextPoint(car1);*/

      /*  Point2D next6 = new Point2D(3,13);
        car1.moveUp(next6);
        this.printNextPoint(car1);*/
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