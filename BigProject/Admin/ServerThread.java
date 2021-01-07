package Admin;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ServerThread extends Thread {
    Socket socket;
    Connection connection;
    ObjectInputStream inputStream;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                try {
                    Object object = inputStream.readObject();
                    if (object instanceof AircraftsDate) {
                        AircraftsDate ap = (AircraftsDate) object;
                        System.out.println(ap.operationType);
                        if (ap.operationType.equals("ADD")) {
                            addAircraft(ap.aircraft);
                        }
                        if (ap.operationType.equals("DELETE")) {
                            DeleteAircrafts(ap.aircraft);
                        }
                    }
                    if (object instanceof CitiesDate) {
                        CitiesDate cp = (CitiesDate) object;
                        System.out.println(cp.operationType);
                        if (cp.operationType.equals("ADD")) {
                            addCities(cp.cityDate);
                        }
                        if (cp.operationType.equals("DELETE")) {
                            DeleteCities(cp.cityDate);
                        }
                    }
                    if (object instanceof String) {
                        if (object.equals("aircrafts")) {
                            ObjectOutputStream ous = new ObjectOutputStream(socket.getOutputStream());
                            ous.writeObject(AircraftData());
                        }
                        if (object.equals("cities")) {
                            ObjectOutputStream ous = new ObjectOutputStream(socket.getOutputStream());
                            ous.writeObject(CityData());
                        }
                        if (object.equals("flights")) {
                            ObjectOutputStream ous = new ObjectOutputStream(socket.getOutputStream());
                            ous.writeObject(FlyData());
                        }
                    }
                    if (object instanceof FlightsDate) {
                        FlightsDate fp = (FlightsDate) object;
                        if (fp.operationType.equals("ADD")) {
                            addFlight(fp.flyDate);
                        }
                        if (fp.operationType.equals("DELETE")) {
                            DeleteFlights(fp.flyDate);
                        }
                    }
                    if (object instanceof EditAircraftPackage) {
                        EditAircraftPackage eap = (EditAircraftPackage) object;
                        if (eap.parameter.equals("id")) {
                            Aircrafts aircrafts = new Aircrafts(eap.integer, eap.aircrafts.name, eap.aircrafts.model, eap.aircrafts.business_class_capacity, eap.aircrafts.econom_class_capacity);
                            editAircraft(aircrafts);
                        }
                        if (eap.parameter.equals("name")) {
                            Aircrafts aircrafts = new Aircrafts(eap.aircrafts.id, eap.string, eap.aircrafts.model, eap.aircrafts.business_class_capacity, eap.aircrafts.econom_class_capacity);
                            editAircraft(aircrafts);
                        }
                        if (eap.parameter.equals("model")) {
                            Aircrafts aircrafts = new Aircrafts(eap.aircrafts.id, eap.aircrafts.name, eap.string, eap.aircrafts.business_class_capacity, eap.aircrafts.econom_class_capacity);
                            editAircraft(aircrafts);
                        }
                        if (eap.parameter.equals("business_class_capacity")) {
                            Aircrafts aircrafts = new Aircrafts(eap.aircrafts.id, eap.aircrafts.name, eap.aircrafts.model, eap.integer, eap.aircrafts.econom_class_capacity);
                            editAircraft(aircrafts);
                        }
                        if (eap.parameter.equals("econom_class_capacity")) {
                            Aircrafts aircrafts = new Aircrafts(eap.aircrafts.id, eap.aircrafts.name, eap.aircrafts.model, eap.aircrafts.business_class_capacity, eap.integer);
                            editAircraft(aircrafts);
                        }
                    }
                    if (object instanceof EditCitiesPackage) {
                        EditCitiesPackage ecp = (EditCitiesPackage) object;
                        if (ecp.parameter.equals("id")) {
                            Cities cities = new Cities(ecp.integer, ecp.cities.name, ecp.cities.country, ecp.cities.short_name);
                            editCities(cities);
                        }
                        if (ecp.parameter.equals("name")) {
                            Cities cities = new Cities(ecp.cities.id, ecp.cities.name, ecp.cities.country, ecp.cities.short_name);
                            editCities(cities);
                        }
                        if (ecp.parameter.equals("country")) {
                            Cities cities = new Cities(ecp.cities.id, ecp.cities.name, ecp.string, ecp.cities.short_name);
                            editCities(cities);
                        }
                        if (ecp.parameter.equals("short_name")) {
                            Cities cities = new Cities(ecp.cities.id, ecp.cities.name, ecp.cities.country, ecp.string);
                            editCities(cities);
                        }
                    }
                    if (object instanceof EditFlightsPackage) {
                        EditFlightsPackage fep = (EditFlightsPackage) object;
                        if (fep.parameter.equals("id")) {
                            Flights flights = new Flights(fep.integer, fep.flights.aircraft_id, fep.flights.departure_city_id, fep.flights.arrival_city_id, fep.flights.departure_time, fep.flights.econom_place_price, fep.flights.business_place_price);
                            editFlight(flights);
                        }
                        if (fep.parameter.equals("aircraft_id")) {
                            Flights flights = new Flights(fep.flights.id, fep.integer, fep.flights.departure_city_id, fep.flights.arrival_city_id, fep.flights.departure_time, fep.flights.econom_place_price, fep.flights.business_place_price);
                            editFlight(flights);
                        }
                        if (fep.parameter.equals("departure_city_id")){
                            Flights flights = new Flights(fep.flights.id, fep.flights.aircraft_id, fep.integer,fep.flights.arrival_city_id,fep.flights.departure_time,fep.flights.econom_place_price,fep.flights.business_place_price);
                            editFlight(flights);
                        }
                        if(fep.parameter.equals("arrival_city_id")){
                            Flights flights = new Flights(fep.flights.id, fep.flights.aircraft_id, fep.flights.departure_city_id,fep.integer,fep.flights.departure_time,fep.flights.econom_place_price,fep.flights.business_place_price);
                            editFlight(flights);
                        }
                        if (fep.parameter.equals("departure_time")){
                            Flights flights = new Flights(fep.flights.id,fep.flights.aircraft_id,fep.flights.departure_city_id,fep.flights.arrival_city_id,fep.string,fep.flights.econom_place_price,fep.flights.business_place_price);
                            editFlight(flights);
                        }
                        if (fep.parameter.equals("econom_class_price")){
                            Flights flights = new Flights(fep.flights.id, fep.flights.aircraft_id,fep.flights.departure_city_id,fep.flights.arrival_city_id,fep.flights.departure_time,fep.integer,fep.flights.business_place_price);
                            editFlight(flights);
                        }
                        if (fep.parameter.equals("business_class_price")){
                            Flights flights = new Flights(fep.flights.id, fep.flights.aircraft_id,fep.flights.departure_city_id,fep.flights.arrival_city_id,fep.flights.departure_time,fep.flights.econom_place_price,fep.integer);
                            editFlight(flights);
                        }

                    }
                } catch (Exception E) {
                    E.printStackTrace();

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean editAircraft(Aircrafts aircrafts) {
        int rs = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE aircrafts SET name = ?, model = ?, business_class_capacity = ?, econom_class_capacity = ? WHERE id = ?");

            statement.setString(1, aircrafts.getName());
            statement.setString(2, aircrafts.getModel());
            statement.setInt(3, aircrafts.getEconom_class_capacity());
            statement.setInt(4, aircrafts.getBusiness_class_capacity());
            statement.setInt(5, aircrafts.getId());

            rs = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs > 0;
    }

    public boolean editCities(Cities cities) {
        int ro = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE cities SET name = ?, country = ?, short_name = ? WHERE id = ?");
            statement.setString(1, cities.getName());
            statement.setString(2, cities.getCountry());
            statement.setString(3, cities.getShort_name());
            statement.setInt(4, cities.getId());

            ro = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ro > 0;
    }

    public boolean editFlight(Flights flights) {
        int rf = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE flights SET aircraft_id = ?, departure_city_id = ?, arrival_city_id=?, departure_time=?, econom_place_price = ?, business_place_price=? WHERE id = ?");
            statement.setInt(1, flights.getAircraft_id());
            statement.setInt(2, flights.getDeparture_city_id());
            statement.setInt(3, flights.getArrival_city_id());
            statement.setString(4, flights.getDeparture_time());
            statement.setInt(5, flights.getEconom_place_price());
            statement.setInt(6, flights.getBusiness_place_price());
            statement.setInt(7, flights.getId());

            rf = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rf > 0;
    }

    public void addAircraft(Aircrafts aircrafts) {
        try {
            PreparedStatement staircraft = connection.prepareStatement("INSERT INTO aircrafts(id,name,model," +
                    "business_class_capacity,econom_class_capacity) VALUES(NULL,?,?,?,?)");
            staircraft.setString(1, aircrafts.getName());
            staircraft.setString(2, aircrafts.getModel());
            staircraft.setLong(3, aircrafts.getBusiness_class_capacity());
            staircraft.setLong(4, aircrafts.getEconom_class_capacity());
            staircraft.executeUpdate();

            staircraft = connection.prepareStatement("SELECT * FROM aircrafts WHERE name=? AND model=? " +
                    "AND business_class_capacity=? AND econom_class_capacity=?");
            staircraft.setString(1, aircrafts.getName());
            staircraft.setString(2, aircrafts.getModel());
            staircraft.setLong(3, aircrafts.getBusiness_class_capacity());
            staircraft.setLong(4, aircrafts.getEconom_class_capacity());
            ResultSet rs = staircraft.executeQuery();
            rs.next();
            if (rs.next()) System.out.println("AIRPLANE added");
            staircraft.close();
        } catch (Exception aircraftexception) {
            aircraftexception.printStackTrace();
        }
    }

    public void addCities(Cities cities) {
        try {
            PreparedStatement stcities = connection.prepareStatement("INSERT INTO cities(id,name,country,short_name) VALUES(NULL,?,?,?)");
            stcities.setString(1, cities.getName());
            stcities.setString(2, cities.getCountry());
            stcities.setString(3, cities.getShort_name());
            stcities.executeUpdate();

            stcities = connection.prepareStatement("SELECT * FROM cities WHERE name=? AND country=? AND short_name=?");
            stcities.setString(1, cities.getName());
            stcities.setString(2, cities.getCountry());
            stcities.setString(3, cities.getShort_name());
            ResultSet rs1 = stcities.executeQuery();
            rs1.next();
            if (rs1.next()) System.out.println("CITY ADDED");
            stcities.close();
        } catch (Exception citiesexception) {
            citiesexception.printStackTrace();
        }
    }

    public void addFlight(Flights flights) {
        try {
            PreparedStatement stflight = connection.prepareStatement("INSERT INTO flights(id,aircraft_id,departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price) VALUES(NULL,?,?,?,?,?,?)");
            stflight.setInt(1, flights.getAircraft_id());
            stflight.setInt(2, flights.getDeparture_city_id());
            stflight.setInt(3, flights.getArrival_city_id());
            stflight.setString(4, flights.getDeparture_time());
            stflight.setInt(5, flights.getEconom_place_price());
            stflight.setInt(6, flights.getBusiness_place_price());
            stflight.executeUpdate();

            stflight = connection.prepareStatement("SELECT * FROM flights WHERE aircraft_id=? AND departure_city_id=? AND arrival_city_id=? AND departure_time=? AND econom_place_price=? AND business_place_price=? ");
            stflight.setInt(1,flights.getAircraft_id());
            stflight.setInt(2,flights.getDeparture_city_id());
            stflight.setInt(3,flights.getArrival_city_id());
            stflight.setString(4,flights.getDeparture_time());
            stflight.setInt(5,flights.getEconom_place_price());
            stflight.setInt(6,flights.getBusiness_place_price());
            ResultSet rs2 = stflight.executeQuery();
            rs2.next();
            if (rs2.next()) System.out.println("FLIGHT ADDED");
            stflight.close();
        } catch (Exception flightexception) {
            flightexception.printStackTrace();
        }
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

    public ArrayList<Flights> FlyData() {
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
                int econom = rs.getInt("econom_place_price");
                int business = rs.getInt("business_place_price");
                flights.add(new Flights(id, (long) aircraft_id, (long) departure_city_id, (long) arrival_city_id, departure_time, econom, business));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    public void DeleteAircrafts(Aircrafts aircrafts) {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM aircrafts where id=?");
            st.setLong(1, aircrafts.id);
            st.execute();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteCities(Cities cities) {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM cities where id=?");
            st.setLong(1, cities.id);
            st.execute();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteFlights(Flights flights) {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM flights where id=?");
            st.setLong(1, flights.id);
            st.execute();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
