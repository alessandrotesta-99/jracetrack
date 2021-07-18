package it.unicam.cs.pa.jraceTrack;

import it.unicam.cs.pa.jraceTrack.Model.*;
import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultRaceTest{

    Race<DefaultLocation> race = new DefaultRace();

    @Test
    public void testGetPlayers() {
        getDefaultTrack();
        race.createPlayer(TypePlayer.BOT);
        race.createPlayer(TypePlayer.BOT);
        assertEquals(2, race.getPlayers().size());
        assertEquals(2, race.getPlayers().stream().filter(p -> p.getCar() != null).count());
    }

    private Track<DefaultLocation> getDefaultTrack() {
        List<DefaultLocation> walls = new ArrayList<>();
        List<DefaultLocation> start = new ArrayList<>();
        List<DefaultLocation> finish = new ArrayList<>();
        createWalls(walls);
        createStart(start);
        createFinish(finish);
        race.createTrack(start, finish, walls);
        return race.getTrack();
    }

    private void createFinish(List<DefaultLocation> finish) {
        finish.add(new DefaultLocation(1, 8));
        finish.add(new DefaultLocation(2, 8));
        finish.add(new DefaultLocation(3, 8));
        finish.add(new DefaultLocation(4, 8));
        finish.add(new DefaultLocation(5, 8));
    }

    private void createStart(List<DefaultLocation> start) {
        start.add(new DefaultLocation(1, 9));
        start.add(new DefaultLocation(2, 9));
        start.add(new DefaultLocation(3, 9));
        start.add(new DefaultLocation(4, 9));
        start.add(new DefaultLocation(5, 9));
    }

    private void createWalls(List<DefaultLocation> walls) {
        walls.add(new DefaultLocation(1, 1));
        walls.add(new DefaultLocation(1, 2));
        walls.add(new DefaultLocation(6, 5));
        walls.add(new DefaultLocation(1, 3));
        walls.add(new DefaultLocation(1, 4));
        walls.add(new DefaultLocation(1, 5));
        walls.add(new DefaultLocation(1, 6));
        walls.add(new DefaultLocation(1, 7));
        walls.add(new DefaultLocation(1, 8));
        walls.add(new DefaultLocation(1, 9));
        walls.add(new DefaultLocation(1, 10));
        walls.add(new DefaultLocation(1, 11));
        walls.add(new DefaultLocation(1, 12));
        walls.add(new DefaultLocation(1, 13));
        walls.add(new DefaultLocation(1, 14));
        walls.add(new DefaultLocation(1, 15));
        walls.add(new DefaultLocation(1, 16));
        walls.add(new DefaultLocation(2, 16));
        walls.add(new DefaultLocation(3, 16));
        walls.add(new DefaultLocation(4, 16));
        walls.add(new DefaultLocation(5, 16));
        walls.add(new DefaultLocation(6, 16));
        walls.add(new DefaultLocation(7, 16));
        walls.add(new DefaultLocation(8, 16));
        walls.add(new DefaultLocation(9, 16));
        walls.add(new DefaultLocation(10, 16));
        walls.add(new DefaultLocation(11, 16));
        walls.add(new DefaultLocation(12, 16));
        walls.add(new DefaultLocation(13, 16));
        walls.add(new DefaultLocation(14, 16));
        walls.add(new DefaultLocation(15, 16));
        walls.add(new DefaultLocation(16, 16));
        walls.add(new DefaultLocation(17, 16));
        walls.add(new DefaultLocation(18, 16));
        walls.add(new DefaultLocation(19, 16));
        walls.add(new DefaultLocation(20, 16));
        walls.add(new DefaultLocation(20, 15));
        walls.add(new DefaultLocation(20, 14));
        walls.add(new DefaultLocation(20, 13));
        walls.add(new DefaultLocation(20, 12));
        walls.add(new DefaultLocation(20, 11));
        walls.add(new DefaultLocation(20, 10));
        walls.add(new DefaultLocation(20, 9));
        walls.add(new DefaultLocation(20, 8));
        walls.add(new DefaultLocation(20, 7));
        walls.add(new DefaultLocation(20, 6));
        walls.add(new DefaultLocation(20, 5));
        walls.add(new DefaultLocation(20, 4));
        walls.add(new DefaultLocation(20, 3));
        walls.add(new DefaultLocation(20, 2));
        walls.add(new DefaultLocation(20, 1));
        walls.add(new DefaultLocation(19, 1));
        walls.add(new DefaultLocation(18, 1));
        walls.add(new DefaultLocation(17, 1));
        walls.add(new DefaultLocation(16, 1));
        walls.add(new DefaultLocation(15, 1));
        walls.add(new DefaultLocation(14, 1));
        walls.add(new DefaultLocation(13, 1));
        walls.add(new DefaultLocation(12, 1));
        walls.add(new DefaultLocation(11, 1));
        walls.add(new DefaultLocation(10, 1));
        walls.add(new DefaultLocation(9, 1));
        walls.add(new DefaultLocation(8, 1));
        walls.add(new DefaultLocation(7, 1));
        walls.add(new DefaultLocation(6, 1));
        walls.add(new DefaultLocation(5, 1));
        walls.add(new DefaultLocation(4, 1));
        walls.add(new DefaultLocation(3, 1));
        walls.add(new DefaultLocation(2, 1));
        walls.add(new DefaultLocation(5, 5));
        walls.add(new DefaultLocation(5, 6));
        walls.add(new DefaultLocation(5, 7));
        walls.add(new DefaultLocation(5, 8));
        walls.add(new DefaultLocation(5, 9));
        walls.add(new DefaultLocation(5, 10));
        walls.add(new DefaultLocation(5, 11));
        walls.add(new DefaultLocation(5, 12));
        walls.add(new DefaultLocation(6, 12));
        walls.add(new DefaultLocation(7, 12));
        walls.add(new DefaultLocation(8, 12));
        walls.add(new DefaultLocation(9, 12));
        walls.add(new DefaultLocation(10, 12));
        walls.add(new DefaultLocation(11, 12));
        walls.add(new DefaultLocation(12, 12));
        walls.add(new DefaultLocation(13, 12));
        walls.add(new DefaultLocation(14, 12));
        walls.add(new DefaultLocation(15, 12));
        walls.add(new DefaultLocation(16, 11));
        walls.add(new DefaultLocation(16, 10));
        walls.add(new DefaultLocation(16, 9));
        walls.add(new DefaultLocation(16, 8));
        walls.add(new DefaultLocation(16, 7));
        walls.add(new DefaultLocation(16, 6));
        walls.add(new DefaultLocation(16, 5));
        walls.add(new DefaultLocation(15, 5));
        walls.add(new DefaultLocation(14, 5));
        walls.add(new DefaultLocation(13, 5));
        walls.add(new DefaultLocation(12, 5));
        walls.add(new DefaultLocation(11, 5));
        walls.add(new DefaultLocation(10, 5));
        walls.add(new DefaultLocation(9, 5));
        walls.add(new DefaultLocation(8, 5));
        walls.add(new DefaultLocation(7, 5));
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
        race.getPlayers().get(0).getCar().setLocation(new DefaultLocation(2,9));
        race.getPlayers().get(0).setTurn(true);
        race.getPlayers().get(0).moveUp(new DefaultLocation(2,8));
        race.setWinnerPlayer(race.getPlayers());
        assertSame(race.getWinner(), race.getPlayers().get(0));
    }
}