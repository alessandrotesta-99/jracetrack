package it.unicam.cs.pa.jraceTrack;

/**
 * Interfaccia che permette di creare i punti all'interno del circuito.
 * All'aggiunta di un nuovo tipo di punto basta aggiungere un nuovo metodo.
 */
public interface FactoryLocation<L extends Location<L>> {

    //todo
    static Location<?> createPoint(int... values){
        return new TrackLocation2D(values[0], values[1]);
    }
}
