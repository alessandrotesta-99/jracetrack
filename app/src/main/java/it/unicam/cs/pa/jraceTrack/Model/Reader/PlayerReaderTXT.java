package it.unicam.cs.pa.jraceTrack.Model.Reader;

import it.unicam.cs.pa.jraceTrack.Model.Race;
import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;
import it.unicam.cs.pa.jraceTrack.Model.TypePlayer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

/**
 * Classe che specifica un Reader per la lettura di un file, che corrisponde ad una lista di giocatori che
 * parteciperanno alla gara.
 * Il formato del file deve essere ".txt" e deve essere scritto in questo modo:
 *
 * TIPOGIOCATORE;nomeGiocatore,
 * TIPOGIOCATORE;nomeGiocatore,
 * TIPOGIOCATORE;nomeGiocatore,
 *
 * Ogni stringa rappresenta un giocatore. La stringa ha un separatore di campi: ";" che la divide in due campi.
 * Il primo campo indica il tipo del giocatore, mentre il secondo campo indica il nome del giocatore.
 * &Egrave; possibile inserire sia giocatori Bot che giocatori Interattivi, ma non entrambi nella stessa gara.
 */
public class PlayerReaderTXT implements ObjectReader {

    private final Race<DefaultLocation> race;
    private TypePlayer typePlayer;
    private final File file;


    public PlayerReaderTXT(Race<DefaultLocation> race, String name) {
        this.race = race;
        this.file = new File(name);
    }

    @Override
    public void read() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String nextStr = br.readLine();
        int count = 0;
        while (nextStr != null) {
            String[] botName = nextStr.replaceAll(";", ",").split(",");
            if(botName[0].equalsIgnoreCase("bot"))
                typePlayer = TypePlayer.BOT;
            else if(botName[0].equalsIgnoreCase("interactive"))
                typePlayer = TypePlayer.INTERACTIVE;
            createObjectFromFile();
            race.getPlayers().get(count).setName(botName[1]);
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
