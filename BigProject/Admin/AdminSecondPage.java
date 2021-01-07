package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSecondPage extends JPanel {
    AdminGUI parent;
    JButton aircraftsSecondButton;
    JButton citiesSecondButton;
    JButton flightsSecondButton;
    JButton backSecondButton;
    JButton exitSecondButton;


    public AdminSecondPage(AdminGUI parent) {
        this.parent = parent;
        setSize(500, 500);
        setLayout(null);


        aircraftsSecondButton = new JButton("AIRCRAFTS");
        aircraftsSecondButton.setBounds(100, 100, 300, 60);
        add(aircraftsSecondButton);
        aircraftsSecondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.adminSecondPage.setVisible(false);
                parent.addAircrafts.setVisible(true);

            }
        });

        citiesSecondButton = new JButton("CITIES");
        citiesSecondButton.setBounds(100, 180, 300, 60);
        add(citiesSecondButton);

        citiesSecondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.adminSecondPage.setVisible(false);
                parent.addCities.setVisible(true);
            }
        });

        flightsSecondButton = new JButton("FLIGHTS");
        flightsSecondButton.setBounds(100, 260, 300, 60);
        add(flightsSecondButton);

        flightsSecondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.adminSecondPage.setVisible(false);
                parent.addFlights.setVisible(true);
            }
        });

        backSecondButton = new JButton("BACK");
        backSecondButton.setBounds(150, 340, 100, 40);
        add(backSecondButton);

        backSecondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.adminSecondPage.setVisible(false);
                parent.adminMainPage.setVisible(true);
            }
        });

        exitSecondButton = new JButton("EXIT");
        exitSecondButton.setBounds(265, 340, 100, 40);
        add(exitSecondButton);

        exitSecondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

