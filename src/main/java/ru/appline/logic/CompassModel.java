package ru.appline.logic;

import java.util.Map;


public class CompassModel {

    private static final CompassModel instance=new CompassModel();
    private Map<String, String> degreeRanges;

    public static CompassModel getInstance() {
        return instance;
    }

    public void updateDirections(Map<String, String> degreeRanges) {
        this.degreeRanges = degreeRanges;
    }

    public String findDirection(int degree) {
        if (degree < 0 || degree > 359) {
            return "Ошибка: градус должен быть в пределах от 0 до 359";
        }

        for (Map.Entry<String, String> entry : degreeRanges.entrySet()) {
            String[] range = entry.getValue().split("-");
            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);
            if (start <= end) {
                if (degree >= start && degree <= end) {
                    return entry.getKey();
                }
            } else {
                if (degree >= start || degree <= end) {
                    return entry.getKey();
                }
            }
        }
       return "Не удалось определить";
    }

}
