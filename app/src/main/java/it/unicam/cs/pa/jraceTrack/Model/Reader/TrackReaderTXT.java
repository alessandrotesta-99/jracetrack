package it.unicam.cs.pa.jraceTrack.Model.Reader;

import it.unicam.cs.pa.jraceTrack.Model.DefaultRace;
import it.unicam.cs.pa.jraceTrack.Model.MyFactoryLocation;
import it.unicam.cs.pa.jraceTrack.Model.Race;
import it.unicam.cs.pa.jraceTrack.Model.TrackLocation2D;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che specifica un Reader per la lettura di un file, che corrisponde ad un tracciato.
 * Il formato del file deve essere ".txt" e deve essere scritto in questo modo:
 * (x,y),
 * (x,y),
 * (x,y),
 * (x,y),
 * (x,y)
 * ;
 * (x,y),
 * (x,y)
 * ;
 * (x,y),
 * (x,y)
 *
 * Le coordinate scritte fino al primo ";" specificano i punti che corrispondono ai muri del circuito.
 * Dopo di che vegnono specificate le coordinate che rappresentano i punti che formano una linea di partenza,
 * e infine dopo l'ultimo ";" vengono specificate le coordinate che rappresentano i punti che formano
 * la linea di arrivo.
 */
public class TrackReaderTXT implements ObjectReader<TrackLocation2D> {

    private final Race<TrackLocation2D> race;
    private final List<TrackLocation2D> start;
    private final List<TrackLocation2D> finish;
    private final List<TrackLocation2D> walls;
    private final File file;

    public TrackReaderTXT(Race<TrackLocation2D> race, String name) {
        this.start = new ArrayList<>();
        this.finish = new ArrayList<>();
        this.walls = new ArrayList<>();
        this.race = race;
        this.file = new File(name);
    }

    @Override
    public void read() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String nextStr = br.readLine();
        List<String> fieldSeparator = new ArrayList<>();
        while (nextStr != null) {
            if(nextStr.equals(";")){
                fieldSeparator.add(nextStr);
                nextStr = br.readLine();
            }
            String[] xy = nextStr.replaceAll("\\(", "").replaceAll("\\)", "").split(",");
            if(fieldSeparator.isEmpty())
                walls.add(getLocation(xy));
            if (fieldSeparator.size() == 1)
                start.add(getLocation(xy));
            else if(fieldSeparator.size() == 2)
                finish.add(getLocation(xy));
            nextStr = br.readLine();
        }
        br.close();
        createObjectFromFile();
    }

    private TrackLocation2D getLocation(String[] xy) {
        return MyFactoryLocation.getInstance().createLocation(Integer.parseInt(String.valueOf(xy[0])), Integer.parseInt(String.valueOf(xy[1])));
    }

    @Override
    public void createObjectFromFile() {
        race.createTrack(start, finish, walls);
    }
}
