package it.unicam.cs.pa.jraceTrack.Model.Reader;

import it.unicam.cs.pa.jraceTrack.Model.MyFactoryLocation;
import it.unicam.cs.pa.jraceTrack.Model.Race;
import it.unicam.cs.pa.jraceTrack.Model.TrackLocation2D;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public TrackReaderTXT(Race<TrackLocation2D> race) {
        this.start = new ArrayList<>();
        this.finish = new ArrayList<>();
        this.walls = new ArrayList<>();
        this.race = race;
    }

    @Override
    public void read(String name) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(name.trim()));
        String nextStr = br.readLine();
        List<String> fieldSeparator = new ArrayList<>();
        while (nextStr != null) {
            if(nextStr.equals(";")){
                fieldSeparator.add(nextStr);
                nextStr = br.readLine();
            }
            String[] xy = nextStr.replaceAll("\\(", "").replaceAll("\\)", "").split(",");
            if(fieldSeparator.isEmpty())
                walls.add(MyFactoryLocation.getInstance().createLocation(Integer.parseInt(String.valueOf(xy[0])), Integer.parseInt(String.valueOf(xy[1]))));
            if (fieldSeparator.size() == 1)
                start.add(MyFactoryLocation.getInstance().createLocation(Integer.parseInt(String.valueOf(xy[0])), Integer.parseInt(String.valueOf(xy[1]))));
            else if(fieldSeparator.size() == 2)
                finish.add(MyFactoryLocation.getInstance().createLocation(Integer.parseInt(String.valueOf(xy[0])), Integer.parseInt(String.valueOf(xy[1]))));
            nextStr = br.readLine();
        }
        br.close();
        createObjectFromFile();
    }

    @Override
    public void createObjectFromFile() {
        race.createTrack(start, finish, walls);
    }
}
