package it.unicam.cs.pa.jraceTrack;

import java.io.File;
import java.io.IOException;

/**
 * Interfaccia che permette di leggere da file un oggetto @{@link Track} che rappresenta il circuito.
 * Le classi che implementeranno questa interfaccia avranno la responsabilit&agrave; di decidere il tipo del file
 * in lettura.
 * */
public interface TrackReader<L extends Location<? extends L>> {

    /**
     * Metodo che permette di leggere un file di configurazione del tracciato.
     * @param name
     */
    void readTrack(String name) throws IOException;

    /**
     * Metodo che crea un oggetto dal file che viene letto.
     * @param file file che viene letto.
     * @return il tracciato creato.
     */
    Track<L> createTrackFrom(File file);


}
