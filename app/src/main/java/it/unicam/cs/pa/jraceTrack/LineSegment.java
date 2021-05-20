package it.unicam.cs.pa.jraceTrack;

import java.util.List;

/**
 * Classe che ha la responsabilit&agrave; di specificare, nel circuito 2D, le locazioni nel piano.
 * Un oggetto LineSegment può indicare: i bordi del circuito, la linea di arrivo e di inizio, e tutto il
 * cammino percorso dalla macchina in gara.
 * Questa classe non pu&ograve; essere estesa da altre classi. Nel caso si volesse implementare un diverso modo
 * di locazione, creare una nuova classe.
 */
public final class LineSegment {

    private final int x;
    private final int y;

    public LineSegment(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<LineSegment> getAdjacentLineSegmentAt(int x, int y){
        return null;
    }

}
