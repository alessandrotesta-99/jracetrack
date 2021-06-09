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

    //TODO cambiare le liste con una vista, in modo da non dover creare una lista.

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

    public Set<Point2D> getNextPoint(Car<Point2D, DefaultStateCar> c, int width){
        //TODO aggiungere controlli se i punti sono all'interno del circuito.
        Set<Point2D> points = new HashSet<>(8);
        //--ok.
        if(c.getVector().getY() == 0)
           return this.getFirstNextPoint(c, points, width);
        //--todo da controllare.
        if(c.getVector().getY() == 1)
            return this.getAdjacentPoints(c,points, width);
        //todo
        //caso 1: accellera
        //--ok
        if(c.getVector().getX() == 3)
            return getPoints(c, points,width);
        //caso 2: rimane stabile
        else if(c.getVector().getX() == 2)
            return this.getAdjacentPoints(c,points,width);
        //caso 3: frena
        else{
            if(c.getVector().getY() > 1)
                return getPoints(c, points,width);
            else
                return this.getAdjacentPoints(c,points,width);
        }
    }

    private Set<Point2D> getPoints(Car<Point2D, DefaultStateCar> c, Set<Point2D> points, int width) {
        getNextPoints(points,c.getVector().getY()-1, c.getVector().getY() + 2,
                c.getVector().getY() - 1, c.getVector().getY() + 2 );
        isValidPoints(points, c.getTrack(), width);
        return points;
    }

    private Set<Point2D> getFirstNextPoint( Car<Point2D,DefaultStateCar> c, Set<Point2D> points, int width) {
        //todo refactoring ?
        //testato e ok ma fare altri test con altre linee di partenza e arrivo. --ok
        if(c.getLocation().getX() > c.getTrack().getStart().get(1).getX())
           getNextPoints(points, -1,0,1,2);
        else if(c.getLocation().getX() < c.getTrack().getStart().get(1).getX() || c.getLocation().getY() < c.getTrack().getStart().get(1).getY())
            getNextPoints(points, 1,2,0,2);
        else if(c.getLocation().getY() > c.getTrack().getStart().get(1).getY())
            getNextPoints(points, 1,2,-1,0);
       // isValidPoints(points, c.getTrack(), width);
        return points;
    }

    private Set<Point2D> getAdjacentPoints(Car<Point2D, DefaultStateCar> c, Set<Point2D> points, int width) {
        getNextPoints(points,0,3,0,3);
        removePointIsLocationCar(c, points);
        isValidPoints(points, c.getTrack(), width);
        return points;
    }

    private void isValidPoints(Set<Point2D> points, Track<Point2D, DefaultStateCar> t, int width) {
        //se è il primo turno

        //elimina i punti che toccano un punto specifico del muro. --ok
        t.getWalls().forEach(w -> points.removeIf(p -> w.getX() == p.getX() || w.getY() == p.getY()));

        //   points.removeIf(p -> p.getX()<=0 && p.getX() > width || p.getY() <= 0 && p.getY() > width);
        //todo 1. eliminare i punti che escono dal circuito.



        //todo 2. eliminare i punti che sono in linea con il muro.

    }

    private void getNextPoints(Set<Point2D> points, int x, int x1, int y, int y1) {
        for (int nx = x; nx < x1; nx++)
            for (int ny = y; ny < y1; ny++)
                points.add(new Point2D(this.x + nx, this.y + ny));
    }

    /**
     * Metodo che permette di eliminare dai prossimi punti, il punto dove si trova ora la macchina.
     * @param c la macchina.
     * @param points i prossimi punti.
     */
    private void removePointIsLocationCar(Car<Point2D, DefaultStateCar> c, Set<Point2D> points) {
        //elimina il punto dove è la macchina in questo momento.
        points.stream().filter(p -> p.equals(c.getLocation())).findFirst().map(points::remove);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
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
