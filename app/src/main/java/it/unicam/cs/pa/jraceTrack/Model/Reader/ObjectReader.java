package it.unicam.cs.pa.jraceTrack.Model.Reader;

import it.unicam.cs.pa.jraceTrack.Model.Location;

import java.io.IOException;

/**
 * Interfaccia che permette di leggere da file un qualsiasi oggetto.
 * Le classi che implementeranno questa interfaccia avranno la responsabilit&agrave; di implementare una
 * soluzione per la lettura di un oggetto da file e di specificare il tipo di file.
 * */
public interface ObjectReader<L extends Location<? extends L>> {

    /**
     * Metodo che permette di leggere un file di configurazione.
     */
    void read() throws IOException;

    /**
     * Metodo che crea un oggetto dal file che viene letto.
     */
    void createObjectFromFile();

}
