package Admin;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CassirThread extends Thread {
    Socket socket;
    ObjectInputStream inputStream;
    Connection connection;

    public CassirThread(Socket socket, Connection connection)  {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                Object object = inputStream.readObject();
                if (object instanceof String) {
                    if (object.equals("flights")) {
                        ObjectOutputStream ous = new ObjectOutputStream(socket.getOutputStream());
                        ous.writeObject(FlightsData());
                    }
                    if (object.equals("aircrafts")) {
                        ObjectOutputStream ous = new ObjectOutputStream(socket.getOutputStream());
                        ous.writeObject(AircraftData());
                    }
                    if (object.equals("cities")) {
                        ObjectOutputStream ous = new ObjectOutputStream(socket.getOutputStream());
                        ous.writeObject(CityData());
                    }
                    if (object.equals("tickets")) {
                        ObjectOutputStream ous = new ObjectOutputStream(socket.getOutputStream());
                        ous.writeObject(TicketData());
                    }
                }
                if (object instanceof TicketData) {
                    TicketData tp = (TicketData) object;
                    if (tp.operationType.equals("ADD")) {
                        AddTicket(tp.ticket);
                    }
                    if (tp.operationType.equals("DELETE")) {
                        DeleteTicket(tp.ticket);
                    }
                }
                if (object instanceof AircraftsDate) {
                    AircraftsDate ap = (AircraftsDate) object;
                    if (ap.operationType.equals("ADD")){
                        AddAircraft(ap.aircraft);
                    }
                    if(ap.operationType.equals("DELETE")){
                        DeleteAircraft(ap.aircraft);
                    }
                }
                if(object instanceof EditTicketsData){
                    EditTicketsData ep = (EditTicketsData) object;
                    if(ep.parameter.equals("id")){
                        deleteTickets(ep.ticket);
                        Ticket ticket = new Ticket(ep.integer,ep.ticket.flight_id,ep.ticket.name,ep.ticket.surname,ep.ticket.passport_number,ep.ticket.ticket_type);
                        AddTicket(ticket);
                    }if (ep.parameter.equals("flight_id")){
                        deleteTickets(ep.ticket);
                        Ticket ticket = new Ticket(ep.ticket.id,ep.integer,ep.ticket.name,ep.ticket.surname,ep.ticket.passport_number,ep.ticket.ticket_type);
                        AddTicket(ticket);
                    }if (ep.parameter.equals("name")){
                        deleteTickets(ep.ticket);
                        Ticket ticket = new Ticket(ep.ticket.id,ep.ticket.flight_id,ep.string,ep.ticket.surname,ep.ticket.passport_number,ep.ticket.ticket_type);
                        AddTicket(ticket);
                    }if (ep.parameter.equals("surname")){
                        deleteTickets(ep.ticket);
                        Ticket ticket = new Ticket(ep.ticket.id,ep.ticket.flight_id,ep.ticket.name,ep.string,ep.ticket.passport_number,ep.ticket.ticket_type);
                        AddTicket(ticket);
                    }if (ep.parameter.equals("passport_number")){
                        deleteTickets(ep.ticket);
                        Ticket ticket = new Ticket(ep.ticket.id,ep.ticket.flight_id,ep.ticket.name,ep.ticket.surname,ep.string,ep.ticket.ticket_type);
                        AddTicket(ticket);
                    }if (ep.parameter.equals("ticket_type")){
                        deleteTickets(ep.ticket);
                        Ticket ticket = new Ticket(ep.ticket.id,ep.ticket.flight_id,ep.ticket.name,ep.ticket.surname,ep.ticket.passport_number,ep.string);
                        AddTicket(ticket);
                    }
                }

            } catch (Exception e) {

            }
        }
    }
    public void AddTicket(Ticket ticket) {
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO tickets(id,flight_id,name,surname,passport_number,ticket_type)VALUES(?,?,?,?,?,?)");
            st.setInt(1, ticket.id);
            st.setInt(2, ticket.flight_id);
            st.setString(3, ticket.name);
            st.setString(4, ticket.surname);
            st.setString(5, ticket.passport_number);
            st.setString(6, ticket.ticket_type);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void AddAircraft(Aircrafts aircraft) {
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO aircrafts(id,name,model,business_class_capacity,econom_class_capacity)VALUES(?,?,?,?,?)");
            st.setInt(1, aircraft.id);
            st.setString(2, aircraft.name);
            st.setString(3, aircraft.model);
            st.setInt(4, aircraft.business_class_capacity);
            st.setInt(5, aircraft.econom_class_capacity);
            st.execute();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void DeleteTicket(Ticket ticket){
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM tickets where id = ?");
            st.setInt(1,ticket.id);
            st.execute();
            st.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteTickets(Ticket ticket) {

        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM tickets where id = ?");
            statement.setInt(1, ticket.id);
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteAircraft(Aircrafts aircraft) {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM aircrafts where name = ?");
            st.setString(1, aircraft.name);
            st.execute();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Flights> FlightsData() {
        ArrayList<Flights> flights = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM flights");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int aircraft_id = rs.getInt("aircraft_id");
                int departure_city_id = rs.getInt("departure_city_id");
                int arrival_city_id = rs.getInt("arrival_city_id");
                String departure_time = rs.getString("departure_time");
                int econom_place_capacity = rs.getInt("econom_place_price");
                int business_place_price = rs.getInt("business_place_price");
                flights.add(new Flights(id, aircraft_id, departure_city_id, arrival_city_id, departure_time, econom_place_capacity, business_place_price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }


    public ArrayList<Aircrafts> AircraftData() {
        ArrayList<Aircrafts> aircrafts = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM aircrafts");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String model = rs.getString("model");
                int business_class_capacity = rs.getInt("business_class_capacity");
                int econom_class_capacity = rs.getInt("econom_class_capacity");
                aircrafts.add(new Aircrafts(id, name, model, business_class_capacity, econom_class_capacity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aircrafts;
    }

    public ArrayList<Cities> CityData() {
        ArrayList<Cities> cities = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cities");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                String short_name = rs.getString("short_name");
                cities.add(new Cities(id, name, country, short_name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }



    public ArrayList<Ticket> TicketData() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM tickets");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int flight_id = rs.getInt("flight_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String passport_number = rs.getString("passport_number");
                String ticket_type = rs.getString("ticket_type");
                tickets.add(new Ticket(id, flight_id, name, surname, passport_number, ticket_type));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }

}
