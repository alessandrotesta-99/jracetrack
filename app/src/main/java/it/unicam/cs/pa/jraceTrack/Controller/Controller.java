package it.unicam.cs.pa.jraceTrack.Controller;

import it.unicam.cs.pa.jraceTrack.Model.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Interfaccia che rappresenta il Controller del patter MVC.
 */
public interface Controller<L extends Location<L>> {

    /**
     * Metodo che da il via ad una gara.
     */
    void newGame();

    /**
     * Metodo che fa terminare la gara.
     */
    void finish();


    /**
     * Metodo che verifica se la gara è finita o no.
     * @return true se la gara non è finita, false altrimenti.
     */
    boolean isStart();

    /**
     * Metodo che mostra la lista di tutti i giocatori.
     * @return tutti i giocatori in gara.
     */
    List<Player<L>> getPlayers();

    /**
     * Metodo che restituisce il tracciato di gara.
     * @return il tracciato.
     */
    Track<L> getTrack();

    /**
     * Metodo che mostra la lista di tutte le macchine nel circuito.
     * @param track circuito dove si trovano le macchine.
     * @return tutte le macchine nel circuito.
     */
    List<Car<L>> getCars(Track<L> track);

    /**
     * Metodo che setta il giocatore vincitore da una lista di giocatori.
     * @param players la lista di giocatori.
     */
    void setWinnerPlayer(List<Player<L>> players);

    /**
     * Metodo che ritorna il giocatore vincitore della gara.
     * @return il giocatore vincitore.
     */
    Player<L> getWinner();

    /**
     * Metodo che ritorna lo stato di tutte le macchine che ci sono in gara.
     * @return lo stato di tutte le macchine.
     */
    List<DefaultStateCar> getStatusCars();

    /**
     * Metodo che ritorna lo stato di una macchina ad una certa posizione.
     * @param loc posizione da controllare.
     * @return stato della macchina.
     */
    DefaultStateCar getStatus(L loc);

    /**
     * Metodo che permette di muovere la macchina.
     * @param loc prossima locazione dove posizionare la macchina.
     * @param player giocatore che muove la macchina.
     */
    void moveUp(L loc, Player<L> player);

    /**
     * Metodo che restituisce le prossime locazioni dove poter andare.
     * @param loc la poszione corrente della macchina.
     * @return un set di locazioni dove può andare la macchina.
     */
    Set<L> getNextLocs(L loc);

    /**
     * Metodo che restituisce il turno del giocatore.
     * @param player il giocatore.
     * @return il turno del giocatore.
     */
    int getTurnPlayer(Player<L> player);

    /**
     * Metodo che permette di aggiungere un circuito da un file.
     */
    void loadTrack() throws IOException;

    /**
     * Metodo che permette di aggiungere un set di giocatori da file.
     */
    void loadPlayers() throws IOException;

    /**
     * Metodo che restituisce la gara.
     * @return la gara.
     */
    Race<L> getRace();

    /**
     * Metodo che restituisce tutto il percorso di una macchina.
     * @param car macchina.
     * @return il percorso di una macchina.
     */
    List<L> getCarPath(Car<L> car);
}
