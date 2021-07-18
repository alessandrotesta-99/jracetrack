package it.unicam.cs.pa.jraceTrack.Model;

import it.unicam.cs.pa.jraceTrack.Model.Location.Location;

/**
 * Interfaccia che specifica un qualsiasi tipo di giocatore che vuole giocare al gioco.
 * La responsabilita primaria di questa interfaccia &egrave; quella di caratterizzare un giocatore.
 * Le classi che implementano questa interfaccia devono fornire una implementazione per un tipo di giocatore
 * che potrebbe essere bot o interattivo.
 * @param <L> tipo per la locazione.
 */
public interface Player<L extends Location<? extends L>> {

	/**
	 * Metodo che ritorna il nome del giocatore.
	 * @return il nome del giocatore.
	 */
	String getName();

	/**
	 * Metodo che setta il nome al giocatore.
	 * @param name nome del giocatore.
	 */
	void setName(String name);

	/**
	 * Metodo che restituisce la macchina del giocatore.
	 * @return la macchina del giocatore.
	 */
	Car<L> getCar();

	/**
	 * Metodo che setta la macchina al giocatore.
	 * @param car la macchina.
	 */
	void setCar(Car<L> car);

	/**
	 * Metodo che ritorna il tipo del giocatore.
	 * @return il tipo del giocatore.
	 */
	TypePlayer getType();


	/**
	 * Metodo che permette al giocatore di far avanzare la macchina.
	 * @param pos posizione prossima della macchina.
	 */
	void moveUp(L pos);

	/**
	 * Metodo che restituisce il turno corrente del giocatore.
	 * @return il turno del giocatore.
	 */
	int getTurn();

	/**
	 * Metodo che setta il turno del giocatore.
	 * @param turn turno da settare.
	 */
	void setTurn(boolean turn);

	/**
	 * Metodo che controlla se è il proprio turno.
	 * @return true se è il turno del giocatore, false altrimenti.
	 */
	boolean isMyTurn();

	/**
	 * Metodo che setta questo giocatore come vincitore della gara.
	 * @param flag lo stato del giocatore.
	 */
	void setWinner(boolean flag);

	/**
	 * Metodo che restituisce true se il giocatore ha vinto la gara.
	 * @return true se il giocatore ha vinto, false se ha perso.
	 */
	boolean isWinner();

}