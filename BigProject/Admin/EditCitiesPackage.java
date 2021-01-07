package Admin;

import java.io.Serializable;

public class EditCitiesPackage implements Serializable {
    String parameter;
    Cities cities;
    int integer;
    String string;

    public EditCitiesPackage(String parameter, Cities cities,String string){
        this.parameter = parameter;
        this.cities = cities;
        this.string = string;
    }
    public EditCitiesPackage(String parameter,Cities cities,int integer){
        this.parameter = parameter;
        this.cities = cities;
        this.integer = integer;
    }
}
