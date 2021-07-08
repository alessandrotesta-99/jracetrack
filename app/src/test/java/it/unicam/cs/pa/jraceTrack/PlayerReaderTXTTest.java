package it.unicam.cs.pa.jraceTrack;

import it.unicam.cs.pa.jraceTrack.Model.DefaultRace;
import it.unicam.cs.pa.jraceTrack.Model.Race;
import it.unicam.cs.pa.jraceTrack.Model.Reader.ObjectReader;
import it.unicam.cs.pa.jraceTrack.Model.Reader.PlayerReaderTXT;
import it.unicam.cs.pa.jraceTrack.Model.Reader.TrackReaderTXT;
import it.unicam.cs.pa.jraceTrack.Model.TrackLocation2D;

import it.unicam.cs.pa.jraceTrack.Model.TypePlayer;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class PlayerReaderTXTTest {

    @Test
    public void read() throws IOException {
        Race<TrackLocation2D> r = new DefaultRace<>();
        ObjectReader<TrackLocation2D> trackReaderTXT = new TrackReaderTXT(r);
        ObjectReader<TrackLocation2D> playerReader = new PlayerReaderTXT(r);
        trackReaderTXT.read("track.txt");
        playerReader.read("players.txt");
        assertEquals(2, r.getPlayers().size());
        assertEquals("Bot1", r.getPlayers().get(0).getName());
        assertNotNull(r.getPlayers().get(0).getCar());
        assertEquals("bot2", r.getPlayers().get(1).getName());
        assertNotNull(r.getPlayers().get(1).getCar());
    }
}