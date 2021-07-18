package it.unicam.cs.pa.jraceTrack.Model.Location;

/**
 * Interfaccia che permette di creare una locazione.
 * Le classi che implementano questa interfaccia hanno la responsabilit&agrave; di fornire un
 * modo per la creazione di una locazione.
 */
public interface FactoryLocation<L extends Location<L>> {

    L createLocation(int...values);
}
