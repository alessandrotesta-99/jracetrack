package it.unicam.cs.pa.jraceTrack;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/**
 * Classe che ha la responsabilit&agrave; di specificare, nel circuito 2D, un punto nel piano.
 * Un oggetto Point2D pu&ograve; indicare: i bordi del circuito, i punti che rappresentano il punto di
 * partenza e il punto di arrivo, e tutto il cammino percorso dalla macchina in gara.
 * Questa classe non pu&ograve; essere estesa da altre classi. Nel caso si volesse implementare un diverso modo
 * di locazione, creare una nuova classe.
 */
public final class Point2D {

    private  int x;
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

    public Set<Point2D> getNextPoint(Car<Point2D, DefaultStateCar> c, int width){
        //TODO aggiungere controlli se i punti sono all'interno del circuito.
        Set<Point2D> points = new HashSet<>(8);
        //--ok
        if(c.getVector().getY() == 0)
           return this.getFirstNextPoint();
        //--ok
        if(c.getVector().getY() == 1)
            return this.getAdjacentPoints();
        //todo
        //--no (ok il primo for, da controllare il secondo)
        if(c.getVector().getX() == 3){
            for(int nx=c.getVector().getY()-1; nx<c.getVector().getY()+2; nx++)
                for(int ny=c.getVector().getY()-1; ny<c.getVector().getY()+2; ny++)
                    points.add(new Point2D(this.x + nx, this.y + ny));
            }
        else if(c.getVector().getX() == 2){
        }
        else


        for(int nx=1; nx<4; nx++){
           for(int ny=-1; ny<2; ny++){
               points.add(new Point2D(this.x + nx, this.y + ny));
           }
        }
        return points;

    }

    private Set<Point2D> getFirstNextPoint() {
        //todo refactoring
        Set<Point2D> points = new HashSet<>(8);
        for (int nx = 1; nx < 3; nx++) {
            for (int ny = 1; ny < 3; ny++) {
                points.add(new Point2D(this.x + nx, this.y + ny));
            }
        }
        return points;
    }

    private Set<Point2D> getAdjacentPoints() {
        //todo refactoring
        Set<Point2D> points = new HashSet<>(8);
        for (int nx = 0; nx < 3; nx++) {
            for (int ny = 0; ny < 3; ny++) {
                points.add(new Point2D(this.x + nx, this.y + ny));
            }
        }
        return points;
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

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                "}";
    }
}
