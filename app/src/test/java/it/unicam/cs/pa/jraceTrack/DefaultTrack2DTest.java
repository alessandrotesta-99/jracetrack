package it.unicam.cs.pa.jraceTrack;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultTrack2DTest{

    @Test
    public void testGetCarAt() {



    }

    @Test
    public void testCreateTrackCircle(){

    }


    @Test
    public void testGetNextLocs() {
    }


     @Test
    public void testAddCar() {


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

         //crea tracciato
         Track<TrackLocation2D> tr = new DefaultTrack2D<>(start,finish,w1,w2,w3,w4,w5,w6,w7,w8);

         //crea giocatore
         Player<TrackLocation2D> p = new PlayerBot("bot");

         //crea giocatore
         Player<TrackLocation2D> pl1 = new PlayerBot("bot1");

         //crea gara
         Race<TrackLocation2D> race = new DefaultRace<>(tr,p,pl1);

         race.start();


      //   assertEquals(2, tr.getCars().size());
      //   assertSame(c.getLocation(), c1.getLocation());

      //   c.moveUp(new TrackLocation2D(4,7));


    }

    @Test
    public void testGetStatusAt() {
    }
}