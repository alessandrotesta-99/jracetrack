package it.unicam.cs.pa.jraceTrack;

import java.util.List;
import java.util.Set;

/**
 * Interfaccia che si occupa di specificare una gara. La responsabilita &egrave; quella di gestire tutte le
 * componenti che compongono una gara.
 * Parametrizzata secondo uno stato per avere piu implementazioni di stato diverse.
 * Le classi che implementeranno questa interfaccia avranno la responsabilita di fornire un implementazione
 * di una gara.
 * @param <S> stato della gara.
 */
public interface Race<S extends Stato> {
	/**
	 * Metodo che restituisce tutti i giocatori che sono in gara.
	 * @return giocatori che sono in gara.
	 */
	Set<Player> getPlayers();

	/**
	 * Metodo che restituisce il circuito di gara.
	 * @return il circuito di gara.
	 */
	Track getTrack();

	/**
	 * Metodo che avvia la gara.
	 */
	void start();

	/**
	 * Metodo che termina la gara.
	 */
	void finish();

	/**
	 * Metodo che restituisce lo stato della gara.
	 * @return restituisce lo stato della gara in un certo momento.
	 */
	S getStatus();

	/**
	 * Metodo che restituisce tutte le macchine in gara.
	 * @return macchine in gara.
	 */
	Set<Car> getCars();

	/**
	 * Metodo che crea il circuito di gara.
	 * @param t il circuito creato.
	 */
	void createTrack(Track t);

	/**
	 * Metodo che aggiunge una macchina al circuito.
	 * @param c macchina da aggiungere.
	 */
	void addCar(Car c);

	/**
	 * statistiche di gara: tempo impiegato, numero di turni impiegati, numero di movimenti, ecc.
	 */
	void getStatistics();

	/**
	 * Metodo che restituisce la lista di regole della gara.
	 * @return lista di regole della gara.
	 */
	List<Rule> getListRule();

}