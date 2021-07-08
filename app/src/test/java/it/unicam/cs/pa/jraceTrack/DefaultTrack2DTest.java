package it.unicam.cs.pa.jraceTrack;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DefaultTrack2DTest{

    @Test
    public void testGetCarAt() {
        //crea tracciato
        Track<TrackLocation2D> tr = getDefaultTrack();

        Car<TrackLocation2D> c = tr.createCar();
        c.setLocation(new TrackLocation2D(5,8)); //solo per test.
        tr.addCar(c);
        Car<TrackLocation2D> c1 = tr.createCar();
        c1.setLocation(new TrackLocation2D(5,6)); //solo per test.
        tr.addCar(c1);

        c.moveUp(new TrackLocation2D(4,9));
        c1.moveUp(new TrackLocation2D(4,7));

        assertNotSame(tr.getCarAt(new TrackLocation2D(5, 6)), c1);
        assertSame(tr.getCarAt(new TrackLocation2D(4, 7)), c1);
        assertNotSame(tr.getCarAt(new TrackLocation2D(5, 8)), c);
        assertSame(tr.getCarAt(new TrackLocation2D(4, 9)), c);
    }

    @Test
    public void testGetNextLocs() {
        Track<TrackLocation2D> tr = getDefaultTrack();
        Car<TrackLocation2D> c = tr.createCar();
        tr.addCar(c);
        System.out.println(tr.getNextLocs(c.getLocation()));
        Set<TrackLocation2D> nextPoints1 = Set.of(new TrackLocation2D(4,6),
                new TrackLocation2D(4,5),
                new TrackLocation2D(4,7),
                new TrackLocation2D(5,5),
                new TrackLocation2D(5,6),
                new TrackLocation2D(5,7),
                new TrackLocation2D(6,5),
                new TrackLocation2D(6,6),
                new TrackLocation2D(6,7));
        Set<TrackLocation2D> nextPoints2 = Set.of(new TrackLocation2D(4,7),
                new TrackLocation2D(4,8),
                new TrackLocation2D(4,9),
                new TrackLocation2D(5,7),
                new TrackLocation2D(5,8),
                new TrackLocation2D(5,9),
                new TrackLocation2D(6,7),
                new TrackLocation2D(6,8),
                new TrackLocation2D(6,9));
        if(c.getLocation().equals(new TrackLocation2D(5, 6)))
            assertTrue(tr.getNextLocs(c.getLocation()).containsAll(nextPoints1));
        else if(c.getLocation().equals(new TrackLocation2D(5,8)))
            assertTrue(tr.getNextLocs(c.getLocation()).containsAll(nextPoints2));
    }

    @Test
    public void testAddCar() {
         Track<TrackLocation2D> tr = getDefaultTrack();
         //crea gara
         Race<TrackLocation2D> race = new DefaultRace<>(tr,2, TypePlayer.BOT);

         assertSame(2, tr.getCars().size());
         assertSame(2, race.getPlayers().size());
         assertTrue(race.getPlayers().stream().allMatch(p -> p.getType().equals(TypePlayer.BOT)));
    }

    private Track<TrackLocation2D> getDefaultTrack() {
        TrackLocation2D w1 = new TrackLocation2D(1,1);
        TrackLocation2D w2 = new TrackLocation2D(1,8);
        TrackLocation2D w3 = new TrackLocation2D(10,1);
        TrackLocation2D w4 = new TrackLocation2D(10,8);
        TrackLocation2D w5 = new TrackLocation2D(3,3);
        TrackLocation2D w6 = new TrackLocation2D(3,6);
        TrackLocation2D w7 = new TrackLocation2D(8,3);
        TrackLocation2D w8 = new TrackLocation2D(8,6);
        List<TrackLocation2D> walls = new ArrayList<>();
        walls.add(w1);
        walls.add(w2);
        walls.add(w3);
        walls.add(w4);
        walls.add(w5);
        walls.add(w6);
        walls.add(w7);
        walls.add(w8);

        TrackLocation2D p1 = new TrackLocation2D(5,6);
        TrackLocation2D p2 = new TrackLocation2D(5,8);
        TrackLocation2D p3 = new TrackLocation2D(5,6);
        TrackLocation2D p4 = new TrackLocation2D(5,8);

        List<TrackLocation2D> start = new ArrayList<>();
        start.add(p1);
        start.add(p2);
        List<TrackLocation2D> finish = new ArrayList<>();
        finish.add(p3);
        finish.add(p4);
        //crea tracciato
        return new DefaultTrack2D<>(start,finish,walls);
    }

    @Test
    public void testGetStatusAt() {
        Track<TrackLocation2D> tr = getDefaultTrack();
        Car<TrackLocation2D> c = tr.createCar();
        tr.addCar(c);
        assertSame(tr.getStatusAt(c.getLocation()), DefaultStateCar.IN_RACE);
    }

    @Test
    public void createCar() {
        Track<TrackLocation2D> tr = getDefaultTrack();
        Car<TrackLocation2D> c = tr.createCar();
        tr.addCar(c);
        assertEquals(1, tr.getCars().size());
        assertTrue(tr.getStart().contains(c.getLocation()));
        Car<TrackLocation2D> c1 = tr.createCar();
        tr.addCar(c1);
        assertEquals(2, tr.getCars().size());
        assertNotSame(c.getLocation(), c1.getLocation());
        assertTrue(tr.getStart().contains(c1.getLocation()));
    }
}