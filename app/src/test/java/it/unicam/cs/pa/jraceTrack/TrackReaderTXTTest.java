package it.unicam.cs.pa.jraceTrack;

import org.junit.Test;

import java.io.IOException;

public class TrackReaderTXTTest {

    @Test
    public void readTrack() throws IOException {
        TrackReader<TrackLocation2D> r = new TrackReaderTXT();
        r.readTrack("track.txt");
    }
}