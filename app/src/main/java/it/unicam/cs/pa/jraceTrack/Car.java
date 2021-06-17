package it.unicam.cs.pa.jraceTrack;

import java.util.List;

/**
 * Interfaccia che specifica una macchina ed ha la responsabilita primaria di tener conto delle
 * caratteristiche della macchina e delle azioni.
 * Parametrizzata per stato e locazione, in modo da non dipendere da una singola implementazione.
 * Le classi che implementeranno questa interfaccia avranno la responsabilita di dare
 * un'implementazione per le caratteristiche di questa macchina.
 * @param <L> tipo per la locazione della macchina.
 * @param <S> tipo per lo stato della macchina.
 */
public interface Car<L, S> {

	/**
	 * Metodo che restituisce il tracciato in cui gareggia la macchina.
	 * @return restituisce il tracciato in cui gareggia la macchina.
	 */
	Track<L,S> getTrack();

	/**
	 * Metodo che permette di muovere la macchina.
	 * @param l destinazione della macchina.
	 */
	void moveUp(L l);

	/**
	 * Metodo che ritorna l'ultima posizione percorsa dalla macchina.
	 * @return l'ultima posizione percorsa dalla macchina.
	 */
	L getLastCheckPoint();

	/**
	 * Metodo che ritorna la posizione di una macchina.
	 * @return posizione nel circuito di una macchina.
	 */
	L getLocation();

	/**
	 * Metodo che setta la posizione della macchina.
	 * @param l nuovo punto
	 */
	void setLocation(L l);

	/**
	 * Metodo che restituisce il vettore che indica
	 * lo spostamento destra-sinistra e lo spostamento alto-basso della macchina.
	 * @return il vettore.
	 */
	L getVector();

	/**
	 * Metodo che restituisce tutto il percorso che ha fatto la macchina.
	 * @return il percorso che ha fatto la macchina.
	 */
	List<L> getPath();

	/**
	 * Metodo che ritorna lo stato di una macchina in un certo momento.
	 * @return stato della macchina.
	 */
	S getStatus();

	/**
	 * Metodo che setta lo stato della macchina.
	 */
	void setStatus(S status);

	/**
	 * Metodo che restituisce il colore della macchina.
	 * @return il colore della macchina.
	 */
	Color getColor();

	/**
	 * Metodo che controlla se la macchina ha colpito dei muri.
	 * @return true se la macchina ha colpito muri, false altrimenti.
	 */
	boolean hitsWall();
}