package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFligthArrivalCityID extends JPanel {
    AdminGUI main;
    JButton edit;
    JButton back;
    JLabel enterArrival;
    JComboBox enterArrivalCombo;
    String [] arrival_city_ids;


    public EditFligthArrivalCityID(AdminGUI main){
        this.main = main;

        setSize(500,500);
        setLayout(null);

        arrival_city_ids = new String[main.sendListC("cities").size()];
        for (int i = 0; i < main.sendListC("cities").size(); i++) {
            arrival_city_ids[i] = String.valueOf(main.sendListC("cities").get(i).id);
        }

        enterArrival= new JLabel("ARRIVAL_CITY_ID");
        enterArrival.setBounds(100, 100, 300, 30);
        add(enterArrival);

        enterArrivalCombo = new JComboBox(arrival_city_ids);
        enterArrivalCombo.setBounds(100,150,300, 30);
        add(enterArrivalCombo);

        back = new JButton("BACK");
        back.setBounds(275, 400, 100, 30);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditFlightsParameter().setVisible(true);
                main.getEditFligthArrivalCityID().setVisible(false);
            }
        });

        edit = new JButton("EDIT");
        edit.setBounds(125, 400, 100, 30);
        add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main.getEditFlightsParameter().parameterFlightField.getText().equals("arrival_city_id")) {
                    int arrival_city_id = 0;
                    Flights flights = null;
                    for (int i = 0; i < main.sendListF("flights").size(); i++) {
                        if (main.sendListF("flights").get(i).id == Integer.parseInt(main.getEditFlightsParameter().idFlightField.getText())) {
                            arrival_city_id = Integer.parseInt((String) enterArrivalCombo.getSelectedItem());
                            flights = main.sendListF("flights").get(i);
                        }
                    }
                    main.FlightEditInt("arrival_city_id", flights, arrival_city_id);
                    enterArrivalCombo.setSelectedIndex(0);
                    main.getEditFlightsParameter().parameterFlightField.setText("");
                    main.getEditFlightsParameter().idFlightField.setText("");
                }
            }
        });


    }
}