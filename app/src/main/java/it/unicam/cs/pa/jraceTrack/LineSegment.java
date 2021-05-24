package it.unicam.cs.pa.jraceTrack;

/**
 * Classe che rappresenta un oggetto che dovrebbe unire due punti. Da vedere perche potrebbe essere
 * una cosa grafica e basta.
 */
public final class LineSegment {

    private final Point2D startSegment;
    private final Point2D finishSegment;

    public LineSegment(Point2D startSegment, Point2D finishSegment) {
        this.startSegment = startSegment;
        this.finishSegment = finishSegment;
    }

    public Point2D getStartSegment() {
        return startSegment;
    }

    public Point2D getFinishSegment() {
        return finishSegment;
    }
}
