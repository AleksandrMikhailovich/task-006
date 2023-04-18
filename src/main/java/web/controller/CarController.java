package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarSerice;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private CarSerice carSerice;

    @Autowired
    public CarController(CarSerice show) {
        this.carSerice = show;
    }

    @GetMapping("")
    public String cars(Model model) {
        model.addAttribute("cars", carSerice.getAllCars());
        return "cars";
    }

    @GetMapping("/{id}")
    public String carId(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", carSerice.carGetId(id));
        return "show";
    }

    @GetMapping("/count")
    public String count(Model model, @RequestParam(value = "count", required = false) Integer count) {
        List<Car>carCount = carSerice.getCountCars(count);
        model.addAttribute("cars", carCount);
        return "count";
    }
}
