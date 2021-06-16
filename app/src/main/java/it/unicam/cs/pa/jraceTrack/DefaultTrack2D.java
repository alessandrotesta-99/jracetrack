package it.unicam.cs.pa.jraceTrack;

import java.util.*;

public class DefaultTrack2D<L extends Point2D, S extends DefaultStateCar> implements Track<Point2D, DefaultStateCar> {

    private final Map<Car<Point2D, DefaultStateCar>, Point2D> track;
    private final List<Point2D> walls;
    private int width;
    private final List<Point2D> start;
    private final List<Point2D> finish;

    /**
     * Costruttore che crea un circuito con punti per indicare la linea di partenza, di arrivo e i muri.
     * @param start punti che indicano la linea di partenza.
     * @param finish punti che indicano la linea di arrivo.
     * @param walls punti che indicano i muri del circuito.
     */
    public DefaultTrack2D(List<Point2D> start, List<Point2D> finish,
                          Point2D... walls) {
        this.walls = new LinkedList<>();
        this.track = new HashMap<>();
        Arrays.stream(walls).sequential().forEach(w -> new Point2D(w.getX(), w.getY()));
        Arrays.stream(walls).sequential().forEach(this::addWall);
        this.start = new ArrayList<>(start);
        this.finish = new ArrayList<>(finish);
        //todo aggiungere controllo: non permettere di aggiungere in start e finish muri che non sono nel circuito.
        this.isValidStartFinish();
        this.isValidTrack();
    }

    @Override
    public List<Car<Point2D, DefaultStateCar>> getCars() {
        return new ArrayList<>(this.track.keySet());
    }

    @Override
    public Car<Point2D, DefaultStateCar> getCarAt(Point2D location) {
        return this.track.keySet().stream().filter(p -> p.getLocation().equals(location)).findFirst().orElse(null);
    }

    @Override
    public Track<Point2D, DefaultStateCar> apply(Point2D l, Rule r) {
        //todo
        this.track.replace(this.getCarAt(l), l);
        return null;
    }

    @Override
    public List<Point2D> getStart() {
        return this.start;
    }

    @Override
    public List<Point2D> getFinish() {
        return this.finish;
    }

    @Override
    public void addCar(Car<Point2D, DefaultStateCar> c) {
        this.track.putIfAbsent(c, c.getLocation());
    }

    @Override
    public Set<Point2D> getNextLocs(Car<Point2D, DefaultStateCar> c) {
        return c.getLocation().getNextLocations(c, width);
    }

    @Override
    public List<Point2D> getWalls() {
        return walls;
    }

    @Override
    public void addWall(Point2D position) {
        this.walls.add(position);
    }

    @Override
    public DefaultStateCar getStatus(Car<Point2D, DefaultStateCar> c) {
        return c.getStatus();
    }

    @Override
    public void isValidTrack() {
        if (this.width < 2)
            throw new IllegalArgumentException("ERROR: The width is invalid.");
    }

    /**
     * Metodo che controlla se il punto di partenza e di arrivo sono validi.
     */
    private void isValidStartFinish() {
        if(this.isCircle()){
            if(!this.isValidVertical(start) && !this.isValidHorizontal(start))
                throw new IllegalArgumentException("ERROR: the start or finish is invalid.");
        }
        else{
            if(!(this.isValidHorizontal(start) & this.isValidVertical(finish))
                    & !(this.isValidVertical(start) & this.isValidHorizontal(finish))
                    & !(this.isValidHorizontal(start) & this.isValidHorizontal(finish))
                    & !(this.isValidVertical(start) & this.isValidVertical(finish)))
                throw new IllegalArgumentException("ERROR: the start or finish is invalid.");
        }
    }

    /**
     * Metodo che restituisce true se la linea di partenza o di arrivo è orizzontale e setta la larghezza.
     * @return true se la linea di partenza o arrivo è orizzontale, false altrimenti.
     */
    private boolean isValidHorizontal(List<Point2D> list) {
        int temp = this.width;
        if (list.get(0).getY() == list.get(1).getY()) {
            this.width = Math.abs(list.get(1).getX() - list.get(0).getX());
            if(temp == 0)
                temp = width;
            return temp == width;
        }
        return false;
    }

    /**
     * Metodo che restituisce true se la linea di partenza o di arrivo è verticale e setta la larghezza.
     * @return true se la linea di partenza o di arrivo è verticale, false altrimenti.
     */
    private boolean isValidVertical(List<Point2D> list) {
        int temp = this.width;
        if (list.get(0).getX() == list.get(1).getX()){
            this.width = Math.abs(list.get(1).getY() - list.get(0).getY());
            if(temp == 0)
                temp = width;
            return temp == width;
        }
        return false;
    }
}
