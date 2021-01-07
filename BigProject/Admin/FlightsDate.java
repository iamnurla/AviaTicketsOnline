package Admin;

import java.io.Serializable;

public class FlightsDate implements Serializable {
    String operationType;
    Flights flyDate;

    public FlightsDate(String operationType, Flights fly) {
        this.operationType = operationType;
        this.flyDate = fly;
    }

}

