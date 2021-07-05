package it.unicam.cs.pa.jraceTrack;

import java.io.*;

public class TrackReaderTXT implements TrackReader<TrackLocation2D> {

    private final char FIELD_SEPARATOR = ';';
    private File file;
    private FileInputStream fis;
    private InputStreamReader isr;
    private ObjectInputStream ois;

    public TrackReaderTXT() {

    }

    @Override
    public void readTrack(String name) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(name));
        String nextStr;
        nextStr = br.readLine();
        while (nextStr != null){
            System.out.println(nextStr);
            nextStr = br.readLine();
        }
        br.close();
    }

    @Override
    public Track<TrackLocation2D> createTrackFrom(File file) {
        return null;
    }
}
