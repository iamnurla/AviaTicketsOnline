package Admin;

import java.io.Serializable;


public class CitiesDate implements Serializable {
    String operationType;
    Cities cityDate;

    public CitiesDate(String operationType, Cities city) {
        this.operationType = operationType;
        this.cityDate = city;
    }
}
