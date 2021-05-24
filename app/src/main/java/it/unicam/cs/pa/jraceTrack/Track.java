package it.unicam.cs.pa.jraceTrack;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Interfaccia che definisce un circuito composto da macchine.
 * Le classi che implementano questa interfaccia hanno la responsabilit&agrave; di
 * fornire un implementazione per un certo tipo di circuito.
 * @param <L> tipo per la posizione delle macchine.
 * @param <S> tipo per lo stato delle macchine.
 */
public interface Track<L,S> {

	/**
	 * Metodo che restituisce la lista di macchine nel circuito.
	 * @return restituisce le macchine nel circuito.
	 */
	List<Car<L,S>> getCars();

	/**
	 * Metodo che restituisce una macchina ad una certa locazione.
	 * @param location posizione data.
	 * @return la macchina ad una certa posizione.
	 */
	Car<L,S> getCarAt(L location);

	/**
	 * Metodo che restituisce un nuovo campo all'applicazione di una regola.
	 * @param r regola applicata.
	 * @return restituisce il nuovo campo.
	 */
	Track<L,S> nextTrack(Rule r);

	/**
	 * Metodo che restituisce il punto di partenza del circuito.
	 * @return il punto di partenza.
	 */
	List<L> getStart();

	/**
	 * Metodo che restituisce il punto di arrivo del circuito.
	 * @return il punto di arrivo.
	 */
	List<L> getFinish();

	/**
	 * Metodo che aggiunge una macchina al circuito.
	 * @param c macchina da aggiungere.
	 */
	void addCar(Car<L,S> c);

	/**
	 * Metodo che restituisce le prossime posizioni disponibili nel circuito.
	 * @param c macchina che richiede le prossime posizioni.
	 * @return le prossime posizioni disponibili.
	 */
	Set<L> getNextLocs(Car<L,S> c);

	/**
	 * Metodo che restituisce la posizione di tutti i muri della pista.
	 * @return la posizione dei muri nella pista.
	 */
	LinkedList<L> getWalls();

	/**
	 * Metodo che aggiunge un muro alla pista.
	 * @param position la posizione dove aggiungere il muro.
	 */
	void addWall(L position);

	/**
	 * Metodo che restituise lo stato di una macchina.
	 * @return lo stato di una macchina.
	 */
	S getStatus(Car<L,S> c);


}