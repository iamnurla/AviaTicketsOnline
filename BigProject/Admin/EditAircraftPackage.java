package Admin;

import java.io.Serializable;

public class EditAircraftPackage implements Serializable {
    String parameter;
    Aircrafts aircrafts;
    int integer;
    String string;

    public EditAircraftPackage(String parameter, Aircrafts aircrafts, int integer) {
        this.parameter = parameter;
        this.aircrafts = aircrafts;
        this.integer = integer;
    }

    public EditAircraftPackage(String parameter, Aircrafts aircrafts, String string) {
        this.parameter = parameter;
        this.aircrafts = aircrafts;
        this.string = string;
    }
}
