package cs.intro;

import java.awt.*;

public interface Car {
    Engine getEngine();

    Color getColor();

    Manufacturer getManufacturer();

    boolean isSportsCar();
}