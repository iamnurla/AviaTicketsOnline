package Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFlightDepartureCityID extends JPanel {
    AdminGUI main;
    JButton edit;
    JButton back;
    JLabel enterDepatrure;
    JComboBox enterCombo;
    String[] departure_city_ids;

    public EditFlightDepartureCityID(AdminGUI main){
        this.main = main;

        setSize(500,500);
        setLayout(null);

        departure_city_ids = new String[main.sendListC("cities").size()];
        for (int i = 0; i < main.sendListC("cities").size(); i++) {
            departure_city_ids[i] = String.valueOf(main.sendListC("cities").get(i).id);
        }

        enterDepatrure = new JLabel("DEPARTURE CITY ID");
        enterDepatrure.setBounds(100, 100, 300, 30);
        add(enterDepatrure);

        enterCombo = new JComboBox(departure_city_ids);
        enterCombo.setBounds(100,150,300,30);
        add(enterCombo);

        back = new JButton("BACK");
        back.setBounds(275, 400, 100, 30);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditFlightsParameter().setVisible(true);
                main.getEditFlightDepartureCityID().setVisible(false);
            }
        });

        edit = new JButton("EDIT");
        edit.setBounds(125, 400, 100, 30);
        add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main.getEditFlightsParameter().parameterFlightField.getText().equals("departure_city_id")) {
                    int departure_city_id = 0;
                    Flights flight = null;
                    for (int i = 0; i < main.sendListF("flights").size(); i++) {
                        if (main.sendListF("flights").get(i).id == Integer.parseInt(main.getEditFlightsParameter().idFlightField.getText())) {
                            departure_city_id = Integer.parseInt((String) enterCombo.getSelectedItem());
                            flight = main.sendListF("flights").get(i);
                        }
                    }
                    main.FlightEditInt("departure_city_id", flight, departure_city_id);
                    enterCombo.setSelectedIndex(0);
                    main.getEditFlightsParameter().parameterFlightField.setText("");
                    main.getEditFlightsParameter().idFlightField.setText("");
                }
            }
        });
    }
}
