package it.unicam.cs.pa.jraceTrack;

import java.util.LinkedList;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Interfaccia che specifica una macchina ed ha la responsabilita primaria di tener conto delle
 * caratteristiche della macchina e delle azioni.
 * Parametrizzata per stato e locazione, in modo da non dipendere da una singola implementazione.
 * Le classi che implementeranno questa interfaccia avranno la responsabilita di dare
 * un'implementazione per le caratteristiche di questa macchina.
 * @param <L> locazione della macchina.
 * @param <S> stato della macchina.
 */
public interface Car<L, S> {

	/**
	 * Metodo che restituisce il tracciato in cui gareggia la macchina.
	 * @return restituisce il tracciato in cui gareggia la macchina.
	 */
	Track<L,S> getTrack();

	/**
	 * Metodo che restituisce il giocatore associato a questa macchina.
	 * @return restituisce il giocatore associato a questa macchina.
	 */
	Player getPlayer();

	/**
	 * Metodo che permette di accellerare secondo determinate regole ad ogni turno.
	 * @param r regola da applicare nel momento in cui si vuole accellerare.
	 * @return la nuova posizione della macchina.
	 */
	//6 quadretti è la massima velocità.
	L accelerate(Rule r);

	/**
	 * Metodo che permette di frenare secondo determinate regole ad ogni turno.
	 * @param r regola da applicare nel momento in cui si vuole frenare.
	 * @return la nuova posizione della macchina.
	 */
	L brake(Rule r);

	/**
	 * Metodo che permette di muovere la macchina.
	 * @return la nuova posizione della macchina.
	 */
	L moveUp();

	/**
	 * Metodo che ritorna l'ultimo punto percorso dalla macchina.
	 * @return l'ultimo punto percorso dalla macchina.
	 */
	L getLastCheckPoint();

	/**
	 * Metodo che ritorna la posizione di una macchina.
	 * @return posizione nel circuito di una macchina.
	 */
	L getLocation();

	/**
	 * Metodo che restituisce tutto il percorso che ha fatto la macchina.
	 * @return il percorso che ha fatto la macchina.
	 */
	LinkedList<L> getPath();

	/**
	 * Metodo che ritorna lo stato di una macchina in un certo momento.
	 * @return stato della macchina.
	 */
	S getStatus();

	/**
	 * Metodo che restituisce il colore della macchina.
	 * @return il colore della macchina.
	 */
	Color getColor();

	/**
	 * Metodo che restituisce il numero di movimenti che ha compiuto una macchina all'interno del circuito.
	 * @param p predicato da rispettare.
	 * @return il numero di movimenti che ha compiuto una macchina per raggiungere il traguardo.
	 */
	int countMovement(Predicate<? super L> p);

	/**
	 * Metodo che verifica se la macchina ha avuto incidenti.
	 * @return true se la macchina ha avuto un incidente, false altrimenti.
	 */
	boolean isCrashed();

}