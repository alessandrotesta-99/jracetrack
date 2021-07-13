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
     * Metodo che aggiunge una macchina al circuito.
     * @param track il circuito a cui aggiungere la macchina.
     * @param car macchina da aggiungere.
     * @param color colore della macchina.
     */
    void addCar(Track<L> track, Car<L> car, Color color); //todo ne ho bisogno solo per il colore.

    /**
     * Metodo che rimuove la macchina dalla gara.
     * @param car la macchina da eliminare.
     */
    void removeCar(Car<L> car);

    /**
     * Metodo che aggiunge un giocatore alla gara.
     * @param player giocatore da aggiungere.
     */
    void addPlayer(Player<L> player);  //todo potrei non aver bisogno perche carico tutto da file.

    /**
     * Metodo che rimuove un giocatore dalla gara.
     * @param player il giocatore da rimuovere.
     */
    void removePlayer(Player<L> player); //todo idem sopra.

    /**
     * Metodo che setta il giocatore vincitore.
     * @param player il giocatore vincitore.
     */
    void setWinnerPlayer(Player<L> player);

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
     * Metodo che verifica se la macchina è ancora in gara.
     * @return true se la macchina è in gara, false altrimenti.
     */
    boolean isGameOver();

    /**
     * Metodo che permette di muovere la macchina.
     * @param loc prossima locazione dove posizionare la macchina.
     * @param player giocatore che muove la macchina.
     */
    void moveUp(L loc, Player<L> player);

    /**
     * Metodo che ritorna una macchina ad una certa posizione se la macchina esiste.
     * @param loc la posione
     * @return la macchina ad una certa posizione o null.
     */
    Car<L> getCarAt(L loc); //todo non penso che servirà

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
     * Metodo che ritorna la rappresentazione in stringa di una coordinata.
     * @param i la coordinata.
     * @return la rappresentazione in stringa di una coordinata.
     */
    String getRepresentation(int i);

    Race<L> getRace();

    /**
     * Metodo che restituisce tutto il percorso di una macchina.
     * @param car macchina.
     * @return il percorso di una macchina.
     */
    List<L> getCarPath(Car<L> car);
}
