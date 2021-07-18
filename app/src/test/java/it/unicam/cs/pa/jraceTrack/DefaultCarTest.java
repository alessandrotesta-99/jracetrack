package it.unicam.cs.pa.jraceTrack;

import it.unicam.cs.pa.jraceTrack.Model.*;
import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


public class DefaultCarTest{

    @Test
    public void testMoveUp() {
        Car<DefaultLocation> car1 = getCarWithDefaultTrack();

        this.printNextPoint(car1);
        //prima mossa.
        DefaultLocation next = new DefaultLocation(2,10);
        car1.moveUp(next);

        this.printNextPoint(car1);
        DefaultLocation next1 = new DefaultLocation(3,12);
        car1.moveUp(next1);

        this.printNextPoint(car1);
        DefaultLocation next2 = new DefaultLocation(4,13);
        car1.moveUp(next2);

        this.printNextPoint(car1);
        DefaultLocation next3 = new DefaultLocation(5,13);
        car1.moveUp(next3);

        this.printNextPoint(car1);
        DefaultLocation next4 = new DefaultLocation(7,14);
        car1.moveUp(next4);


        this.printNextPoint(car1);
        DefaultLocation next5 = new DefaultLocation(8,15);
        car1.moveUp(next5);


        this.printNextPoint(car1);
        DefaultLocation next6 = new DefaultLocation(9,15);
        car1.moveUp(next6);


        this.printNextPoint(car1);
        DefaultLocation next7 = new DefaultLocation(11,15);
        car1.moveUp(next7);

        this.printNextPoint(car1);
        DefaultLocation next8 = new DefaultLocation(14,15);
        car1.moveUp(next8);

        this.printNextPoint(car1);
        DefaultLocation next9 = new DefaultLocation(17,14);
        car1.moveUp(next9);

        this.printNextPoint(car1);
        DefaultLocation next10 = new DefaultLocation(18,12);
        car1.moveUp(next10);

        this.printNextPoint(car1);
        DefaultLocation next11 = new DefaultLocation(18,9);
        car1.moveUp(next11);

        this.printNextPoint(car1);
        DefaultLocation next12 = new DefaultLocation(17,7);
        car1.moveUp(next12);

        this.printNextPoint(car1);
        DefaultLocation next13 = new DefaultLocation(17,5);
        car1.moveUp(next13);

        this.printNextPoint(car1);
        DefaultLocation next14 = new DefaultLocation(16,4);
        car1.moveUp(next14);

        this.printNextPoint(car1);
        DefaultLocation next15 = new DefaultLocation(15,4);
        car1.moveUp(next15);

        this.printNextPoint(car1);
        DefaultLocation next16 = new DefaultLocation(13,4);
        car1.moveUp(next16);

        this.printNextPoint(car1);
        DefaultLocation next17 = new DefaultLocation(10,4);
        car1.moveUp(next17);

        this.printNextPoint(car1);
        DefaultLocation next18 = new DefaultLocation(7,4);
        car1.moveUp(next18);

        this.printNextPoint(car1);
        DefaultLocation next19 = new DefaultLocation(4,5);
        car1.moveUp(next19);

        this.printNextPoint(car1);
        DefaultLocation next20 = new DefaultLocation(3,8);
        car1.moveUp(next20);

    }


    private void printNextPoint(Car<DefaultLocation>  car){
        car.getLocation().getNextLocations(car).forEach(System.out::println);
        System.out.println("\n");
    }

    @Test
    public void testGetLastCheckPoint() {
        Car<DefaultLocation> car = getCarWithDefaultTrack();
        DefaultLocation next = new DefaultLocation(2,10);
        car.moveUp(next);
        DefaultLocation next1 = new DefaultLocation(3,12);
        car.moveUp(next1);
        DefaultLocation next2 = new DefaultLocation(4,13);
        car.moveUp(next2);
        DefaultLocation next3 = new DefaultLocation(5,13);
        car.moveUp(next3);
        assertEquals(next2, car.getLastCheckPoint());
    }

    @Test
    public void testGetPath() {
        Car<DefaultLocation> car = getCarWithDefaultTrack();
        DefaultLocation next = new DefaultLocation(2,10);
        car.moveUp(next);
        DefaultLocation next1 = new DefaultLocation(3,12);
        car.moveUp(next1);
        DefaultLocation next2 = new DefaultLocation(4,13);
        car.moveUp(next2);
        DefaultLocation next3 = new DefaultLocation(5,13);
        car.moveUp(next3);
        assertEquals(5, car.getPath().size());
    }

