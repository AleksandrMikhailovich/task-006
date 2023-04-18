package web.service;

import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CarSerice {
    private List<Car> cars = new ArrayList<>();
    {
        cars.add(new Car(1, "BMW", "Black"));
        cars.add(new Car(2, "Mercedes", "White"));
        cars.add(new Car(3, "Mitsubishi", "Red"));
        cars.add(new Car(4, "Lamborghini", "Yellow"));
        cars.add(new Car(5, "Subaru", "Blue"));
    }
    public List<Car> getAllCars(){
        return cars;
    }
    public Car carGetId(int id){
        return cars.stream().filter(e->e.getId()==id).findAny().orElse(null);
    }
    public List<Car> getCountCars(Integer count){
        if(Objects.nonNull(count)){
            return cars.stream().limit(count).collect(Collectors.toList());
        }
        return cars;
    }
}
