package Admin;

import java.io.Serializable;

public class EditTicketsData implements Serializable {
    String parameter;
    int integer;
    String string;
    Ticket ticket;

    public EditTicketsData(String parameter, String string, Ticket ticket) {

        this.parameter = parameter;
        this.string = string;
        this.ticket = ticket;
    }

    public EditTicketsData(String parameter, int integer, Ticket ticket) {
        this.parameter = parameter;
        this.integer = integer;
        this.ticket = ticket;
    }
}