    private Car<DefaultLocation> getCarWithDefaultTrack() {
        List<DefaultLocation> walls = new ArrayList<>();
        walls.add(new DefaultLocation(1,1));
        walls.add(new DefaultLocation(1,2));
        walls.add(new DefaultLocation(6,5));
        walls.add(new DefaultLocation(1,3));
        walls.add(new DefaultLocation(1,4));
        walls.add(new DefaultLocation(1,5));
        walls.add(new DefaultLocation(1,6));
        walls.add(new DefaultLocation(1,7));
        walls.add(new DefaultLocation(1,8));
        walls.add(new DefaultLocation(1,9));
        walls.add(new DefaultLocation(1,10));
        walls.add(new DefaultLocation(1,11));
        walls.add(new DefaultLocation(1,12));
        walls.add(new DefaultLocation(1,13));
        walls.add(new DefaultLocation(1,14));
        walls.add(new DefaultLocation(1,15));
        walls.add(new DefaultLocation(1,16));
        walls.add(new DefaultLocation(2,16));
        walls.add(new DefaultLocation(3,16));
        walls.add(new DefaultLocation(4,16));
        walls.add(new DefaultLocation(5,16));
        walls.add(new DefaultLocation(6,16));
        walls.add(new DefaultLocation(7,16));
        walls.add(new DefaultLocation(8,16));
        walls.add(new DefaultLocation(9,16));
        walls.add(new DefaultLocation(10,16));
        walls.add(new DefaultLocation(11,16));
        walls.add(new DefaultLocation(12,16));
        walls.add(new DefaultLocation(13,16));
        walls.add(new DefaultLocation(14,16));
        walls.add(new DefaultLocation(15,16));
        walls.add(new DefaultLocation(16,16));
        walls.add(new DefaultLocation(17,16));
        walls.add(new DefaultLocation(18,16));
        walls.add(new DefaultLocation(19,16));
        walls.add(new DefaultLocation(20,16));
        walls.add(new DefaultLocation(20,15));
        walls.add(new DefaultLocation(20,14));
        walls.add(new DefaultLocation(20,13));
        walls.add(new DefaultLocation(20,12));
        walls.add(new DefaultLocation(20,11));
        walls.add(new DefaultLocation(20,10));
        walls.add(new DefaultLocation(20,9));
        walls.add(new DefaultLocation(20,8));
        walls.add(new DefaultLocation(20,7));
        walls.add(new DefaultLocation(20,6));
        walls.add(new DefaultLocation(20,5));
        walls.add(new DefaultLocation(20,4));
        walls.add(new DefaultLocation(20,3));
        walls.add(new DefaultLocation(20,2));
        walls.add(new DefaultLocation(20,1));
        walls.add(new DefaultLocation(19,1));
        walls.add(new DefaultLocation(18,1));
        walls.add(new DefaultLocation(17,1));
        walls.add(new DefaultLocation(16,1));
        walls.add(new DefaultLocation(15,1));
        walls.add(new DefaultLocation(14,1));
        walls.add(new DefaultLocation(13,1));
        walls.add(new DefaultLocation(12,1));
        walls.add(new DefaultLocation(11,1));
        walls.add(new DefaultLocation(10,1));
        walls.add(new DefaultLocation(9,1));
        walls.add(new DefaultLocation(8,1));
        walls.add(new DefaultLocation(7,1));
        walls.add(new DefaultLocation(6,1));
        walls.add(new DefaultLocation(5,1));
        walls.add(new DefaultLocation(4,1));
        walls.add(new DefaultLocation(3,1));
        walls.add(new DefaultLocation(2,1));
        walls.add(new DefaultLocation(5,5));
        walls.add(new DefaultLocation(5,6));
        walls.add(new DefaultLocation(5,7));
        walls.add(new DefaultLocation(5,8));
        walls.add(new DefaultLocation(5,9));
        walls.add(new DefaultLocation(5,10));
        walls.add(new DefaultLocation(5,11));
        walls.add(new DefaultLocation(5,12));
        walls.add(new DefaultLocation(6,12));
        walls.add(new DefaultLocation(7,12));
        walls.add(new DefaultLocation(8,12));
        walls.add(new DefaultLocation(9,12));
        walls.add(new DefaultLocation(10,12));
        walls.add(new DefaultLocation(11,12));
        walls.add(new DefaultLocation(12,12));
        walls.add(new DefaultLocation(13,12));
        walls.add(new DefaultLocation(14,12));
        walls.add(new DefaultLocation(15,12));
        walls.add(new DefaultLocation(16,11));
        walls.add(new DefaultLocation(16,10));
        walls.add(new DefaultLocation(16,9));
        walls.add(new DefaultLocation(16,8));
        walls.add(new DefaultLocation(16,7));
        walls.add(new DefaultLocation(16,6));
        walls.add(new DefaultLocation(16,5));
        walls.add(new DefaultLocation(15,5));
        walls.add(new DefaultLocation(14,5));
        walls.add(new DefaultLocation(13,5));
        walls.add(new DefaultLocation(12,5));
        walls.add(new DefaultLocation(11,5));
        walls.add(new DefaultLocation(10,5));
        walls.add(new DefaultLocation(9,5));
        walls.add(new DefaultLocation(8,5));
        walls.add(new DefaultLocation(7,5));

        List<DefaultLocation> start = new ArrayList<>();
        start.add(new DefaultLocation(1, 9));
        start.add(new DefaultLocation(2, 9));
        start.add(new DefaultLocation(3, 9));
        start.add(new DefaultLocation(4, 9));
        start.add(new DefaultLocation(5, 9));

        List<DefaultLocation> finish = new ArrayList<>();
        finish.add(new DefaultLocation(1, 8));
        finish.add(new DefaultLocation(2, 8));
        finish.add(new DefaultLocation(3, 8));
        finish.add(new DefaultLocation(4, 8));
        finish.add(new DefaultLocation(5, 8));

        Race<DefaultLocation> r = new DefaultRace();
        r.createTrack(start, finish, walls);
        r.createPlayer(TypePlayer.BOT);
        r.getPlayers().get(0).getCar().setLocation(new DefaultLocation(1,9)); //solo per test.
        return r.getPlayers().get(0).getCar();
    }

    @Test
    public void testHitsWall() {
        Car<DefaultLocation> car = getCarWithDefaultTrack();

        DefaultLocation next = new DefaultLocation(2,10);
        car.moveUp(next);
        DefaultLocation next1 = new DefaultLocation(3,12);
        car.moveUp(next1);
        DefaultLocation next2 = new DefaultLocation(4,13);
        car.moveUp(next2);
        DefaultLocation next3 = new DefaultLocation(5,13);
        car.moveUp(next3);
        DefaultLocation next4 = new DefaultLocation(7,14);
        car.moveUp(next4);
        //muro
        DefaultLocation next5 = new DefaultLocation(8,16);
        car.moveUp(next5);
        assertTrue(car.hitsWall());
    }
}