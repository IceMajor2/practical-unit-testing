package cs.intro.exercise_11_7_1;

import java.util.ArrayList;
import java.util.List;

public class CarSearch {
    private List<Car> cars = new ArrayList<Car>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> findSportCars() {
        List<Car> sportCars = new ArrayList<Car>();
        for (Car car : cars) {
            // if-statement before refactor
//            if (car.getEngine().getNbOfCylinders() > 6
//                    && Color.RED == car.getColor()
//                    && "Ferrari".equals(car.getManufacturer().getName())) {
            // refactored if-statement
            if (car.isSportsCar()) {
                sportCars.add(car);
            }
        }
        return sportCars;
    }
}
