package it.unicam.cs.pa.jraceTrack;

/**
 * Interfaccia che permette di creare i punti all'interno del circuito.
 * All'aggiunta di un nuovo tipo di punto basta aggiungere un nuovo metodo.
 */
public interface FactoryPoint {

    static Point2D createPoint(int x, int y){
        return new Point2D(x,y);
    }
}
