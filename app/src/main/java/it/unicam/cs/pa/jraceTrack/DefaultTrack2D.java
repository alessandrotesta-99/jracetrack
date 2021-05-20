package it.unicam.cs.pa.jraceTrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DefaultTrack2D<L> implements Track<LineSegment> {

    private static final int DEFAULT_WIDTH = 20;
    private static final int DEFAULT_LENGTH = 20;
    private final LineSegment[][] track;
    private final List<Car> cars;
    private final List<LineSegment> walls;
    private final int width;
    private final int length;
    private LineSegment a;

    /**
     * Costruttore che crea un circuito con dimensioni di default.
     * todo - aggiungere i muri di default.
     */
    public DefaultTrack2D(){
        this(DEFAULT_WIDTH, DEFAULT_LENGTH);
    }

    /**
     * Costruttore che crea un circuito con una certa lunghezza e una certa larghezza.
     * @param width larghezza del circuito.
     * @param length lunghezza del circuito.
     * todo - aggiungere i muri.
     */
    public DefaultTrack2D(int width, int length) {
        this.isValidTrack(width);
        this.width = width;
        this.length = length;
        this.walls = new ArrayList<>();
        this.cars = new ArrayList<>();
        //todo - un po di dubbi ma penso sia cosi
        this.track = new LineSegment[width][length];
        //aggiungere il numero di macchine????
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public Car getCarAt(LineSegment location) {
        return null;
    }

    @Override
    public Track nextTrack(Rule apply) {
        return null;
    }

    @Override
    public LineSegment getStart() {
        return null;
    }

    @Override
    public LineSegment getFinish() {
        return null;
    }

    @Override
    public Set<LineSegment> getNextLocs(Car c) {
        return null;
    }

    @Override
    public List<LineSegment> getWalls() {
        return walls;
    }

    @Override
    public void addWall(LineSegment wall) {
    }

    private void isValidTrack(int width){
        if(width < 2)
            throw new IllegalArgumentException("ERROR: The track is invalid.");
    }
}
