package it.unicam.cs.pa.jraceTrack.Model.Location;

/**
 * Classe che definisce un modo per la creazione di un oggetto {@link DefaultLocation} che rappresenta la locazione
 * nel circuito.
 */
public class MyFactoryLocation implements FactoryLocation<DefaultLocation>{

    private static MyFactoryLocation instance;

    private MyFactoryLocation(){ }

    public static MyFactoryLocation getInstance(){
        if(instance == null)
            instance = new MyFactoryLocation();
        return instance;
    }

    @Override
    public DefaultLocation createLocation(int... values) {
        return new DefaultLocation(values[0], values[1]);
    }
}
