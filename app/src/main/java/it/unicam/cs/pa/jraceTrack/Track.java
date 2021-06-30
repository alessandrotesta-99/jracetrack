package it.unicam.cs.pa.jraceTrack;

import java.util.List;
import java.util.Set;

/**
 * Interfaccia che definisce un circuito composto da macchine.
 * Le classi che implementano questa interfaccia hanno la responsabilit&agrave; di
 * fornire un implementazione per un certo tipo di circuito.
 * @param <L> tipo per la locazione.
 */
public interface Track<L extends Location<? extends L>> {

	/**
	 * Metodo che restituisce la lista di macchine nel circuito.
	 * @return restituisce le macchine nel circuito.
	 */
	List<Car<L>> getCars();

	/**
	 * Metodo che restituisce una macchina ad una certa locazione.
	 * @param location posizione data.
	 * @return la macchina ad una certa posizione.
	 */
	Car<L> getCarAt(L location);

	/**
	 * Metodo che restituisce la linea di partenza del circuito.
	 * @return la linea di partenza.
	 */
	List<L> getStart();

	/**
	 * Metodo che restituisce la linea di arrivo del circuito.
	 * @return la linea di arrivo.
	 */
	List<L> getFinish();

	/**
	 * Metodo che aggiunge una macchina al circuito con la locazione corrente.
	 * @param c macchina da aggiungere.
	 */
	void addCar(Car<L> c);

	/**
	 * Metodo che restituisce le prossime posizioni disponibili nel circuito.
	 * @param c macchina che richiede le prossime posizioni.
	 * @return le prossime posizioni disponibili.
	 */
	Set<L> getNextLocs(Car<L> c);

	/**
	 * Metodo che restituisce la posizione di tutti i muri della pista.
	 * @return la posizione dei muri nella pista.
	 */
	List<L> getWalls();

	/**
	 * Metodo che aggiunge un muro alla pista.
	 * @param position la posizione dove aggiungere il muro.
	 */
	void addWall(L position);

	/**
	 * Metodo che restituise lo stato di una macchina ad una certa posizione.
	 * @return lo stato di una macchina.
	 */
	DefaultStateCar getStatusAt(L loc);

	/**
	 * Metodo che restituisce lo stato di tutte le macchine in gara.
	 * @return restituisce lo stato delle macchine in un certo momento.
	 */
	List<DefaultStateCar> getStatusCars();

	/**
	 * Metodo che controlla se il circuito è valido.
	 */
	void isValidTrack();

	/**
	 * Metodo che verifica se il circuito è circolare.
	 * @return true se la linea di partenza coincide con la linea di arrivo.
	 */
	default boolean isCircle(){
		return this.getStart().containsAll(this.getFinish());
	}

}