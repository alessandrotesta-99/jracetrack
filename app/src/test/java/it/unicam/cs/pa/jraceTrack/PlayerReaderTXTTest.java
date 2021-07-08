package it.unicam.cs.pa.jraceTrack;

import it.unicam.cs.pa.jraceTrack.Model.DefaultRace;
import it.unicam.cs.pa.jraceTrack.Model.Race;
import it.unicam.cs.pa.jraceTrack.Model.Reader.ObjectReader;
import it.unicam.cs.pa.jraceTrack.Model.Reader.PlayerReaderTXT;
import it.unicam.cs.pa.jraceTrack.Model.TrackLocation2D;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;


public class PlayerReaderTXTTest {

    @Test
    public void read() throws IOException {
        Race<TrackLocation2D> r = new DefaultRace<>();
        ObjectReader<TrackLocation2D> playerReader = new PlayerReaderTXT(r);
        playerReader.read("botPlayers.txt");
        assertEquals(3, r.getPlayers().size());
        assertEquals("Bot1", r.getPlayers().get(0).getName());
        assertEquals("bot2", r.getPlayers().get(1).getName());
        assertEquals("bot3", r.getPlayers().get(2).getName());
    }
}