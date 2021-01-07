package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAircrafts extends JPanel {
    AdminGUI parent;
    public AddAircrafts(AdminGUI parent){
        this.parent = parent;

        setSize(500,500);
        setLayout(null);



        JLabel aircraftID = new JLabel("ID: ");
        aircraftID.setBounds(100,50,100,40);
        add(aircraftID);

        JTextField aircraftIDF = new JTextField();
        aircraftIDF.setBounds(200,50,250,40);
        add(aircraftIDF);

        JLabel aircraftName  = new JLabel("Name: ");
        aircraftName.setBounds(100,100,100,40);
        add(aircraftName);

        JTextField aircraftNameF = new JTextField();
        aircraftNameF.setBounds(200,100,250,40);
        add(aircraftNameF);

        JLabel aircraftModel = new JLabel("Model: ");
        aircraftModel.setBounds(100,150,100,40);
        add(aircraftModel);

        JTextField aircraftModelF = new JTextField();
        aircraftModelF.setBounds(200,150,250,40);
        add(aircraftModelF);

        JLabel aircraftBusinessCapa = new JLabel("B Capacity: ");
        aircraftBusinessCapa.setBounds(100,200,100,40);
        add(aircraftBusinessCapa);

        JTextField aircraftBusinessCapaF = new JTextField();
        aircraftBusinessCapaF.setBounds(200,200,250,40);
        add(aircraftBusinessCapaF);

        JLabel aircraftEconomCapa = new JLabel("E Capacity: ");
        aircraftEconomCapa.setBounds(100,250,100,40);
        add(aircraftEconomCapa);

        JTextField aircraftEconomCapaF = new JTextField();
        aircraftEconomCapaF.setBounds(200,250,250,40);
        add(aircraftEconomCapaF);

        JButton aircraftAddButton = new JButton("ADD");
        aircraftAddButton.setBounds(150,300,250,40);
        add(aircraftAddButton);

        aircraftAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(aircraftIDF.getText());
                aircraftIDF.setText("");
                String name = aircraftNameF.getText();
                aircraftNameF.setText("");
                String model = aircraftModelF.getText();
                aircraftModelF.setText("");
                int business_capacity = Integer.parseInt(aircraftBusinessCapaF.getText());
                aircraftBusinessCapaF.setText("");
                int econom_capacity = Integer.parseInt(aircraftEconomCapaF.getText());
                aircraftEconomCapaF.setText("");
                Aircrafts aircrafts = new Aircrafts(id,name,model,business_capacity,econom_capacity);
                AircraftsDate ad = new AircraftsDate("ADD",aircrafts);
                parent.addAircrafts(ad);
            }
        });
        JButton aircraftBackButton  = new JButton("BACK");
        aircraftBackButton.setBounds(150,350,250,40);
        add(aircraftBackButton);
        aircraftBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.addAircrafts.setVisible(false);
                parent.adminSecondPage.setVisible(true);
            }
        });
    }
}
