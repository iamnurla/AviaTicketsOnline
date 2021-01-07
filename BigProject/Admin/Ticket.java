package Admin;

import java.io.Serializable;

public class Ticket implements Serializable {
    int id;
    int flight_id;
    String name;
    String surname;
    String passport_number;
    String ticket_type;

    public Ticket(int id, int flight_id, String name, String surname, String passport_number, String ticket_type) {
        this.id = id;
        this.flight_id = flight_id;
        this.name = name;
        this.surname = surname;
        this.passport_number = passport_number;
        this.ticket_type = ticket_type;
    }
}
