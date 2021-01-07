package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPage extends JPanel {
    AdminGUI main;
    JButton aircrafts;
    JButton cities;
    JButton flights;
    JButton back;
    JButton exit;

    public EditPage(AdminGUI main) {
        this.main = main;

        setSize(500, 500);
        setLayout(null);

        aircrafts = new JButton("AIRCRAFTS");
        aircrafts.setBounds(100, 100, 300, 40);
        add(aircrafts);
        aircrafts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditPage().setVisible(false);
                main.getEditAircraftParameter().setVisible(true);
            }
        });

        cities = new JButton("CITIES");
        cities.setBounds(100, 150, 300, 40);
        add(cities);
        cities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditPage().setVisible(false);
                main.getEditCitiesParameter().setVisible(true);
            }
        });
        flights = new JButton("FLIGHTS");
        flights.setBounds(100,200,300,40);
        add(flights);
        flights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditPage().setVisible(false);
                main.getEditFlightsParameter().setVisible(true);
            }
        });
        back = new JButton("BACK");
        back.setBounds(125,300,100,40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.adminSecondPage.setVisible(true);
                main.getEditPage().setVisible(false);
            }
        });
        exit = new JButton("EXIT");
        exit.setBounds(275,300,100,40);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
