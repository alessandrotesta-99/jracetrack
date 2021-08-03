package it.unicam.cs.pa.jraceTrack.View;

import it.unicam.cs.pa.jraceTrack.Model.Location.Location;

import java.io.IOException;

/**
 * Interfaccia che rappresenta la vista dell'applicazione.
 * Le classi che implementeranno questa interfaccia hanno la responsabilit&agrave; di definire un tipo di vista.
 */
public interface View {

    void open() throws IOException;

    void close() throws IOException;

}