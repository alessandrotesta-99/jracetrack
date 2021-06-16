package it.unicam.cs.pa.jraceTrack;

import java.util.List;
import java.util.Set;

/**
 * Interfaccia che si occupa di specificare una gara. La responsabilita &egrave; quella di gestire tutte le
 * componenti che compongono una gara.
 * Parametrizzata secondo uno stato per avere piu implementazioni di stato diverse.
 * Le classi che implementeranno questa interfaccia avranno la responsabilita di fornire un implementazione
 * di una gara.
 * @param <L> tipo per la locazione.
 * @param <S> tipo per lo stato.
 */
public interface Race<L,S> {
	/**
	 * Metodo che restituisce tutti i giocatori che sono in gara.
	 * @return giocatori che sono in gara.
	 */
	List<Player<L, S>> getPlayers();

	/**
	 * Metodo che restituisce il circuito di gara.
	 * @return il circuito di gara.
	 */
	Track<L,S> getTrack();

	/**
	 * Metodo che avvia la gara.
	 */
	void start();

	/**
	 * Metodo che termina la gara.
	 */
	void finish();

	/**
	 * Metodo che verifica lo stato della gara.
	 * @return true se la gara &egrave; in corso, false altrimenti.
	 */
	boolean isStart();

	/**
	 * Metodo che restituisce lo stato di tutte le macchine in gara.
	 * @return restituisce lo stato delle macchine in un certo momento.
	 */
	//todo dubbi
	List<S> getStatus();

	/**
	 *
	 /**
	 * Metodo che crea il circuito di gara.
	 * @param width larghezza del circuito
	 * @param start inizio del circuito
	 * @param finish fine del circuito
	 * @param walls muri del circuito
	 * @return il circuito creato.
	 */
	//TODO refactoring. non mi piace che devo passare tutti i parametri.
	Track<L,S> createTrack(int width, List<L> start, List<L> finish, L... walls);

	/**
	 * Metodo che aggiunge un giocatore alla gara.
	 * @param p giocatore da aggiungere.
	 */
	void addPlayer(Player<L,S> p);

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