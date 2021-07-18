package it.unicam.cs.pa.jraceTrack;

import it.unicam.cs.pa.jraceTrack.Model.*;
import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DefaultTrack2DTest{

    @Test
    public void testGetCarAt() {
        //crea tracciato
        Track<DefaultLocation> tr = getDefaultTrack();

        Car<DefaultLocation> c = tr.createCar();
        c.setLocation(new DefaultLocation(5,8)); //solo per test.
        tr.addCar(c);
        Car<DefaultLocation> c1 = tr.createCar();
        c1.setLocation(new DefaultLocation(5,6)); //solo per test.
        tr.addCar(c1);

        c.moveUp(new DefaultLocation(4,9));
        c1.moveUp(new DefaultLocation(4,7));

        assertNotSame(tr.getCarAt(new DefaultLocation(5, 6)), c1);
        assertSame(tr.getCarAt(new DefaultLocation(4, 7)), c1);
        assertNotSame(tr.getCarAt(new DefaultLocation(5, 8)), c);
        assertSame(tr.getCarAt(new DefaultLocation(4, 9)), c);
    }

    @Test
    public void testGetNextLocs() {
        Track<DefaultLocation> tr = getDefaultTrack();
        Car<DefaultLocation> c = tr.createCar();
        tr.addCar(c);
        System.out.println(tr.getNextLocs(c.getLocation()));
        Set<DefaultLocation> nextPoints1 = Set.of(new DefaultLocation(4,6),
                new DefaultLocation(4,5),
                new DefaultLocation(4,7),
                new DefaultLocation(5,5),
                new DefaultLocation(5,6),
                new DefaultLocation(5,7),
                new DefaultLocation(6,5),
                new DefaultLocation(6,6),
                new DefaultLocation(6,7));
        Set<DefaultLocation> nextPoints2 = Set.of(new DefaultLocation(4,7),
                new DefaultLocation(4,8),
                new DefaultLocation(4,9),
                new DefaultLocation(5,7),
                new DefaultLocation(5,8),
                new DefaultLocation(5,9),
                new DefaultLocation(6,7),
                new DefaultLocation(6,8),
                new DefaultLocation(6,9));
        if(c.getLocation().equals(new DefaultLocation(5, 6)))
            assertTrue(tr.getNextLocs(c.getLocation()).containsAll(nextPoints1));
        else if(c.getLocation().equals(new DefaultLocation(5,8)))
            assertTrue(tr.getNextLocs(c.getLocation()).containsAll(nextPoints2));
    }

    @Test
    public void testAddCar() {
        Track<DefaultLocation> tr = getDefaultTrack();
        tr.addCar(tr.createCar());
        tr.addCar(tr.createCar());
        assertSame(2, tr.getCars().size());
    }

    private Track<DefaultLocation> getDefaultTrack() {
        DefaultLocation w1 = new DefaultLocation(1,1);
        DefaultLocation w2 = new DefaultLocation(1,8);
        DefaultLocation w3 = new DefaultLocation(10,1);
        DefaultLocation w4 = new DefaultLocation(10,8);
        DefaultLocation w5 = new DefaultLocation(3,3);
        DefaultLocation w6 = new DefaultLocation(3,6);
        DefaultLocation w7 = new DefaultLocation(8,3);
        DefaultLocation w8 = new DefaultLocation(8,6);
        List<DefaultLocation> walls = new ArrayList<>();
        walls.add(w1);
        walls.add(w2);
        walls.add(w3);
        walls.add(w4);
        walls.add(w5);
        walls.add(w6);
        walls.add(w7);
        walls.add(w8);

        DefaultLocation p1 = new DefaultLocation(5,6);
        DefaultLocation p2 = new DefaultLocation(5,8);
        DefaultLocation p3 = new DefaultLocation(5,6);
        DefaultLocation p4 = new DefaultLocation(5,8);

        List<DefaultLocation> start = new ArrayList<>();
        start.add(p1);
        start.add(p2);
        List<DefaultLocation> finish = new ArrayList<>();
        finish.add(p3);
        finish.add(p4);
        //crea tracciato
        return new DefaultTrack(start,finish,walls);
    }

    @Test
    public void testGetStatusAt() {
        Track<DefaultLocation> tr = getDefaultTrack();
        Car<DefaultLocation> c = tr.createCar();
        tr.addCar(c);
        assertSame(tr.getStatusAt(c.getLocation()), DefaultStateCar.IN_RACE);
    }

    @Test
    public void createCar() {
        Track<DefaultLocation> tr = getDefaultTrack();
        Car<DefaultLocation> c = tr.createCar();
        tr.addCar(c);
        assertEquals(1, tr.getCars().size());
        assertTrue(tr.getStart().contains(c.getLocation()));
        Car<DefaultLocation> c1 = tr.createCar();
        tr.addCar(c1);
        assertEquals(2, tr.getCars().size());
        assertNotSame(c.getLocation(), c1.getLocation());
        assertTrue(tr.getStart().contains(c1.getLocation()));
    }
}