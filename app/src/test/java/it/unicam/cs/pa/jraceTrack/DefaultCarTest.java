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

        TrackLocation2D p3 = new TrackLocation2D(13,1);
        TrackLocation2D p4 = new TrackLocation2D(13,5);

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
        assertEquals(1, car1.getVector().getY());
        assertSame(car1.getTrack().getCarAt(car1.getLocation()), car1);


        this.printNextPoint(car1);
        TrackLocation2D next1 = new TrackLocation2D(16,3);
        car1.moveUp(next1);
    //    assertEquals(3,car1.getVector().getX());
    //    assertEquals(2, car1.getVector().getY());
  //      assertSame(car1.getTrack().getCarAt(car1.getLocation()), car1);
    //    assertSame(car1.getTrack().getCarAt(car1.getLastCheckPoint()), null);

        this.printNextPoint(car1);
        TrackLocation2D next2 = new TrackLocation2D(18,4);
        car1.moveUp(next2);
    //    assertEquals(2,car1.getVector().getX());
    //    assertEquals(2, car1.getVector().getY());
    //    assertSame(car1.getTrack().getCarAt(car1.getLocation()), car1);
   //     assertSame(car1.getTrack().getCarAt(car1.getLastCheckPoint()), null);

        this.printNextPoint(car1);
        TrackLocation2D next3 = new TrackLocation2D(19,5);
        car1.moveUp(next3);
        assertEquals(1,car1.getVector().getX());
        assertEquals(1, car1.getVector().getY());
        assertSame(car1.getTrack().getCarAt(car1.getLocation()), car1);
        assertSame(car1.getTrack().getCarAt(car1.getLastCheckPoint()), null);

        this.printNextPoint(car1);
        TrackLocation2D next4 = new TrackLocation2D(19,7);
        car1.moveUp(next4);
        assertEquals(1,car1.getVector().getX());
        assertEquals(2, car1.getVector().getY());
        assertSame(car1.getTrack().getCarAt(car1.getLocation()), car1);
        assertSame(car1.getTrack().getCarAt(car1.getLastCheckPoint()), null);

        this.printNextPoint(car1);
        TrackLocation2D next5 = new TrackLocation2D(18,9);
        car1.moveUp(next5);
        assertEquals(2,car1.getVector().getX());
        assertEquals(2, car1.getVector().getY());
        assertSame(car1.getTrack().getCarAt(car1.getLocation()), car1);
        assertSame(car1.getTrack().getCarAt(car1.getLastCheckPoint()), null);

        this.printNextPoint(car1);
        TrackLocation2D next6 = new TrackLocation2D(18,11);
        car1.moveUp(next6);
        assertEquals(2,car1.getVector().getX());
        assertEquals(2, car1.getVector().getY());
        assertSame(car1.getTrack().getCarAt(car1.getLocation()), car1);
        assertSame(car1.getTrack().getCarAt(car1.getLastCheckPoint()), null);

        this.printNextPoint(car1);
        TrackLocation2D next7 = new TrackLocation2D(17,13);
        car1.moveUp(next7);
        assertEquals(1,car1.getVector().getX());
        assertEquals(2, car1.getVector().getY());
        assertSame(car1.getTrack().getCarAt(car1.getLocation()), car1);
        assertSame(car1.getTrack().getCarAt(car1.getLastCheckPoint()), null);

        this.printNextPoint(car1);
        TrackLocation2D next8 = new TrackLocation2D(17,14);
        car1.moveUp(next8);
        assertEquals(3,car1.getVector().getX());
        assertEquals(1, car1.getVector().getY());
        assertSame(car1.getTrack().getCarAt(car1.getLocation()), car1);
        assertSame(car1.getTrack().getCarAt(car1.getLastCheckPoint()), null);

        this.printNextPoint(car1);
        TrackLocation2D next9 = new TrackLocation2D(15,14);
        car1.moveUp(next9);
        assertEquals(1,car1.getVector().getX());
        assertEquals(2, car1.getVector().getY());
        assertSame(car1.getTrack().getCarAt(car1.getLocation()), car1);
        assertSame(car1.getTrack().getCarAt(car1.getLastCheckPoint()), null);

        this.printNextPoint(car1);
        TrackLocation2D next10 = new TrackLocation2D(12,13);
        car1.moveUp(next10);
        assertEquals(2,car1.getVector().getX());
        assertEquals(3, car1.getVector().getY());
        assertSame(car1.getTrack().getCarAt(car1.getLocation()), car1);
        assertSame(car1.getTrack().getCarAt(car1.getLastCheckPoint()), null);

        this.printNextPoint(car1);
        TrackLocation2D next11 = new TrackLocation2D(8,13);
        car1.moveUp(next11);
        assertEquals(2,car1.getVector().getX());
        assertEquals(4,car1.getVector().getY());
        assertSame(car1.getTrack().getCarAt(car1.getLocation()), car1);
        assertSame(car1.getTrack().getCarAt(car1.getLastCheckPoint()), null);

        this.printNextPoint(car1);
        TrackLocation2D next12 = new TrackLocation2D(5,13);
        car1.moveUp(next12);
        assertEquals(2,car1.getVector().getX());
        assertEquals(3,car1.getVector().getY());
        assertSame(car1.getTrack().getCarAt(car1.getLocation()), car1);
        assertSame(car1.getTrack().getCarAt(car1.getLastCheckPoint()), null);

        this.printNextPoint(car1);
        TrackLocation2D next13 = new TrackLocation2D(3,12);
        car1.moveUp(next13);
        assertEquals(3,car1.getVector().getX());
        assertEquals(2,car1.getVector().getY());
        assertSame(car1.getTrack().getCarAt(car1.getLocation()), car1);
        assertSame(car1.getTrack().getCarAt(car1.getLastCheckPoint()), null);

        this.printNextPoint(car1);
        //TODO RIMANE DA TESTARE E FARE LA PARTE DOVE VA ALL'INCONTRARIO
        TrackLocation2D next14 = new TrackLocation2D(1,12);
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