package it.unicam.cs.pa.jraceTrack.Model;

import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;
import it.unicam.cs.pa.jraceTrack.Model.Location.MyFactoryLocation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DefaultTrack implements Track<DefaultLocation> {

    private final Map<Car<DefaultLocation>, DefaultLocation> mapTrack;
    private final List<DefaultLocation> walls;
    private final List<DefaultLocation> start;
    private final List<DefaultLocation> finish;
    private int width;
    private static final Logger logger = Logger.getGlobal();

    /**
     * Costruttore che crea un circuito con punti per indicare la linea di partenza, di arrivo e i muri.
     * @param start punti che indicano la linea di partenza.
     * @param finish punti che indicano la linea di arrivo.
     * @param walls punti che indicano i muri del circuito.
     */
    public DefaultTrack(List<DefaultLocation> start, List<DefaultLocation> finish, List<DefaultLocation> walls) {
        this.mapTrack = new HashMap<>();
        this.start = start;
        this.finish = finish;
        this.walls = walls;
        this.isValidStartFinish();
        this.isValidTrack();
        logger.finest("circuito creato correttamente.");
    }

    @Override
    public List<Car<DefaultLocation>> getCars(){
        return new ArrayList<>(mapTrack.keySet());
    }

    public Car<DefaultLocation> getCarAt(DefaultLocation location){
        Objects.requireNonNull(location);
        return this.mapTrack.keySet()
                .stream()
                .sequential()
                .filter(c -> c.getLocation().equals(location))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<DefaultLocation> getStart() {
        return start;
    }

    @Override
    public List<DefaultLocation> getFinish() {
        return finish;
    }

    public void addCar(Car<DefaultLocation> c){
        if(this.getCars().contains(c))
            this.mapTrack.entrySet()
                .stream()
                .sequential()
                .filter(car -> car.getKey().equals(c))
                .forEach(ca -> ca.setValue(c.getLocation()));
        else
            this.mapTrack.putIfAbsent(c, c.getLocation());
        logger.finest("macchina aggiunta al circuito.");
    }

    @Override
    public Car<DefaultLocation> createCar() {
        Car<DefaultLocation> c = new DefaultCar(this);
        c.setLocation(initLocationCar());
        c.getPath().add(c.getLocation());
        c.setColor(new Color(new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat()));
        return c;
    }

    private DefaultLocation initLocationCar() {
        DefaultLocation pos = getTrackLocation2D();
        while (getCarAt(pos) != null)
            pos = getTrackLocation2D();
        return pos;
    }

    private DefaultLocation getTrackLocation2D() {
        return MyFactoryLocation.getInstance().createLocation(this.getStart().get(generateRandomLocation()).getX(), this.getStart().get(generateRandomLocation()).getY());
    }

    private int generateRandomLocation() {
        return new Random().nextInt(this.getStart().size());
    }

    @Override
    public Set<DefaultLocation> getNextLocs(DefaultLocation loc) {
        Objects.requireNonNull(loc);
        return loc.getNextLocations(getCarAt(loc));
    }

    @Override
    public List<DefaultLocation> getWalls() {
        return walls;
    }

    @Override
    public DefaultStateCar getStatusAt(DefaultLocation loc){
        Objects.requireNonNull(loc);
        return this.mapTrack.keySet()
                .stream()
                .sequential()
                .filter(c -> c.getLocation().equals(loc))
                .map(Car::getStatus)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<DefaultStateCar> getStatusCars() {
        return this.getCars()
                .stream()
                .map(Car::getStatus)
                .collect(Collectors.toList());
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
    private boolean isValidHorizontal(List<DefaultLocation> list) {
        int temp = this.width;
        if (list.get(0).getY() == list.get(list.size() - 1).getY()) {
            this.width = Math.abs(list.get(list.size() - 1).getX() - list.get(0).getX());
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
    private boolean isValidVertical(List<DefaultLocation> list) {
        int temp = this.width;
        if (list.get(0).getX() == list.get(list.size() - 1).getX()){
            this.width = Math.abs(list.get(list.size() - 1).getY() - list.get(0).getY());
            if(temp == 0)
                temp = width;
            return temp == width;
        }
        return false;
    }

    @Override
    public String toString() {
        return "{" +
                "walls=" + walls +
                ",\nstart=" + start +
                ",\nfinish=" + finish +
                ",\nwidth=" + width +
                '}';
    }
}
