package it.unicam.cs.pa.jraceTrack;

import it.unicam.cs.pa.jraceTrack.Model.DefaultRace;
import it.unicam.cs.pa.jraceTrack.Model.Race;
import it.unicam.cs.pa.jraceTrack.Model.Reader.ObjectReader;
import it.unicam.cs.pa.jraceTrack.Model.Reader.PlayerReaderTXT;
import it.unicam.cs.pa.jraceTrack.Model.Reader.TrackReaderTXT;
import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class PlayerReaderTXTTest {

    @Test
    public void read() throws IOException {
        Race<DefaultLocation> r = new DefaultRace();
        ObjectReader trackReaderTXT = new TrackReaderTXT(r, "testFiles\\track.txt");
        ObjectReader playerReader = new PlayerReaderTXT(r, "testFiles\\players.txt");
        trackReaderTXT.read();
        playerReader.read();
        assertEquals(2, r.getPlayers().size());
        assertEquals("piero", r.getPlayers().get(0).getName());
        assertNotNull(r.getPlayers().get(0).getCar());
        assertEquals("luca", r.getPlayers().get(1).getName());
        assertNotNull(r.getPlayers().get(1).getCar());
    }
}