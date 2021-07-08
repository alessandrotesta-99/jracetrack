package it.unicam.cs.pa.jraceTrack;

public class MyFactoryLocation implements FactoryLocation<TrackLocation2D>{

    private static MyFactoryLocation instance;

    private MyFactoryLocation(){ }

    public static MyFactoryLocation getInstance(){
        if(instance == null)
            instance = new MyFactoryLocation();
        return instance;
    }

    @Override
    public TrackLocation2D createLocation(int... values) {
        return new TrackLocation2D(values[0], values[1]);
    }
}
