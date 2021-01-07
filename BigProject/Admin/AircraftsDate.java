package Admin;

import java.io.Serializable;

public class AircraftsDate implements Serializable {
    public  String operationType;
    public Aircrafts aircraft;

    public AircraftsDate(String operationType, Aircrafts aircraft) {
        this.operationType = operationType;
        this.aircraft = aircraft;
    }
}
