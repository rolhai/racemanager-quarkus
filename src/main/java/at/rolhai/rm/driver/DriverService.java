package at.rolhai.rm.driver;

import java.util.Arrays;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class DriverService {

    public List<Driver> getDrivers() {
        Driver d1 = new Driver();
        d1.id = 1L;
        d1.firstname = "Fernando";
        d1.lastname = "Alonso";

        Driver d2 = new Driver();
        d2.id = 2L;
        d2.firstname = "Mika";
        d2.lastname = "Hakkinen";

        return Arrays.asList(d1, d2);
    }
    
}
