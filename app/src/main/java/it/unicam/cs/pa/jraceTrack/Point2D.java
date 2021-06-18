package it.unicam.cs.pa.jraceTrack;

import java.util.*;

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
        3. eliminare i punti che non sono nel circuito..
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

    public Set<Point2D> getNextLocations(Car<Point2D, DefaultStateCar> c, int width){
        return c.getVector().getY() == 0 ? this.getFirstNextPoint(c, width) : c.getVector().getY() == 1 ? this.getAdjacentPoints(c, width) : this.getPoints(c, width);
    }

    private Set<Point2D> getPoints(Car<Point2D, DefaultStateCar> c, int width) {
        int distanceX = Math.abs(c.getLastCheckPoint().getX() - c.getLocation().getX());
        int distanceY = Math.abs(c.getLastCheckPoint().getY() - c.getLocation().getY());
        boolean flag = c.getLastCheckPoint().getY() < c.getLocation().getY();
        return c.getVector().getX() == 2 && (flag || c.getLocation().getX() < c.getLastCheckPoint().getX()) ? setPoints(c, distanceX, distanceY, -1, 2) : (c.getVector().getX() == 1 && flag) || c.getVector().getX() == 2
                || (c.getVector().getX() == 1 && !flag) ? setPoints(c, distanceX, distanceY, -2, 1)
                : (c.getVector().getX() == 3 && flag) ? setPoints(c, distanceX, distanceY, 0, 3)
                : (c.getVector().getX() == 3 && !flag) ? setPoints(c, distanceX, distanceY, -2, 1):null;
    }

    private Set<Point2D> setPoints(Car<Point2D, DefaultStateCar> c, int distanceX, int distanceY, int i, int i2) {
        //verticale.
        //todo se riesco aggiungere opzione quando la x è negativa. in teoria ok.
        if (distanceY != c.getVector().getY() || c.getLocation().getY() > c.getLastCheckPoint().getY()) {
            if(distanceX == c.getVector().getY() && c.getLocation().getX() > c.getLastCheckPoint().getX())
                return getNextPoints( c.getVector().getY() - 1, c.getVector().getY() + 2, i, i2);
            else if (distanceY == c.getVector().getY())
                return getNextPoints( i, i2, c.getVector().getY() - 1, c.getVector().getY() + 2);
            else
                return getNextPoints( -c.getVector().getY() - 1, -(c.getVector().getY() - 2), i, i2);
        } else
            return getNextPoints( i, i2, -c.getVector().getY() - 1, -(c.getVector().getY() - 2));
    }

    private Set<Point2D> getFirstNextPoint( Car<Point2D,DefaultStateCar> c, int width) {
        //todo refactoring
        c.getTrack().getStart().forEach(ps -> c.getTrack().getFinish().forEach(pf ->
        {
            if(ps.getX() > pf.getX())
                getNextPoints(-1,0,1,2);
        }));
        //testato e ok ma fare altri test con altre linee di partenza e arrivo. --ok
        if(c.getLocation().getX() > c.getTrack().getStart().get(1).getX())
             return getNextPoints(-1,0,1,2);
        if(c.getLocation().getX() < c.getTrack().getStart().get(1).getX() || c.getLocation().getY() < c.getTrack().getStart().get(1).getY())
             return getNextPoints( 1,2,0,2);
        if(c.getLocation().getY() > c.getTrack().getStart().get(1).getY()) {
            return getNextPoints(1,2,-1,0);
        }
        return null;
    }


    private Set<Point2D> getAdjacentPoints(Car<Point2D, DefaultStateCar> c, int width) {
        if(c.getLocation().getY() - c.getLastCheckPoint().getY() < 0)
            return getNextPoints(-2,1,-2,1);
        else if(c.getLocation().getX() - c.getLastCheckPoint().getX() < 0)
            return getNextPoints(-2,1,0,3);
        else
            return getNextPoints(0,3,0,3);
      //todo  removePointIsLocationCar(c);
    }

    private Set<Point2D> getNextPoints(int x, int x1, int y, int y1) {
        Set<Point2D> points = new HashSet<>(8);
        for (int nx = x; nx < x1; nx++)
            for (int ny = y; ny < y1; ny++)
               points.add(FactoryPoint.createPoint(this.x + nx, this.y + ny));
            return points;
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
