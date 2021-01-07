package Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFlights extends JPanel {
    AdminGUI parent;
    public AddFlights(AdminGUI parent) {
        this.parent = parent;
        setSize(500, 500);
        setBackground(Color.GRAY);
        setLayout(null);

        String[] id1 = new String[parent.sendListA("aircrafts").size()];
        for (int i = 0;i<parent.sendListA("aircrafts").size();i++) {
            id1[i] = String.valueOf((parent.sendListA("aircrafts").get(i).name));
        }
        String[] id2 = new String[parent.sendListC("cities").size()];
        for (int i = 0;i<parent.sendListC("cities").size();i++){
            id2[i]=String.valueOf((parent.sendListC("cities").get(i).name));
        }



        JLabel idFlights = new JLabel("ID ");
        idFlights.setBounds(100, 50, 100, 40);
        add(idFlights);

        JTextField idFlightsF = new JTextField();
        idFlightsF.setBounds(200, 50, 250, 40);
        add(idFlightsF);

        JLabel aircraftIDFlights = new JLabel("Aircraft ID");
        aircraftIDFlights.setBounds(100, 100, 100, 40);
        add(aircraftIDFlights);

        JComboBox aircraftIDCombo = new JComboBox(id1);
        aircraftIDCombo.setBounds(200,100,250,40);
        add(aircraftIDCombo);

        JLabel departureFlightsID = new JLabel("Departure city ID");
        departureFlightsID.setBounds(100, 150, 100, 40);
        add(departureFlightsID);

        JComboBox departureIDCombo = new JComboBox(id2);
        departureIDCombo.setBounds(200,150,250,40);
        add(departureIDCombo);

        JLabel ArrivalCityID = new JLabel("Arrival city ID");
        ArrivalCityID.setBounds(100, 200, 100, 40);
        add(ArrivalCityID);

        JComboBox arrivalIDCombo = new JComboBox(id2);
        arrivalIDCombo.setBounds(200,200,250,40);
        add(arrivalIDCombo);

        JLabel depaturetimeFlights = new JLabel("Departure Time");
        depaturetimeFlights.setBounds(100, 250, 100, 40);
        add(depaturetimeFlights);

        JTextField departuretimeFlightsF = new JTextField();
        departuretimeFlightsF.setBounds(200, 250, 250, 40);
        add(departuretimeFlightsF);

        JLabel economyFlights = new JLabel("E place price");
        economyFlights.setBounds(100,300,100,40);
        add(economyFlights);

        JTextField economyFlightsF = new JTextField();
        economyFlightsF.setBounds(200,300,250,40);
        add(economyFlightsF);

        JLabel businessFlights = new JLabel("B place price");
        businessFlights.setBounds(100,350,100,40);
        add(businessFlights);

        JTextField businessFlightsF = new JTextField();
        businessFlightsF.setBounds(200,350,250,40);
        add(businessFlightsF);

        JButton addButtonFlights = new JButton("ADD");
        addButtonFlights.setBounds(170,400,100,40);
        add(addButtonFlights);

        addButtonFlights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Flights flights = new Flights(Integer.parseInt(idFlightsF.getText()), (parent.sendListA("aircrafts").get((aircraftIDCombo.getSelectedIndex())).id), (parent.sendListC("cities").get((departureIDCombo.getSelectedIndex())).id), (parent.sendListC("cities").get((arrivalIDCombo.getSelectedIndex())).id),departuretimeFlightsF.getText(),Integer.parseInt(economyFlightsF.getText()),Integer.parseInt(businessFlightsF.getText()));
                try{
                    parent.addFlights(flights);
                }catch (Exception eer){
                    eer.printStackTrace();
                }
                idFlightsF.setText("");
                aircraftIDCombo.setSelectedItem(null);
                departureIDCombo.setSelectedItem(null);
                arrivalIDCombo.setSelectedItem(null);
                departuretimeFlightsF.setText("");
                economyFlightsF.setText("");
                businessFlightsF.setText("");


            }
        });

        JButton backButtonFlights = new JButton("BACK");
        backButtonFlights.setBounds(280,400,100,40);
        add(backButtonFlights);

        backButtonFlights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.adminSecondPage.setVisible(true);
                parent.addFlights.setVisible(false);
            }
        });
    }
}