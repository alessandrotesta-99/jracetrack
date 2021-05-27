package it.unicam.cs.pa.jraceTrack;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

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

    public Set<Point2D> getAdjacentPoint(int width, int length){
     /*   Set<Point2D> points = new HashSet<>(8);
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                points.add(new Point2D(this.x + i, this.y + j)) ;
            }
        }
        return points;

      */
        Set<Point2D> points = new HashSet<>(8);
        //spostarsi sull asse x di un numero uguale a:
        // 1. freni, quindi: (lunghezza segmento tra punto corrente e punto corrente -1) - 1.
        //2. accelleri, quindi: (lunghezza segmento tra punto corrente e punto corrente -1) + 1.
        //3. rimani alla stessa velocita, quindi:  (lunghezza segmento tra punto corrente e punto corrente -1) + 0.

        //spostarsi sull asse y di un numero uguale a:
        //1. freni, quindi:  (lunghezza segmento tra punto corrente e punto corrente -1) + 1 o +2 o +3.
        //2. accelleri, quindi:  (lunghezza segmento tra punto corrente e punto corrente -1) +1 o +2 o +3.
        //3. rimani alla stessa velocita, quindi:  (lunghezza segmento tra punto corrente e punto corrente -1) +1 o +2 o +3.

        return null;
    }

    private Optional<Point2D> above(int width, int height) {
        return adjacent(width,height,+1,0);
    }

    private Optional<Point2D> adjacent(int width, int height, int nx, int ny) {
        int newX = x+nx;
        int newY = y+ny;
        //TODO controllare se il nuovo punto è dentro al circuito. TESTARE!!!!
        if ((0<= newX)&&((newX<height)||(newX<width))&&(0<=newY)&&(newY<width)) {
            return Optional.of(new Point2D(newX, newY));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean equals(Object o) {
   //     if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point = (Point2D) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
