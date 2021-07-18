package it.unicam.cs.pa.jraceTrack;

import it.unicam.cs.pa.jraceTrack.Model.DefaultRace;
import it.unicam.cs.pa.jraceTrack.Model.Race;
import it.unicam.cs.pa.jraceTrack.Model.Reader.ObjectReader;
import it.unicam.cs.pa.jraceTrack.Model.Reader.TrackReaderTXT;
import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;
import org.junit.Test;
import static  org.junit.Assert.*;

import java.io.IOException;

public class TrackReaderTXTTest {

    @Test
    public void readTrack() throws IOException {
        Race<DefaultLocation> race = new DefaultRace();
        assertNull(race.getTrack());
        ObjectReader r = new TrackReaderTXT(race,"testFiles\\track.txt");
        r.read();
        assertNotNull(race.getTrack());
    }
}