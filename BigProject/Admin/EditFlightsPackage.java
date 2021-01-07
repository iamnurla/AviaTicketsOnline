package Admin;

import java.io.Serializable;


public class EditFlightsPackage implements Serializable {
    String parameter;
    Flights flights;
    int integer;
    String string;

    public EditFlightsPackage(String parameter, Flights flights, int integer) {
        this.parameter = parameter;
        this.flights = flights;
        this.integer = integer;
    }

    public EditFlightsPackage(String parameter, Flights flights, String string) {
        this.parameter = parameter;
        this.flights = flights;
        this.string = string;
    }
}
