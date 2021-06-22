package it.unicam.cs.pa.jraceTrack;

/**
 * Interfaccia che permette di creare i punti all'interno del circuito.
 * All'aggiunta di un nuovo tipo di punto basta aggiungere un nuovo metodo.
 */
public interface FactoryLocation {

    static TrackLocation2D createPoint(int x, int y){
        return new TrackLocation2D(x,y);
    }
}
