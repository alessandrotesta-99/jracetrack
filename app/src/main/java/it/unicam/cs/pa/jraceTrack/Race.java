package it.unicam.cs.pa.jraceTrack;

import java.util.List;

/**
 * Interfaccia che si occupa di specificare una gara. La responsabilita &egrave; quella di gestire tutte le
 * componenti che compongono una gara.
 * Parametrizzata secondo uno stato per avere piu implementazioni di stato diverse.
 * Le classi che implementeranno questa interfaccia avranno la responsabilita di fornire un implementazione
 * di una gara.
 * @param <L> tipo per la locazione.
 */
public interface Race<L extends Location<? extends L>> {

	/**
	 * Metodo che restituisce tutti i giocatori che sono in gara.
	 * @return giocatori che sono in gara.
	 */
	List<Player<L>> getPlayers();

	/**
	 * Metodo che restituisce il circuito di gara.
	 * @return il circuito di gara.
	 */
	Track<L> getTrack();

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
	 * Metodo che crea il circuito di gara.
	 * @param track il tracciato da creare.
	 */
	void createTrack(Track<L> track);

	/**
	 * Metodo che crea un giocatore.
	 * @param typePlayer tipo del giocatore.
	 */
	void createPlayer(TypePlayer typePlayer);

	/**
	 * Metodo che aggiunge un giocatore alla gara.
	 * @param p giocatore da aggiungere.
	 */
	void addPlayer(Player<L> p);

	/**
	 * Metodo che rimuove un giocatore alla gara.
	 * @param p giocatore da rimuovere.
	 */
	void removePlayer(Player<L> p);

	/**
	 * Metodo che aggiunge una macchina alla gara.
	 * @param c macchina da aggiungere.
	 */
	void addCar(Car<L> c);

	/**
	 * Metodo che rimuove una macchina dalla gara.
	 * @param c macchina da rimuovere.
	 */
	void removeCar(Car<L> c);

	/**
	 * Metodo che restituisce la lista di regole della gara.
	 * @return lista di regole della gara.
	 */
	List<Rule> getListRule();

	/**
	 * Metodo che setta la lista di regole della gara.
	 * @param rule lista di regole.
	 */
	void setListRule(List<Rule> rule);

	/**
	 * Metodo che restituisce il giocatore che ha vinto la gara.
	 * @return il giocatore vincitore.
	 */
	Player<L> getWinner();

	/**
	 * Metodo che setta il vincitore della gara.
	 * @param player giocatore vincitore.
	 */
	void setWinnerPlayer(Player<L> player);

}