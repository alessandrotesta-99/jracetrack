package it.unicam.cs.pa.jraceTrack.View;

import it.unicam.cs.pa.jraceTrack.Model.Location;

import java.io.IOException;

/**
 * Interfaccia che rappresenta la vista dell'applicazione.
 * Le classi che implementeranno questa interfaccia hanno la responsabilit&agrave; di definire un tipo di vista.
 */
public interface View<L extends Location<L>> {

    void open() throws IOException;

    void close();

}