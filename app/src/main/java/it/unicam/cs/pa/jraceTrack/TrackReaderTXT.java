package it.unicam.cs.pa.jraceTrack;

import java.io.*;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TrackReaderTXT implements TrackReader<TrackLocation2D> {

    private final String FIELD_SEPARATOR = ";";
    private final Race<TrackLocation2D> race;
    private Track<TrackLocation2D> track;
    private File file;
    private FileInputStream fis;
    private InputStreamReader isr;
    private ObjectInputStream ois;

    public TrackReaderTXT(Race<TrackLocation2D> race) {
        this.race = race;
    }

    @Override
    public void readTrack(String name) throws FileNotFoundException {
        List<TrackLocation2D> start = new ArrayList<>();
        List<TrackLocation2D> stop = new ArrayList<>();
        List<TrackLocation2D> walls = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(name.trim()));
            String nextStr = br.readLine();
            List<String> ss = new ArrayList<>();
            while (nextStr != null) {
                //todo trovato un modo. refactoring urgente.

                if(nextStr.equals(";")){
                    ss.add(nextStr);
                    nextStr = br.readLine();
                }
                //tutte le coordinate.
                String[] xy = nextStr.replaceAll("\\(|\\)", "").split(",");
                for (int i = 0; i < nextStr.chars().count(); i++){
                    if(nextStr.charAt(i) == ')' && ss.isEmpty()){
                        walls.add(MyFactoryLocation.getInstance().createLocation(Integer.parseInt(String.valueOf(xy[0])), Integer.parseInt(String.valueOf(xy[1]))));
                    }
                }
                if (ss.size() == 1) {
                    start.add(MyFactoryLocation.getInstance().createLocation(Integer.parseInt(String.valueOf(xy[0])), Integer.parseInt(String.valueOf(xy[1]))));
                } else if(ss.size() == 2) {
                    stop.add(MyFactoryLocation.getInstance().createLocation(Integer.parseInt(String.valueOf(xy[0])), Integer.parseInt(String.valueOf(xy[1]))));
                }
                nextStr = br.readLine();
               /* for (int i = 0; i < fields[1].chars().count(); i++)
                    if(fields[1].charAt(i) == ')')
                        start.add(MyFactoryLocation.getInstance().createLocation(Integer.parseInt(String.valueOf(fields[1].charAt(i-3))), Integer.parseInt(String.valueOf(fields[1].charAt(i-1)))));
                for (int i = 0; i < fields[2].chars().count(); i++)
                    if(fields[2].charAt(i) == ')')
                       stop.add(MyFactoryLocation.getInstance().createLocation(Integer.parseInt(String.valueOf(fields[2].charAt(i-3))), Integer.parseInt(String.valueOf(fields[2].charAt(i-1)))));
                nextStr = br.readLine();*/
            }
            br.close();
            createTrackFromFile(start, stop, walls);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTrackFromFile(List<TrackLocation2D> start, List<TrackLocation2D> finish, List<TrackLocation2D> walls) {
         race.createTrack(start,finish, walls);
    }
}
