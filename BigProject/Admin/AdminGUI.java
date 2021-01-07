package Admin;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class AdminGUI extends JFrame {


    AdminMainPage adminMainPage;
    AdminSecondPage adminSecondPage;
    AddAircrafts addAircrafts;
    AddCities addCities;
    AddFlights addFlights;
    DeletePage deletePage;
    EditPage editPage;
    EditAircraftParameter editAircraftParameter;
    EditAircraftString editAircraftString;
    EditAircraftInt editAircraftInt;
    EditCitiesPackage editCitiesPackage;
    EditCitiesInt editCitiesInt;
    EditCitiesParameter editCitiesParameter;
    EditCitiesString editCitiesString;
    EditFlightsParameter editFlightsParameter;
    EditFlightsInt editFlightsInt;
    EditFlightsString editFlightsString;
    EditFlightDepartureCityID editFlightDepartureCityID;
    EditFligthArrivalCityID editFligthArrivalCityID;
    EditFlightAircraftId editFlightAircraftId;
    DeleteAircrafts deleteAircrafts;
    CitiesDelete citiesDelete;
    FlightDelete flightDelete;
    Socket socket;
    ObjectOutputStream outStream;



    public AdminGUI(Socket socket) {
        try {
            this.socket = socket;
            outStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


        setSize(500, 500);
        setTitle("ADMIN APPLICATION");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        adminMainPage = new AdminMainPage(this);
        add(adminMainPage);
        adminMainPage.setVisible(true);

        adminSecondPage = new AdminSecondPage(this);
        add(adminSecondPage);
        adminSecondPage.setVisible(false);

        addAircrafts = new AddAircrafts(this);
        add(addAircrafts);
        addAircrafts.setVisible(false);

        addCities = new AddCities(this);
        add(addCities);
        addCities.setVisible(false);

        addFlights = new AddFlights(this);
        add(addFlights);
        addFlights.setVisible(false);

        deletePage = new DeletePage(this);
        add(deletePage);
        deletePage.setVisible(false);

        deleteAircrafts = new DeleteAircrafts(this);
        add(deleteAircrafts);
        deleteAircrafts.setVisible(false);

        citiesDelete = new CitiesDelete(this);
        add(citiesDelete);
        citiesDelete.setVisible(false);

        flightDelete = new FlightDelete(this);
        add(flightDelete);
        flightDelete.setVisible(false);

        editPage = new EditPage(this);
        add(editPage);
        editPage.setVisible(false);

        editAircraftParameter = new EditAircraftParameter(this);
        add(editAircraftParameter);
        editAircraftParameter.setVisible(false);

        editAircraftString = new EditAircraftString(this);
        add(editAircraftString);
        editAircraftString.setVisible(false);

        editAircraftInt = new EditAircraftInt(this);
        add(editAircraftInt);
        editAircraftInt.setVisible(false);

        editCitiesParameter = new EditCitiesParameter(this);
        add(editCitiesParameter);
        editCitiesParameter.setVisible(false);

        editCitiesInt = new EditCitiesInt(this);
        add(editCitiesInt);
        editCitiesInt.setVisible(false);

        editCitiesString = new EditCitiesString(this);
        add(editCitiesString);
        editCitiesString.setVisible(false);

        editFlightsParameter = new EditFlightsParameter(this);
        add(editFlightsParameter);
        editFlightsParameter.setVisible(false);

        editFlightsInt = new EditFlightsInt(this);
        add(editFlightsInt);
        editFlightsInt.setVisible(false);

        editFlightsString = new EditFlightsString(this);
        add(editFlightsString);
        editFlightsString.setVisible(false);

        editFlightAircraftId = new EditFlightAircraftId(this);
        add(editFlightAircraftId);
        editFlightAircraftId.setVisible(false);

        editFlightDepartureCityID = new EditFlightDepartureCityID(this);
        add(editFlightDepartureCityID);
        editFlightDepartureCityID.setVisible(false);

        editFligthArrivalCityID = new EditFligthArrivalCityID(this);
        add(editFligthArrivalCityID);
        editFligthArrivalCityID.setVisible(false);

    }

//    -----------------------------------------------------------------------------------------------------------------

    public AdminMainPage getAdminMainPage() {
        return adminMainPage;
    }

    public void setAdminMainPage(AdminMainPage adminMainPage) {
        this.adminMainPage = adminMainPage;
    }

    public AdminSecondPage getAdminSecondPage() {
        return adminSecondPage;
    }


    public AddAircrafts getAddAircrafts() {
        return addAircrafts;
    }

    public AddFlights getAddFlights() {
        return addFlights;
    }

    public DeletePage getDeletePage(){
        return deletePage;
    }
    public DeleteAircrafts getDeleteAircrafts(){
        return deleteAircrafts;
    }
    public CitiesDelete getCitiesDelete(){
        return citiesDelete;
    }
    public FlightDelete getFlightDelete(){
        return flightDelete;
    }

    public EditPage getEditPage() {
        return editPage;
    }

    public void setEditPage(EditPage editPage) {
        this.editPage = editPage;
    }

    public EditAircraftParameter getEditAircraftParameter() {
        return editAircraftParameter;
    }

    public void setEditAircraftParameter(EditAircraftParameter editAircraftParameter) {
        this.editAircraftParameter = editAircraftParameter;
    }

    public EditAircraftString getEditAircraftString() {
        return editAircraftString;
    }

    public void setEditAircraftString(EditAircraftString editAircraftString) {
        this.editAircraftString = editAircraftString;
    }

    public EditAircraftInt getEditAircraftInt() {
        return editAircraftInt;
    }

    public void setEditAircraftInt(EditAircraftInt editAircraftInt) {
        this.editAircraftInt = editAircraftInt;
    }

    public EditCitiesPackage getEditCitiesPackage() {
        return editCitiesPackage;
    }

    public void setEditCitiesPackage(EditCitiesPackage editCitiesPackage) {
        this.editCitiesPackage = editCitiesPackage;
    }

    public EditCitiesInt getEditCitiesInt() {
        return editCitiesInt;
    }

    public void setEditCitiesInt(EditCitiesInt editCitiesInt) {
        this.editCitiesInt = editCitiesInt;
    }

    public EditCitiesParameter getEditCitiesParameter() {
        return editCitiesParameter;
    }

    public void setEditCitiesParameter(EditCitiesParameter editCitiesParameter) {
        this.editCitiesParameter = editCitiesParameter;
    }

    public EditCitiesString getEditCitiesString() {
        return editCitiesString;
    }

    public void setEditCitiesString(EditCitiesString editCitiesString) {
        this.editCitiesString = editCitiesString;
    }

    public EditFlightsParameter getEditFlightsParameter() {
        return editFlightsParameter;
    }

    public void setEditFlightsParameter(EditFlightsParameter editFlightsParameter) {
        this.editFlightsParameter = editFlightsParameter;
    }

    public EditFlightsInt getEditFlightsInt() {
        return editFlightsInt;
    }

    public void setEditFlightsInt(EditFlightsInt editFlightsInt) {
        this.editFlightsInt = editFlightsInt;
    }

    public EditFlightsString getEditFlightsString() {
        return editFlightsString;
    }

    public void setEditFlightsString(EditFlightsString editFlightsString) {
        this.editFlightsString = editFlightsString;
    }

    public EditFlightDepartureCityID getEditFlightDepartureCityID() {
        return editFlightDepartureCityID;
    }

    public void setEditFlightDepartureCityID(EditFlightDepartureCityID editFlightDepartureCityID) {
        this.editFlightDepartureCityID = editFlightDepartureCityID;
    }

    public EditFligthArrivalCityID getEditFligthArrivalCityID() {
        return editFligthArrivalCityID;
    }

    public void setEditFligthArrivalCityID(EditFligthArrivalCityID editFligthArrivalCityID) {
        this.editFligthArrivalCityID = editFligthArrivalCityID;
    }

    public EditFlightAircraftId getEditFlightAircraftId() {
        return editFlightAircraftId;
    }

    public void setEditFlightAircraftId(EditFlightAircraftId editFlightAircraftId) {
        this.editFlightAircraftId = editFlightAircraftId;
    }

    // --------------------------------------------------------------------------------------------------------------------


    public void DeleteAircraft(Aircrafts aircraft){
        try{
            AircraftsDate ap = new AircraftsDate("DELETE", aircraft);
            outStream.writeObject(ap);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void DeleteCities(Cities city){
        try{
            CitiesDate cd = new CitiesDate("DELETE",city);
            outStream.writeObject(cd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void DeleteFlight(Flights flights){
        try{
            FlightsDate fd = new FlightsDate("DELETE",flights);
            outStream.writeObject(fd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void addAircrafts(AircraftsDate ad) {
        try {
            outStream.writeObject(ad);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCities(CitiesDate cd) {
        try {
            outStream.writeObject(cd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFlights(Flights flights) {
        try {
            FlightsDate fp = new FlightsDate("ADD",flights);
            outStream.writeObject(fp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void EditAircraftString(String parameter, Aircrafts aircrafts, String string){
        try{
            EditAircraftPackage eap = new EditAircraftPackage(parameter,aircrafts,string);
            outStream.writeObject(eap);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  void EditAircraftInt(String parameter, Aircrafts aircrafts,int id){
        try{
            EditAircraftPackage eap = new EditAircraftPackage(parameter,aircrafts,id);
            outStream.writeObject(eap);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void EditCitiesInt(String parameter, Cities city, int id) {
        try {
            EditCitiesPackage ecp =new EditCitiesPackage(parameter,city,id);
            outStream.writeObject(ecp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EditCitiesString(String parameter, Cities city, String string) {
        try {
            EditCitiesPackage ecp = new EditCitiesPackage(parameter,city,string);
            outStream.writeObject(ecp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Aircrafts> sendListA(String string) {
        ArrayList<Aircrafts> aircrafts = null;
        try {
            outStream.writeObject(string);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            aircrafts = (ArrayList<Aircrafts>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aircrafts;
    }

    public ArrayList<Cities> sendListC(String string) {
        ArrayList<Cities> cities = null;
        try {
            outStream.writeObject(string);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            cities = (ArrayList<Cities>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }
    public ArrayList<Flights> sendListF(String string){
        ArrayList<Flights> aircrafts = null;
        try{
            outStream.writeObject(string);
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            aircrafts = (ArrayList<Flights>) inputStream.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }
        return aircrafts;
    }
    public void FlightEditInt(String parameter,Flights flight, int id){
        try {
            EditFlightsPackage fep = new EditFlightsPackage(parameter,flight,id);
            outStream.writeObject(fep);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void FlightEditString(String parameter,Flights flight,String string){

        try {
            EditFlightsPackage fep = new EditFlightsPackage(parameter,flight,string);
            outStream.writeObject(fep);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
