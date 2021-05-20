package it.unicam.cs.pa.jraceTrack;

/**
 * Interfaccia che ha la responsabilita di applicare le regole al gioco.
 * Le classi che implementano questa interfaccia dovranno fornire un implementazione
 * per poter applicare le regole del gioco.
 */
public interface Rule {
	/**
	 * Metodo che applica una regola al gioco.
	 * @return la regola applicata.
	 */
	Rule apply();

}