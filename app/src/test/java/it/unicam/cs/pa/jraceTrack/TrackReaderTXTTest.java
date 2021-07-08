package it.unicam.cs.pa.jraceTrack;

import org.junit.Test;
import static  org.junit.Assert.*;

import java.io.IOException;

public class TrackReaderTXTTest {

    @Test
    public void readTrack() throws IOException {
        Race<TrackLocation2D> race = new DefaultRace<>(2, TypePlayer.BOT);
        assertNull(race.getTrack());
        TrackReader<TrackLocation2D> r = new TrackReaderTXT(race);
        r.readTrack("track.txt");
        assertNotNull(race.getTrack());
        System.out.println(race.getTrack().getStart());
        System.out.println(race.getTrack().getFinish());
        System.out.println(race.getTrack().getWalls());
    }
}