package it.unicam.cs.pa.jraceTrack;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Interfaccia funzionale che specifica un metodo per la creazione dei prossimi punti della macchina.
 * Le classi che implementeranno questa interfaccia hanno la responsabilità di rappresentare la locazione
 * nel campo.
 * @param <L> tipo parametrico per la locazione nel campo.
 */
public interface Coordinates<L> {

    Set<L> getNextLocations(Car c);

  /*  default List<L> getNextLocations(Predicate<? super L> pred) {
        return getNextLocations().stream().filter(pred).collect(Collectors.toList());
    }*/
}
