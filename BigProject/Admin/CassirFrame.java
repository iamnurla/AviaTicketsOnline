package Admin;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class CassirFrame extends JFrame {
    CassirMenu cassirMenu;
    Socket socket;
    ObjectOutputStream ous;
    TicketMenu ticketMenu;
    AddTicket addTicket;
    DeleteTicket deleteTicket;
    BuyTicket buyTicket;
    SearchTicket searchTicket;
    BuySelectedTicket buySelectedTicket;
    EditTicketParameter editTicketParameter;
    EditTicketsData editTicketsData;
    EditTicketInt editTicketInt;
    EditTicketString editTicketString;

    public CassirFrame(Socket socket){
        try{
            this.socket = socket;
            ous = new ObjectOutputStream(socket.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CASHBOX");
        setSize(500,500);
        setLayout(null);

        cassirMenu = new CassirMenu(this);
        cassirMenu.setVisible(true);
        add(cassirMenu);

        ticketMenu=new TicketMenu(this);
        ticketMenu.setVisible(false);
        add(ticketMenu);

        addTicket=new AddTicket(this);
        addTicket.setVisible(false);
        add(addTicket);

        deleteTicket=new DeleteTicket(this);
        deleteTicket.setVisible(false);
        add(deleteTicket);

        buyTicket=new BuyTicket(this);
        buyTicket.setVisible(false);
        add(buyTicket);

        editTicketParameter=new EditTicketParameter(this);
        editTicketParameter.setVisible(false);
        add(editTicketParameter);

        editTicketInt=new EditTicketInt(this);
        editTicketInt.setVisible(false);
        add(editTicketInt);

        editTicketString=new EditTicketString(this);
        editTicketString.setVisible(false);
        add(editTicketString);

        buySelectedTicket=new BuySelectedTicket(this);
        buySelectedTicket.setVisible(false);
        add(buySelectedTicket);

        searchTicket = new SearchTicket(this);
        searchTicket.setVisible(false);
        add(searchTicket);


//        ----------------------------------------------------------------------------------------------------------------
    }

    public CassirMenu getCassirMenu() {
        return cassirMenu;
    }

    public void setCassirMenu(CassirMenu cassirMenu) {
        this.cassirMenu = cassirMenu;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ObjectOutputStream getOus() {
        return ous;
    }

    public void setOus(ObjectOutputStream ous) {
        this.ous = ous;
    }

    public TicketMenu getTicketMenu() {
        return ticketMenu;
    }

    public void setTicketMenu(TicketMenu ticketMenu) {
        this.ticketMenu = ticketMenu;
    }

    public AddTicket getAddTicket() {
        return addTicket;
    }

    public void setAddTicket(AddTicket addTicket) {
        this.addTicket = addTicket;
    }

    public DeleteTicket getDeleteTicket() {
        return deleteTicket;
    }

    public void setDeleteTicket(DeleteTicket deleteTicket) {
        this.deleteTicket = deleteTicket;
    }

    public BuyTicket getBuyTicket() {
        return buyTicket;
    }

    public void setBuyTicket(BuyTicket buyTicket) {
        this.buyTicket = buyTicket;
    }

    public SearchTicket getSearchTicket() {
        return searchTicket;
    }

    public void setSearchTicket(SearchTicket searchTicket) {
        this.searchTicket = searchTicket;
    }

    public BuySelectedTicket getBuySelectedTicket() {
        return buySelectedTicket;
    }

    public void setBuySelectedTicket(BuySelectedTicket buySelectedTicket) {
        this.buySelectedTicket = buySelectedTicket;
    }

    public EditTicketParameter getEditTicketParameter() {
        return editTicketParameter;
    }

    public void setEditTicketParameter(EditTicketParameter editTicketParameter) {
        this.editTicketParameter = editTicketParameter;
    }

    public EditTicketsData getEditTicketsData() {
        return editTicketsData;
    }

    public void setEditTicketsData(EditTicketsData editTicketsData) {
        this.editTicketsData = editTicketsData;
    }

    public EditTicketInt getEditTicketInt() {
        return editTicketInt;
    }

    public void setEditTicketInt(EditTicketInt editTicketInt) {
        this.editTicketInt = editTicketInt;
    }

    public EditTicketString getEditTicketString() {
        return editTicketString;
    }

    public void setEditTicketString(EditTicketString editTicketString) {
        this.editTicketString = editTicketString;
    }



    public void addTicket(Ticket ticket) {
        try{
            TicketData td = new TicketData("ADD",ticket);
            ous.writeObject(td);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void addAircraft(Aircrafts aircrafts) throws IOException {
        try{
            AircraftsDate ap = new AircraftsDate("ADD", aircrafts);
            ous.writeObject(ap);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void deleteTicket (Ticket ticket){
        try{
            TicketData ticketData = new TicketData("DELETE",ticket);
            ous.writeObject(ticketData);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void DeleteAircraft(Aircrafts aircrafts) {
        try {
            AircraftsDate ap = new AircraftsDate("DELETE", aircrafts);
            ous.writeObject(ap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void EditTicketsInt(String parameter, Ticket ticket, int idi) {
        try {
            EditTicketsData ep =new EditTicketsData(parameter,idi,ticket);
            ous.writeObject(ep);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void EditTicketsString(String parameter, Ticket ticket, String string) {
        try {
            EditTicketsData ep = new EditTicketsData(parameter, string, ticket);
            ous.writeObject(ep);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Aircrafts> sendListA(String string){
        ArrayList<Aircrafts> aircrafts = null;
        try{
            ous.writeObject(string);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            aircrafts = (ArrayList<Aircrafts>) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return aircrafts;
    }


    public ArrayList<Cities> sendListC(String string) {
        ArrayList<Cities> cities = null;
        try {
            ous.writeObject(string);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            cities = (ArrayList<Cities>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }


    public ArrayList<Ticket> sendListT(String string){
        ArrayList<Ticket> tickets = null;
        try{
            ous.writeObject(string);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            tickets = (ArrayList<Ticket>) ois.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }
        return tickets;
    }

    public ArrayList<Flights> sendListF(String string){
        ArrayList<Flights> flights = null;
        try{
            ous.writeObject(string);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            flights = (ArrayList<Flights>) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flights;
    }

}
