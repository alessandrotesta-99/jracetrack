
package it.unicam.cs.pa.jraceTrack;

import it.unicam.cs.pa.jraceTrack.Model.Location.DefaultLocation;
import it.unicam.cs.pa.jraceTrack.View.ConsoleView;
import it.unicam.cs.pa.jraceTrack.View.View;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        View<DefaultLocation> view = new ConsoleView();
        view.open();
        view.close();
    }
}
