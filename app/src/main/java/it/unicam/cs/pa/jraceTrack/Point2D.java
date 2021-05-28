package it.unicam.cs.pa.jraceTrack;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Classe che ha la responsabilit&agrave; di specificare, nel circuito 2D, un punto nel piano.
 * Un oggetto Point2D pu&ograve; indicare: i bordi del circuito, i punti che rappresentano il punto di
 * partenza e il punto di arrivo, e tutto il cammino percorso dalla macchina in gara.
 * Questa classe non pu&ograve; essere estesa da altre classi. Nel caso si volesse implementare un diverso modo
 * di locazione, creare una nuova classe.
 */
public final class Point2D {

    private final int x;
    private final int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Set<Point2D> getNextPoint(int width, int length){
        //TODO aggiungere controlli e i punti sono all'interno del circuito.
        Set<Point2D> points = new HashSet<>(8);
        for(int nx=1; nx<4; nx++){
           for(int ny=-1; ny<2; ny++){
               points.add(new Point2D(this.x + nx, this.y + ny));
           }
        }
        return points;
        //spostarsi sull asse x di un numero uguale a:
        // 1. freni, quindi: (lunghezza segmento tra punto corrente e punto corrente -1) - 1.
        //2. accelleri, quindi: (lunghezza segmento tra punto corrente e punto corrente -1) + 1.
        //3. rimani alla stessa velocita, quindi:  (lunghezza segmento tra punto corrente e punto corrente -1) + 0.

        //spostarsi sull asse y di un numero uguale a:
        //1. freni, quindi:  (lunghezza segmento tra punto corrente e punto corrente -1) + 1 o +2 o +3.
        //2. accelleri, quindi:  (lunghezza segmento tra punto corrente e punto corrente -1) +1 o +2 o +3.
        //3. rimani alla stessa velocita, quindi:  (lunghezza segmento tra punto corrente e punto corrente -1) +1 o +2 o +3.

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point = (Point2D) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
