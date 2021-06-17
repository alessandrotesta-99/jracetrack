package it.unicam.cs.pa.jraceTrack;

import java.util.Optional;
import java.util.Set;

/**
 * Interfaccia che ha la responsabilita di applicare le regole al gioco.
 * Le classi che implementano questa interfaccia dovranno fornire un implementazione
 * per poter applicare le regole del gioco.
 */
public interface Rule {

	<L> Optional<DefaultStateCar> ottoViciniRules();

	//todo aggiungere le altre regole.



	/**
	 * Metodo che applica una regola al gioco.
	 * @return la regola applicata.
	 */
	Rule apply();

}