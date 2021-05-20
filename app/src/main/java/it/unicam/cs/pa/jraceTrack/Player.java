package it.unicam.cs.pa.jraceTrack;

/**
 * Interfaccia che specifica un qualsiasi tipo di giocatore che vuole giocare al gioco.
 * La responsabilita primaria di questa interfaccia &egrave; quella di caratterizzare un giocatore.
 * Parametrizzata in base al tipo di giocatore e allo stato in cui si trova.
 * Le classi che implementano questa interfaccia devono fornire una implementazione per un tipo di giocatore
 * che potrebbe essere bot o interattivo.
 * @param <T> tipo del giocatore.
 * @param <S> stato del giocatore.
 * @param <L> locazione della macchina.
 */
public interface Player<T, S extends Stato, L> {
	/**
	 * Metodo che ritorna il nome del giocatore.
	 * @return il nome del giocatore.
	 */
	String getName();

	/**
	 * da vedere. eliminare le dipendenze circolari, quindi o usare qui o nell'interfaccia Car.
	 */
	Car getCar();

	/**
	 * Metodo che ritorna il tipo del giocatore.
	 * @return il tipo del giocatore.
	 */
	T getType();

	/**
	 * Metodo che ritorna lo stato di un giocatore in un certo momento.
	 * @return lo stato di un giocatore.
	 */
	S getStatus();

	/**
	 * Metodo che permette di far avanzare la macchina guidata dal giocatore secondo determinate regole.
	 * @param r regola da applicare per far avanzare la macchina.
	 * @return la nuova posizione che la macchina ha.
	 */
	//forse meglio se restituisce un line segment. dovrebbe restituire un segmento di lunghezza tot.
	L accelerate(Rule r);

	/**
	 * Metodo che permette di far frenare la macchina guidata dal giocatore, in un certo periodo di tempo
	 * applicando la regola necessaria.
	 * @param r regola da applicare per frenare la macchina.
	 * @return la nuova posizione che la macchina ha.
	 */
	//forse meglio se restituisce un line segment
	L brake(Rule r);

	/**
	 * Metodo che restituisce il turno corrente del giocatore.
	 * @return il turno del giocatore.
	 */
	int getTurn();

	/**
	 * Metodo che setta il turno al giocatore.
	 * @return true se è il turno del giocatore, false altrimenti.
	 */
	boolean setTurn();

}