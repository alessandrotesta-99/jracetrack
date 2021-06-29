package it.unicam.cs.pa.jraceTrack;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Interfaccia funzionale che specifica un metodo per la creazione delle prossime locazioni della macchina.
 * Le classi che implementeranno questa interfaccia hanno la responsabilità di rappresentare la locazione
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

    default Set<L> getNextLocations(Car<L> c, Predicate<? super L> pred) {
        return getNextLocations(c).stream().filter(pred).collect(Collectors.toSet());
    }
}
