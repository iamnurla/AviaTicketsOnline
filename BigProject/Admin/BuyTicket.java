package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BuyTicket extends JPanel {
    CassirFrame main;
    JButton back;
    JComboBox aircraft_idCombo;
    JLabel aircraft_idLabel;
    JComboBox departure_cityCombo;
    JLabel departure_cityLabel;
    JComboBox arrival_cityCombo;
    JLabel arrival_cityLabel;
    JButton search;
    ArrayList<Integer> available_flight_ids;
    JLabel error;
    ArrayList<Integer> available_tickets_id;

    public BuyTicket(CassirFrame main) {
        this.main = main;

        String[] aircraft_idS = new String[main.sendListA("aircrafts").size()];
        for (int i = 0; i < main.sendListA("aircrafts").size(); i++) {
            aircraft_idS[i] = (String.valueOf(main.sendListA("aircrafts").get(i).id));
        }
        String[] aircraft_idS2 = new String[main.sendListC("cities").size()];
        for (int i = 0; i < main.sendListC("cities").size(); i++) {
            aircraft_idS2[i] = (String.valueOf(main.sendListC("cities").get(i).id));
        }

        setSize(500, 500);
        setLayout(null);

        aircraft_idLabel = new JLabel("AIRCRAFT");
        aircraft_idLabel.setBounds(100, 20, 300, 30);
        add(aircraft_idLabel);

        error = new JLabel("NO TICKETS WITH YOUR SETTINGS");
        error.setBounds(100, 300, 300, 30);
        add(error);
        error.setVisible(false);

        aircraft_idCombo = new JComboBox(aircraft_idS);
        aircraft_idCombo.setBounds(100, 50, 300, 30);
        aircraft_idCombo.setSelectedItem(null);
        add(aircraft_idCombo);
        aircraft_idCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setVisible(false);
            }
        });

        departure_cityLabel = new JLabel("DEPARTURE CITY ID");
        departure_cityLabel.setBounds(100, 100, 300, 30);
        add(departure_cityLabel);

        departure_cityCombo = new JComboBox(aircraft_idS2);
        departure_cityCombo.setSelectedItem(null);
        departure_cityCombo.setBounds(100, 150, 300, 30);
        add(departure_cityCombo);
        departure_cityCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setVisible(false);
            }
        });

        arrival_cityLabel = new JLabel("ARRIVAL CITY ID");
        arrival_cityLabel.setBounds(100, 200, 300, 30);
        add(arrival_cityLabel);

        arrival_cityCombo = new JComboBox(aircraft_idS2);
        arrival_cityCombo.setSelectedItem(null);
        arrival_cityCombo.setBounds(100, 250, 300, 30);
        add(arrival_cityCombo);
        arrival_cityCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setVisible(false);
            }
        });

        back = new JButton("BACK");
        back.setBounds(275, 400, 200, 50);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getBuyTicket().setVisible(false);
                main.getCassirMenu().setVisible(true);
            }
        });
        search = new JButton("SEARCH FOR TICKET");
        search.setBounds(25, 400, 200, 50);
        add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                available_flight_ids = new ArrayList<>();
                available_tickets_id = new ArrayList<>();
                int z = 0;
                for (int i = 0; i < main.sendListF("flights").size(); i++) {
                    if (main.sendListF("flights").get(i).aircraft_id == Integer.parseInt((String) aircraft_idCombo.getSelectedItem()) && main.sendListF("flights").get(i).departure_city_id == Integer.parseInt((String) departure_cityCombo.getSelectedItem()) && main.sendListF("flights").get(i).arrival_city_id == Integer.parseInt((String) arrival_cityCombo.getSelectedItem())) {
                        available_flight_ids.add(main.sendListF("flights").get(i).id);
                    }
                }
                for (int i = 0; i < available_flight_ids.size(); i++) {
                    for (int j = 0; j < main.sendListT("tickets").size(); j++) {
                        if (available_flight_ids.get(i).equals(main.sendListT("tickets").get(j).flight_id)) {
                            available_tickets_id.add(main.sendListT("tickets").get(j).flight_id);
                            z = 1;
                        }
                    }

                }
                if (z == 0) {
                    error.setVisible(true);
                }
                if (z == 1) {
                    main.getBuyTicket().setVisible(false);
                    main.getSearchTicket().setVisible(true);
                }
                for (int i = 0; i < available_tickets_id.size(); i++) {
                    main.getSearchTicket().availavble_ticketsCombo.addItem(available_tickets_id.get(i));

                }
            }
        });
    }
}
