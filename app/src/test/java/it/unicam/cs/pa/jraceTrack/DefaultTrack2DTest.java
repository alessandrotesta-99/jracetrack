package it.unicam.cs.pa.jraceTrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DefaultTrack2DTest{

    @Test
    public void testGetCarAt() {
        TrackLocation2D p1 = new TrackLocation2D(0,0);
        TrackLocation2D p2 = new TrackLocation2D(0,20);
        TrackLocation2D p3 = new TrackLocation2D(20,0);
        TrackLocation2D p4 = new TrackLocation2D(20,20);
        List<TrackLocation2D> partenza = new ArrayList<>();
        partenza.add(p1);
        partenza.add(p2);
        List<TrackLocation2D> arrivo = new ArrayList<>();
        arrivo.add(p3);
        arrivo.add(p4);

        //test costruttore.
        TrackLocation2D a1 = new TrackLocation2D(1,1);
        TrackLocation2D a2 = new TrackLocation2D(1,2);
        TrackLocation2D a3 = new TrackLocation2D(1,3);
        TrackLocation2D a4 = new TrackLocation2D(2,1);
        TrackLocation2D a5 = new TrackLocation2D(2,2);
        TrackLocation2D a6 = new TrackLocation2D(2,3);
        TrackLocation2D a7 = new TrackLocation2D(3,2);
        TrackLocation2D a8 = new TrackLocation2D(3,3);
        partenza.forEach(System.out::println);
        DefaultTrack2D<Location<TrackLocation2D>> tr = new DefaultTrack2D<>( partenza, arrivo,
                a1, a2, a3, a4, a5, a6, a7, a8);
        tr.getWalls().forEach(System.out::println);
    }

    @Test
    public void testCreateTrackCircle(){
        TrackLocation2D w1 = new TrackLocation2D(1,1);
        TrackLocation2D w2 = new TrackLocation2D(1,8);
        TrackLocation2D w3 = new TrackLocation2D(10,1);
        TrackLocation2D w4 = new TrackLocation2D(10,8);

        TrackLocation2D w5 = new TrackLocation2D(3,3);
        TrackLocation2D w6 = new TrackLocation2D(3,6);
        TrackLocation2D w7 = new TrackLocation2D(8,3);
        TrackLocation2D w8 = new TrackLocation2D(8,6);

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

       new DefaultTrack2D<>(start,finish,w1,w2,w3,w4,w5,w6,w7,w8);
    }

    @Test
    public void testCreateTrackNotCircle(){
        TrackLocation2D w1 = new TrackLocation2D(1,1);
        TrackLocation2D w2 = new TrackLocation2D(1,8);
        TrackLocation2D w3 = new TrackLocation2D(10,1);
        TrackLocation2D w4 = new TrackLocation2D(10,8);

        TrackLocation2D w5 = new TrackLocation2D(3,3);
        TrackLocation2D w6 = new TrackLocation2D(3,6);
        TrackLocation2D w7 = new TrackLocation2D(8,3);
        TrackLocation2D w8 = new TrackLocation2D(8,6);

        TrackLocation2D p1 = new TrackLocation2D(5,6);
        TrackLocation2D p2 = new TrackLocation2D(5,8);

        TrackLocation2D p3 = new TrackLocation2D(1,4);
        TrackLocation2D p4 = new TrackLocation2D(3,4);

        List<TrackLocation2D> start = new ArrayList<>();
        start.add(p1);
        start.add(p2);
        List<TrackLocation2D> finish = new ArrayList<>();
        finish.add(p3);
        finish.add(p4);

        new DefaultTrack2D<>(start,finish,w1,w2,w3,w4,w5,w6,w7,w8);
    }


    @Test
    public void testGetNextLocs() {
    }

    @Test
    public void testConstructor(){
    }
}