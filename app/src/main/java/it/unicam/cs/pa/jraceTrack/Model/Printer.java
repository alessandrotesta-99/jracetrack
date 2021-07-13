package it.unicam.cs.pa.jraceTrack.Model;

import java.util.List;

public interface Printer<L extends Location<L>> {

    /**
     * Metodo che stampa una rappresentazione in stringa.
     * @return la stringa.
     * @param params
     */
    List<String> getString(int... params);
}
