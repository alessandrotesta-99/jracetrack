package it.unicam.cs.pa.jraceTrack.Model.Location;

import it.unicam.cs.pa.jraceTrack.Model.Car;

import java.util.Set;

/**
 * Interfaccia funzionale che specifica un metodo per la creazione delle prossime locazioni della macchina.
 * Le classi che implementeranno questa interfaccia hanno la responsabilit&agrave; di rappresentare la locazione
 * nel campo.
 * @param <L> tipo parametrico per la locazione nel campo.
 */
@FunctionalInterface
public interface Location<L extends Location<? extends L>> {

    /**
     * Metodo che restituisce le prossime locazioni in cui può andare una macchina.
     * @param c macchina
     * @return set di successive locazioni.
     */
    Set<L> getNextLocations(Car<L> c);

}
