package it.unicam.cs.pa.jraceTrack.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DefaultPrinter implements Printer<TrackLocation2D>{



    @Override
    public List<String> getString(int... params) {
        return Arrays.stream(params).mapToObj(Objects::toString).collect(Collectors.toList());
    }
}
