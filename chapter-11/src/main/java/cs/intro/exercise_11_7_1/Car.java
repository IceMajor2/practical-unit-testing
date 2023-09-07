package cs.intro.exercise_11_7_1;

import java.awt.*;

public interface Car {
    Engine getEngine();

    Color getColor();

    Manufacturer getManufacturer();

    boolean isSportsCar();
}