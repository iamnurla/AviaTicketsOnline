package Admin;

import java.io.Serializable;

public class TicketData implements Serializable {
    String operationType;
    Ticket ticket;

    public TicketData(String operationType, Ticket ticket) {
        this.operationType = operationType;
        this.ticket = ticket;
    }
}
