package it.unicam.cs.pa.jraceTrack.Model.Reader;

import it.unicam.cs.pa.jraceTrack.Model.Race;
import it.unicam.cs.pa.jraceTrack.Model.TrackLocation2D;
import it.unicam.cs.pa.jraceTrack.Model.TypePlayer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PlayerReaderTXT implements ObjectReader<TrackLocation2D> {

    private final Race<TrackLocation2D> race;
    private final TypePlayer typePlayer;


    public PlayerReaderTXT(Race<TrackLocation2D> race) {
        this.race = race;
        this.typePlayer = TypePlayer.BOT;
    }

    @Override
    public void read(String name) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(name.trim()));
        String nextStr = br.readLine();
        int count = 0;
        while (nextStr != null) {
            String[] botName = nextStr.split(",");
            createObjectFromFile();
            race.getPlayers().get(count).setName(botName[0]);
            nextStr = br.readLine();
            count++;
        }
        br.close();
    }

    @Override
    public void createObjectFromFile() {
        race.createPlayer(typePlayer);
    }
}
