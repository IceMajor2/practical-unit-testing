package cs.intro;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarSearchTest {

    private CarSearch SUT = new CarSearch();

    @Test
    void shouldReturnOnlySportCars_beforeRefactor() {
        Car car = mock(Car.class);
        Manufacturer manufacturer = mock(Manufacturer.class);
        Engine engine = mock(Engine.class);
        Color color = Color.RED;

        when(car.getManufacturer()).thenReturn(manufacturer);
        when(car.getEngine()).thenReturn(engine);
        when(car.getColor()).thenReturn(color);
        when(manufacturer.getName()).thenReturn("Ferrari");
        when(engine.getNbOfCylinders()).thenReturn(8);

        SUT.addCar(car);
        assertThat(SUT.findSportCars()).containsExactly(car);
    }
}