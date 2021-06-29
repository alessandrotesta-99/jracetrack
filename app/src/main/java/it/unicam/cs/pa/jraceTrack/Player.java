package it.unicam.cs.pa.jraceTrack;

/**
 * Interfaccia che specifica un qualsiasi tipo di giocatore che vuole giocare al gioco.
 * La responsabilita primaria di questa interfaccia &egrave; quella di caratterizzare un giocatore.
 * Parametrizzata in base al tipo di giocatore e allo stato in cui si trova.
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
	 * da vedere. eliminare le dipendenze circolari, quindi o usare qui o nell'interfaccia Car.
	 */
	Car<L> getCar();

	/**
	 * Metodo che ritorna il tipo del giocatore.
	 * @return il tipo del giocatore.
	 */
	TypePlayer getType();

	/**
	 * Metodo che ritorna lo stato della macchina del giocatore in un certo momento.
	 * @return lo stato della macchina.
	 */
	DefaultStateCar getStatus();

	/**
	 * Metodo che permette al giocatore di spostare la macchina.
	 * @param p nuova posizione dove si trova la macchina.
	 */
	void moveUp(L p);

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
	//todo dubbi.
	void setWinner(boolean flag);

	/**
	 * Metodo che restituisce true se il giocatore ha vinto la gara.
	 * @return true se il giocatore ha vinto, false se ha perso.
	 */
	boolean isWinner();

}