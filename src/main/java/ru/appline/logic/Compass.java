package ru.appline.logic;

import java.util.HashMap;
import java.util.Map;

public class Compass {
    private Map<String, String> degreeRanges = new HashMap<>();

    public Map<String, String> getDegreeRanges() {
        return degreeRanges;
    }

    public void setDegreeRanges(Map<String, String> directionRanges) {
        this.degreeRanges = directionRanges;
    }
}