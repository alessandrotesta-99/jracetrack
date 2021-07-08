package it.unicam.cs.pa.jraceTrack;

import it.unicam.cs.pa.jraceTrack.Model.DefaultRace;
import it.unicam.cs.pa.jraceTrack.Model.Race;
import it.unicam.cs.pa.jraceTrack.Model.Reader.ObjectReader;
import it.unicam.cs.pa.jraceTrack.Model.Reader.TrackReaderTXT;
import it.unicam.cs.pa.jraceTrack.Model.TrackLocation2D;
import it.unicam.cs.pa.jraceTrack.Model.TypePlayer;
import org.junit.Test;
import static  org.junit.Assert.*;

import java.io.IOException;

public class TrackReaderTXTTest {

    @Test
    public void readTrack() throws IOException {
        Race<TrackLocation2D> race = new DefaultRace<>(2, TypePlayer.BOT);
        assertNull(race.getTrack());
        ObjectReader<TrackLocation2D> r = new TrackReaderTXT(race);
        r.read("track.txt");
        assertNotNull(race.getTrack());
    }
}