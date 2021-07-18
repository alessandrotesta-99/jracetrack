package it.unicam.cs.pa.jraceTrack.Controller;

import it.unicam.cs.pa.jraceTrack.Model.Location.Location;

/**
 * Interfaccia che ha la responsabilit&agrave; di creare un controller.
 * Le classi che implementano questa interfaccia hanno la responsabilit&agrave; di definire la creazione di un
 * controller.
 * @param <L> parametro di tipo per la locazione.
 */
public interface ControllerManager<L extends Location<L>> {

    /**
     * Metodo che crea un controller.
     * @return il controller creato.
     */
    Controller<L> createController();
}
