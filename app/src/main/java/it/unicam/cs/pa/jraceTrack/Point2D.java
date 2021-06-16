package it.unicam.cs.pa.jraceTrack;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Classe che ha la responsabilit&agrave; di specificare, nel circuito 2D, un punto nel piano.
 * Un oggetto Point2D pu&ograve; indicare: i bordi del circuito, i punti che rappresentano il punto di
 * partenza e il punto di arrivo, e tutto il cammino percorso dalla macchina in gara.
 * Questa classe non pu&ograve; essere estesa da altre classi. Nel caso si volesse implementare un diverso modo
 * di locazione, creare una nuova classe.
 */
public final class Point2D {

    /*todo:
        problemi:
        1. dopo il primo turno non vengono mostrati i corretti punti.
        3. eliminare i punti che non sono nel circuito.
        4. cambiare le liste con una vista, in modo da non dover creare una lista.
        ok:
        1. al primo turno vengono mostrati i punti giusti ma gestire l'orientamento e i muri.
        2. gestire l'orientamento, se in senso antiorario o orario.
     */

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
        Set<Point2D> points = new HashSet<>(8);
        //--ok.
        if(c.getVector().getY() == 0)
           return this.getFirstNextPoint(c, points, width);
        //--ok
        if(c.getVector().getY() == 1)
            return this.getAdjacentPoints(c,points, width);
        //--ok.
        else
            return getPoints(c, points,width);
    }
    /*
    TODO: i prossimi punti a quello in cui è la macchina devono essere disegnati nella stessa direzione di dove è la macchina.
     Se una macchina ha un vettore con X settato a 1,
      i prossimi punti dovranno essere ricostruiti partendo dalla posizione di 1.
     Se una macchina ha un vettore con X settato a 3,
      allora i prossimi punti saranno costruiti in diagonale destra,
     Se una macchina ha un vettore con X settato a 2
      allora i prossimi punti saranno costruiti al centro davanti (distanti di tanto quanto la velocita).

     */

    private Set<Point2D> getPoints(Car<Point2D, DefaultStateCar> c, Set<Point2D> points, int width) {
        int distanceX = Math.abs(c.getLastCheckPoint().getX() - c.getLocation().getX());
        int distanceY = Math.abs(c.getLastCheckPoint().getY() - c.getLocation().getY());
        boolean flag = c.getLastCheckPoint().getY() <= c.getLocation().getY();
        if(c.getVector().getX() == 2 && flag)
            setPoints(c, points, distanceX, distanceY, -1,2);
        else if ((c.getVector().getX() != 1 || !flag)
                && c.getVector().getX() != 2 && (c.getVector().getX() != 1 || flag)) {
            if(c.getVector().getX() == 3)
                setPoints(c,points,distanceX,distanceY,0,3);
        }else
            setPoints(c,points,distanceX,distanceY, -2,1);
        return points;
    }

    private void setPoints(Car<Point2D, DefaultStateCar> c, Set<Point2D> points, int distanceX, int distanceY, int i, int i2) {
        //verticale.
        if(distanceY == c.getVector().getY() && c.getLocation().getY() <= c.getLastCheckPoint().getY())
            getNextPoints(points, i, i2, -c.getVector().getY() - 1, -(c.getVector().getY() - 2));
        else if(distanceX == c.getVector().getY() && c.getLocation().getX() > c.getLastCheckPoint().getX())
            getNextPoints(points, c.getVector().getY() - 1, c.getVector().getY() + 2, i, i2);
        //verticale.
        else if (distanceY == c.getVector().getY())
            getNextPoints(points, i, i2, c.getVector().getY() - 1, c.getVector().getY() + 2);

    }

    private Set<Point2D> getFirstNextPoint( Car<Point2D,DefaultStateCar> c, Set<Point2D> points, int width) {
        c.getTrack().getStart().forEach(ps -> c.getTrack().getFinish().forEach(pf ->
        {
            if(ps.getX() > pf.getX())
                getNextPoints(points, -1,0,1,2);
        }));
        //todo refactoring ?
        //testato e ok ma fare altri test con altre linee di partenza e arrivo. --ok
        if(c.getLocation().getX() > c.getTrack().getStart().get(1).getX())
           getNextPoints(points, -1,0,1,2);
        else if(c.getLocation().getX() < c.getTrack().getStart().get(1).getX() || c.getLocation().getY() < c.getTrack().getStart().get(1).getY())
            getNextPoints(points, 1,2,0,2);
        else if(c.getLocation().getY() > c.getTrack().getStart().get(1).getY())
            getNextPoints(points, 1,2,-1,0);
        return points;
    }

    private Set<Point2D> getAdjacentPoints(Car<Point2D, DefaultStateCar> c, Set<Point2D> points, int width) {
        if(c.getLocation().getY() - c.getLastCheckPoint().getY() < 0)
            getNextPoints(points,-2,1,-2,1);
        else
            getNextPoints(points,0,3,0,3);
        removePointIsLocationCar(c, points);
        return points;
    }

    private void isValidPoints(Set<Point2D> points, Track<Point2D, DefaultStateCar> t, int width) {
        //se è il primo turno

        //elimina i punti che toccano un punto specifico del muro.
        // --ok solo se c'è un punto per ogni angolo. se un segmento ha solo due punti not ok.
        t.getWalls().forEach(w -> points.removeIf(p -> w.getX() == p.getX() || w.getY() == p.getY()));

        //   points.removeIf(p -> p.getX()<=0 && p.getX() > width || p.getY() <= 0 && p.getY() > width);
        //todo 1. eliminare i punti che escono dal circuito.



        //todo 2. eliminare i punti che sono in linea con il muro.

    }

    private void getNextPoints(Set<Point2D> points, int x, int x1, int y, int y1) {
        for (int nx = x; nx < x1; nx++)
            for (int ny = y; ny < y1; ny++)
                points.add(FactoryPoint.createPoint(this.x + nx, this.y + ny));
    }

    /**
     * Metodo che permette di eliminare dai prossimi punti, il punto dove si trova ora la macchina.
     * @param c la macchina.
     * @param points i prossimi punti.
     */
    private void removePointIsLocationCar(Car<Point2D, DefaultStateCar> c, Set<Point2D> points) {
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
