package it.unicam.cs.pa.jraceTrack;

import it.unicam.cs.pa.jraceTrack.Model.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultRaceTest{

    Race<TrackLocation2D> race = new DefaultRace<>();

    @Test
    public void testGetPlayers() {
        getDefaultTrack();
        race.createPlayer(TypePlayer.BOT);
        race.createPlayer(TypePlayer.BOT);
        assertEquals(2, race.getPlayers().size());
        assertEquals(2, race.getPlayers().stream().filter(p -> p.getCar() != null).count());
    }

    private Track<TrackLocation2D> getDefaultTrack() {
        List<TrackLocation2D> walls = new ArrayList<>();
        List<TrackLocation2D> start = new ArrayList<>();
        List<TrackLocation2D> finish = new ArrayList<>();
        createWalls(walls);
        createStart(start);
        createFinish(finish);
        race.createTrack(start, finish, walls);
        return race.getTrack();
    }

    private void createFinish(List<TrackLocation2D> finish) {
        finish.add(new TrackLocation2D(1, 8));
        finish.add(new TrackLocation2D(2, 8));
        finish.add(new TrackLocation2D(3, 8));
        finish.add(new TrackLocation2D(4, 8));
        finish.add(new TrackLocation2D(5, 8));
    }

    private void createStart(List<TrackLocation2D> start) {
        start.add(new TrackLocation2D(1, 9));
        start.add(new TrackLocation2D(2, 9));
        start.add(new TrackLocation2D(3, 9));
        start.add(new TrackLocation2D(4, 9));
        start.add(new TrackLocation2D(5, 9));
    }

    private void createWalls(List<TrackLocation2D> walls) {
        walls.add(new TrackLocation2D(1, 1));
        walls.add(new TrackLocation2D(1, 2));
        walls.add(new TrackLocation2D(6, 5));
        walls.add(new TrackLocation2D(1, 3));
        walls.add(new TrackLocation2D(1, 4));
        walls.add(new TrackLocation2D(1, 5));
        walls.add(new TrackLocation2D(1, 6));
        walls.add(new TrackLocation2D(1, 7));
        walls.add(new TrackLocation2D(1, 8));
        walls.add(new TrackLocation2D(1, 9));
        walls.add(new TrackLocation2D(1, 10));
        walls.add(new TrackLocation2D(1, 11));
        walls.add(new TrackLocation2D(1, 12));
        walls.add(new TrackLocation2D(1, 13));
        walls.add(new TrackLocation2D(1, 14));
        walls.add(new TrackLocation2D(1, 15));
        walls.add(new TrackLocation2D(1, 16));
        walls.add(new TrackLocation2D(2, 16));
        walls.add(new TrackLocation2D(3, 16));
        walls.add(new TrackLocation2D(4, 16));
        walls.add(new TrackLocation2D(5, 16));
        walls.add(new TrackLocation2D(6, 16));
        walls.add(new TrackLocation2D(7, 16));
        walls.add(new TrackLocation2D(8, 16));
        walls.add(new TrackLocation2D(9, 16));
        walls.add(new TrackLocation2D(10, 16));
        walls.add(new TrackLocation2D(11, 16));
        walls.add(new TrackLocation2D(12, 16));
        walls.add(new TrackLocation2D(13, 16));
        walls.add(new TrackLocation2D(14, 16));
        walls.add(new TrackLocation2D(15, 16));
        walls.add(new TrackLocation2D(16, 16));
        walls.add(new TrackLocation2D(17, 16));
        walls.add(new TrackLocation2D(18, 16));
        walls.add(new TrackLocation2D(19, 16));
        walls.add(new TrackLocation2D(20, 16));
        walls.add(new TrackLocation2D(20, 15));
        walls.add(new TrackLocation2D(20, 14));
        walls.add(new TrackLocation2D(20, 13));
        walls.add(new TrackLocation2D(20, 12));
        walls.add(new TrackLocation2D(20, 11));
        walls.add(new TrackLocation2D(20, 10));
        walls.add(new TrackLocation2D(20, 9));
        walls.add(new TrackLocation2D(20, 8));
        walls.add(new TrackLocation2D(20, 7));
        walls.add(new TrackLocation2D(20, 6));
        walls.add(new TrackLocation2D(20, 5));
        walls.add(new TrackLocation2D(20, 4));
        walls.add(new TrackLocation2D(20, 3));
        walls.add(new TrackLocation2D(20, 2));
        walls.add(new TrackLocation2D(20, 1));
        walls.add(new TrackLocation2D(19, 1));
        walls.add(new TrackLocation2D(18, 1));
        walls.add(new TrackLocation2D(17, 1));
        walls.add(new TrackLocation2D(16, 1));
        walls.add(new TrackLocation2D(15, 1));
        walls.add(new TrackLocation2D(14, 1));
        walls.add(new TrackLocation2D(13, 1));
        walls.add(new TrackLocation2D(12, 1));
        walls.add(new TrackLocation2D(11, 1));
        walls.add(new TrackLocation2D(10, 1));
        walls.add(new TrackLocation2D(9, 1));
        walls.add(new TrackLocation2D(8, 1));
        walls.add(new TrackLocation2D(7, 1));
        walls.add(new TrackLocation2D(6, 1));
        walls.add(new TrackLocation2D(5, 1));
        walls.add(new TrackLocation2D(4, 1));
        walls.add(new TrackLocation2D(3, 1));
        walls.add(new TrackLocation2D(2, 1));
        walls.add(new TrackLocation2D(5, 5));
        walls.add(new TrackLocation2D(5, 6));
        walls.add(new TrackLocation2D(5, 7));
        walls.add(new TrackLocation2D(5, 8));
        walls.add(new TrackLocation2D(5, 9));
        walls.add(new TrackLocation2D(5, 10));
        walls.add(new TrackLocation2D(5, 11));
        walls.add(new TrackLocation2D(5, 12));
        walls.add(new TrackLocation2D(6, 12));
        walls.add(new TrackLocation2D(7, 12));
        walls.add(new TrackLocation2D(8, 12));
        walls.add(new TrackLocation2D(9, 12));
        walls.add(new TrackLocation2D(10, 12));
        walls.add(new TrackLocation2D(11, 12));
        walls.add(new TrackLocation2D(12, 12));
        walls.add(new TrackLocation2D(13, 12));
        walls.add(new TrackLocation2D(14, 12));
        walls.add(new TrackLocation2D(15, 12));
        walls.add(new TrackLocation2D(16, 11));
        walls.add(new TrackLocation2D(16, 10));
        walls.add(new TrackLocation2D(16, 9));
        walls.add(new TrackLocation2D(16, 8));
        walls.add(new TrackLocation2D(16, 7));
        walls.add(new TrackLocation2D(16, 6));
        walls.add(new TrackLocation2D(16, 5));
        walls.add(new TrackLocation2D(15, 5));
        walls.add(new TrackLocation2D(14, 5));
        walls.add(new TrackLocation2D(13, 5));
        walls.add(new TrackLocation2D(12, 5));
        walls.add(new TrackLocation2D(11, 5));
        walls.add(new TrackLocation2D(10, 5));
        walls.add(new TrackLocation2D(9, 5));
        walls.add(new TrackLocation2D(8, 5));
        walls.add(new TrackLocation2D(7, 5));
    }

    @Test
    public void testCreateTrack() {
        assertNotNull(getDefaultTrack());
    }

    @Test
    public void testSetWinnerPlayer() {
        getDefaultTrack();
        race.createPlayer(TypePlayer.INTERACTIVE);
        race.createPlayer(TypePlayer.INTERACTIVE);
        race.getPlayers().get(0).getCar().setLocation(new TrackLocation2D(2,9));
        race.getPlayers().get(0).setTurn(true);
        race.getPlayers().get(0).moveUp(new TrackLocation2D(2,8));
        race.setWinnerPlayer(race.getPlayers());
        assertSame(race.getWinner(), race.getPlayers().get(0));
    }
}