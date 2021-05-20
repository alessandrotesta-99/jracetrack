package it.unicam.cs.pa.jraceTrack;

import java.util.List;
import java.util.Set;

/**
 * Interfaccia che definisce un circuito composto da macchine.
 * Le classi che implementano questa interfaccia hanno la responsabilita di
 * fornire un implementazione per un certo tipo di circuito.
 * @param <L> tipo per la posizione delle macchine.
 */
public interface Track<L> {

	/**
	 * Metodo che restituisce la lista di macchine nel circuito.
	 * @return restituisce le macchine nel circuito.
	 */
	List<Car> getCars();

	/**
	 * Metodo che restituisce una macchina ad una certa locazione.
	 * @param location posizione data.
	 * @return la macchina ad una certa posizione.
	 */
	Car getCarAt(L location);

	/**
	 * Metodo che restituisce un nuovo campo all'applicazione di una regola.
	 * @param apply regola applicata.
	 * @return restituisce il nuovo campo.
	 */
	Track nextTrack(Rule apply);

	/**
	 * Metodo che restituisce il punto di partenza del circuito.
	 * @return il punto di partenza.
	 */
	L getStart();

	/**
	 * Metodo che restituisce il punto di arrivo del circuito.
	 * @return il punto di arrivo.
	 */
	L getFinish();

	/**
	 * Metodo che restituisce le prossime posizioni disponibili nel circuito.
	 * @param c macchina che richiede le prossime posizioni.
	 * @return le prossime posizioni disponibili.
	 */
	Set<L> getNextLocs(Car c);

	/**
	 * Metodo che restituisce la posizione di tutti i muri della pista.
	 * @return la posizione dei muri nella pista.
	 */
	//da definire meglio
	List<L> getWalls();

	/**
	 * Metodo che aggiunge un muro alla pista.
	 * @param wall il muro da aggiungere.
	 */
	void addWall(L wall);

}