package it.unicam.cs.pa.jraceTrack;

import java.util.*;

public class DefaultTrack2D<L extends Point2D, S extends DefaultStateCar> implements Track<Point2D, DefaultStateCar> {

    private final Map<Car<Point2D, DefaultStateCar>, Point2D> track;
    private final List<Point2D> walls;
    private int width;
    //todo trovare una soluzione migliore
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
        //todo non so se servirà.
    }

    @Override
    public Car<Point2D, DefaultStateCar> getCarAt(Point2D location) {
        return this.track.keySet().stream().filter(p -> p.getLocation().equals(location)).findFirst().orElse(null);
    }

    @Override
    public Track<Point2D, DefaultStateCar> apply(Point2D l, Rule r) {
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
        return c.getLocation().getNextPoint(c, width);
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
            if(!this.isVerticalStart() && !this.isHorizontalStart())
                throw new IllegalArgumentException("ERROR: the start or finish is invalid.");
        }
        else{
            if(!(this.isHorizontalStart() && this.isVerticalFinish())
                    && !(this.isVerticalStart() && this.isHorizontalFinish())
                    && !(this.isHorizontalStart() && this.isHorizontalFinish())
                    && !(this.isVerticalStart() && this.isVerticalFinish()))
                throw new IllegalArgumentException("ERROR: the start or finish is invalid.");
        }
    }

    /**
     * Metodo che restituisce true se la linea di partenza è orizzontale e setta la larghezza.
     * @return true se la linea di partenza è orizzontale, false altrimenti.
     */
    private boolean isHorizontalStart() {
        if (start.get(0).getY() == start.get(1).getY()) {
            this.width = start.get(1).getX() - start.get(0).getX();
            return true;
        }
        return false;
    }

    /**
     * Metodo che restituisce true se la linea di arrivo è orizzontale e setta la larghezza.
     * @return true se la linea di arrivo è orizzontale, false altrimenti.
     */
    private boolean isHorizontalFinish() {
        if (finish.get(0).getY() == finish.get(1).getY()) {
            this.width = finish.get(1).getX() - finish.get(0).getX();
            return true;
        }
        return false;
    }

    /**
     * Metodo che restituisce true se la linea di partenza è verticale e setta la larghezza.
     * @return true se la linea di partenza è verticale, false altrimenti.
     */
    private boolean isVerticalStart() {
        if (start.get(0).getX() == start.get(1).getX()){
            this.width = start.get(1).getY() - start.get(0).getY();
            return true;
        }
        return false;
    }

    /**
     * Metodo che restituisce true se la linea di arrivo è verticale e setta la larghezza.
     * @return true se la linea di arrivo è verticale, false altrimenti.
     */
    private boolean isVerticalFinish() {
        if (finish.get(0).getX() == finish.get(1).getX()){
            this.width = finish.get(1).getY() - finish.get(0).getY();
            return true;
        }
        return false;
    }
}
