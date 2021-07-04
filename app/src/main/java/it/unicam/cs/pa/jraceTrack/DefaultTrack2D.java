package it.unicam.cs.pa.jraceTrack;

import java.util.*;
import java.util.stream.Collectors;

public class DefaultTrack2D<L extends Location<? extends L>> implements Track<TrackLocation2D> {

    private final Map<Car<TrackLocation2D>, TrackLocation2D> mapTrack;
    private final List<TrackLocation2D> walls;
    private final List<TrackLocation2D> start;
    private final List<TrackLocation2D> finish;
    private int width;

    /**
     * Costruttore che crea un circuito con punti per indicare la linea di partenza, di arrivo e i muri.
     * @param start punti che indicano la linea di partenza.
     * @param finish punti che indicano la linea di arrivo.
     * @param walls punti che indicano i muri del circuito.
     */
    public DefaultTrack2D(List<TrackLocation2D> start, List<TrackLocation2D> finish, TrackLocation2D... walls) {
        this.mapTrack = new HashMap<>();
        this.start = start;
        this.finish = finish;
        this.walls = new ArrayList<>();
        Arrays.stream(walls).sequential().forEach(w -> new TrackLocation2D(w.getX(), w.getY()));
        Arrays.stream(walls).sequential().forEach(this::addWall);
        this.isValidStartFinish();
        this.isValidTrack();
    }

    @Override
    public List<Car<TrackLocation2D>> getCars(){
        return new ArrayList<>(mapTrack.keySet());
    }

    public Car<TrackLocation2D> getCarAt(TrackLocation2D location){
        Objects.requireNonNull(location);
        return this.mapTrack.keySet()
                .stream()
                .filter(p -> p.getLocation().equals(location))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<TrackLocation2D> getStart() {
        return start;
    }

    @Override
    public List<TrackLocation2D> getFinish() {
        return finish;
    }

    public void addCar(Car<TrackLocation2D> c){
        if(this.getCars().contains(c))
            this.mapTrack.entrySet()
                .stream()
                .filter(car -> car.getKey().equals(c))
                .forEach(ca -> ca.setValue(c.getLocation()));
        else
            this.mapTrack.putIfAbsent(c, c.getLocation());
    }

    @Override
    public Car<TrackLocation2D> createCar() {
        Car<TrackLocation2D> c = new DefaultCar<>(this);
        c.setLocation(initLocationCar());
        return c;
    }

    private TrackLocation2D initLocationCar() {
        TrackLocation2D pos;
        TrackLocation2D randomElement = this.getStart().get(new Random().nextInt(this.getStart().size()));
        pos = (TrackLocation2D) FactoryLocation.createPoint(randomElement.getX(),randomElement.getY());
        while (getCarAt(pos) != null)
            pos = new TrackLocation2D(randomElement.getX(), randomElement.getY());
        return pos;
    }

    @Override
    public Set<TrackLocation2D> getNextLocs(Car<TrackLocation2D> c) {
        Objects.requireNonNull(c);
        return c.getLocation().getNextLocations(c); //todo
    }

    @Override
    public List<TrackLocation2D> getWalls() {
        return walls;
    }

    @Override
    public void addWall(TrackLocation2D position) {
        walls.add(position);
    }

    @Override
    public DefaultStateCar getStatusAt(TrackLocation2D loc){
        Objects.requireNonNull(loc);
        return this.mapTrack.keySet()
                .stream()
                .filter(c -> c.getLocation().equals(loc))
                .map(Car::getStatus)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<DefaultStateCar> getStatusCars() {
        return this.getCars().stream().map(Car::getStatus).collect(Collectors.toList());
    }

    @Override
    public void isValidTrack() {
        if (this.width < 2)
            throw new IllegalArgumentException("ERROR: The width is invalid.");
    }

    @Override
    public boolean isGameOver() {
        return getStatusCars().stream().anyMatch(s -> s.equals(DefaultStateCar.CRASHED));
    }

    /**
     * Metodo che controlla se il punto di partenza e di arrivo sono validi.
     */
    private void isValidStartFinish() {
    //    start.removeIf(p -> !this.getWalls().contains(p) && finish.removeIf(p1 -> !this.getWalls().contains(p1))); todo
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
    private boolean isValidHorizontal(List<TrackLocation2D> list) {
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
    private boolean isValidVertical(List<TrackLocation2D> list) {
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
