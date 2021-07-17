package it.unicam.cs.pa.jraceTrack;

import it.unicam.cs.pa.jraceTrack.Model.*;
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
        List<TrackLocation2D> walls = new ArrayList<>();
        walls.add(new TrackLocation2D(1,1));
        walls.add(new TrackLocation2D(1,2));
        walls.add(new TrackLocation2D(6,5));
        walls.add(new TrackLocation2D(1,3));
        walls.add(new TrackLocation2D(1,4));
        walls.add(new TrackLocation2D(1,5));
        walls.add(new TrackLocation2D(1,6));
        walls.add(new TrackLocation2D(1,7));
        walls.add(new TrackLocation2D(1,8));
        walls.add(new TrackLocation2D(1,9));
        walls.add(new TrackLocation2D(1,10));
        walls.add(new TrackLocation2D(1,11));
        walls.add(new TrackLocation2D(1,12));
        walls.add(new TrackLocation2D(1,13));
        walls.add(new TrackLocation2D(1,14));
        walls.add(new TrackLocation2D(1,15));
        walls.add(new TrackLocation2D(1,16));
        walls.add(new TrackLocation2D(2,16));
        walls.add(new TrackLocation2D(3,16));
        walls.add(new TrackLocation2D(4,16));
        walls.add(new TrackLocation2D(5,16));
        walls.add(new TrackLocation2D(6,16));
        walls.add(new TrackLocation2D(7,16));
        walls.add(new TrackLocation2D(8,16));
        walls.add(new TrackLocation2D(9,16));
        walls.add(new TrackLocation2D(10,16));
        walls.add(new TrackLocation2D(11,16));
        walls.add(new TrackLocation2D(12,16));
        walls.add(new TrackLocation2D(13,16));
        walls.add(new TrackLocation2D(14,16));
        walls.add(new TrackLocation2D(15,16));
        walls.add(new TrackLocation2D(16,16));
        walls.add(new TrackLocation2D(17,16));
        walls.add(new TrackLocation2D(18,16));
        walls.add(new TrackLocation2D(19,16));
        walls.add(new TrackLocation2D(20,16));
        walls.add(new TrackLocation2D(20,15));
        walls.add(new TrackLocation2D(20,14));
        walls.add(new TrackLocation2D(20,13));
        walls.add(new TrackLocation2D(20,12));
        walls.add(new TrackLocation2D(20,11));
        walls.add(new TrackLocation2D(20,10));
        walls.add(new TrackLocation2D(20,9));
        walls.add(new TrackLocation2D(20,8));
        walls.add(new TrackLocation2D(20,7));
        walls.add(new TrackLocation2D(20,6));
        walls.add(new TrackLocation2D(20,5));
        walls.add(new TrackLocation2D(20,4));
        walls.add(new TrackLocation2D(20,3));
        walls.add(new TrackLocation2D(20,2));
        walls.add(new TrackLocation2D(20,1));
        walls.add(new TrackLocation2D(19,1));
        walls.add(new TrackLocation2D(18,1));
        walls.add(new TrackLocation2D(17,1));
        walls.add(new TrackLocation2D(16,1));
        walls.add(new TrackLocation2D(15,1));
        walls.add(new TrackLocation2D(14,1));
        walls.add(new TrackLocation2D(13,1));
        walls.add(new TrackLocation2D(12,1));
        walls.add(new TrackLocation2D(11,1));
        walls.add(new TrackLocation2D(10,1));
        walls.add(new TrackLocation2D(9,1));
        walls.add(new TrackLocation2D(8,1));
        walls.add(new TrackLocation2D(7,1));
        walls.add(new TrackLocation2D(6,1));
        walls.add(new TrackLocation2D(5,1));
        walls.add(new TrackLocation2D(4,1));
        walls.add(new TrackLocation2D(3,1));
        walls.add(new TrackLocation2D(2,1));
        walls.add(new TrackLocation2D(5,5));
        walls.add(new TrackLocation2D(5,6));
        walls.add(new TrackLocation2D(5,7));
        walls.add(new TrackLocation2D(5,8));
        walls.add(new TrackLocation2D(5,9));
        walls.add(new TrackLocation2D(5,10));
        walls.add(new TrackLocation2D(5,11));
        walls.add(new TrackLocation2D(5,12));
        walls.add(new TrackLocation2D(6,12));
        walls.add(new TrackLocation2D(7,12));
        walls.add(new TrackLocation2D(8,12));
        walls.add(new TrackLocation2D(9,12));
        walls.add(new TrackLocation2D(10,12));
        walls.add(new TrackLocation2D(11,12));
        walls.add(new TrackLocation2D(12,12));
        walls.add(new TrackLocation2D(13,12));
        walls.add(new TrackLocation2D(14,12));
        walls.add(new TrackLocation2D(15,12));
        walls.add(new TrackLocation2D(16,11));
        walls.add(new TrackLocation2D(16,10));
        walls.add(new TrackLocation2D(16,9));
        walls.add(new TrackLocation2D(16,8));
        walls.add(new TrackLocation2D(16,7));
        walls.add(new TrackLocation2D(16,6));
        walls.add(new TrackLocation2D(16,5));
        walls.add(new TrackLocation2D(15,5));
        walls.add(new TrackLocation2D(14,5));
        walls.add(new TrackLocation2D(13,5));
        walls.add(new TrackLocation2D(12,5));
        walls.add(new TrackLocation2D(11,5));
        walls.add(new TrackLocation2D(10,5));
        walls.add(new TrackLocation2D(9,5));
        walls.add(new TrackLocation2D(8,5));
        walls.add(new TrackLocation2D(7,5));

        List<TrackLocation2D> start = new ArrayList<>();
        start.add(new TrackLocation2D(1, 9));
        start.add(new TrackLocation2D(2, 9));
        start.add(new TrackLocation2D(3, 9));
        start.add(new TrackLocation2D(4, 9));
        start.add(new TrackLocation2D(5, 9));

        List<TrackLocation2D> finish = new ArrayList<>();
        finish.add(new TrackLocation2D(1, 8));
        finish.add(new TrackLocation2D(2, 8));
        finish.add(new TrackLocation2D(3, 8));
        finish.add(new TrackLocation2D(4, 8));
        finish.add(new TrackLocation2D(5, 8));

        Race<TrackLocation2D> r = new DefaultRace<>();
        r.createTrack(start, finish, walls);
        r.createPlayer(TypePlayer.BOT);
        r.getPlayers().get(0).getCar().setLocation(new TrackLocation2D(1,9)); //solo per test.
        return r.getPlayers().get(0).getCar();
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
        assertTrue(car.hitsWall());
    }
}