package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFlightAircraftId extends JPanel {
    AdminGUI main;
    JButton edit;
    JButton back;
    JLabel enterAircraftID;
    JComboBox enterAircraftIDCombo;
    String[] aircrafts_ids;

    public EditFlightAircraftId(AdminGUI main){
        this.main = main;
        setSize(500,500);
        setLayout(null);

        aircrafts_ids = new String[main.sendListA("aircrafts").size()];
        for(int i =0;i<main.sendListA("aircrafts").size();i++){
            aircrafts_ids[i]= String.valueOf(main.sendListA("aircrafts").get(i).id);
        }

        enterAircraftID = new JLabel("AIRCRAFT ID");
        enterAircraftID.setBounds(100, 100, 300, 30);
        add(enterAircraftID);

        enterAircraftIDCombo = new JComboBox(aircrafts_ids);
        enterAircraftIDCombo.setBounds(100,150,300,30);
        add(enterAircraftIDCombo);

        back = new JButton("BACK");
        back.setBounds(275, 400, 100, 30);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditFlightsParameter().setVisible(true);
                main.getEditFlightAircraftId().setVisible(false);
            }
        });

        edit = new JButton("EDIT");
        edit.setBounds(125, 400, 100, 30);
        add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(main.getEditFlightsParameter().parameterFlightField.getText().equals("aircraft_id")){
                    int aircraft_id = 0;
                    Flights flights = null;
                    for(int i =0; i<main.sendListF("flights").size();i++){
                        if(main.sendListF("flights").get(i).id == Integer.parseInt(main.getEditFlightsParameter().idFlightField.getText())){
                            aircraft_id = Integer.parseInt((String) enterAircraftIDCombo.getSelectedItem());
                            flights = main.sendListF("flights").get(i);
                        }
                    }
                    main.FlightEditInt("aircraft_id",flights,aircraft_id);
                    enterAircraftIDCombo.setSelectedIndex(0);
                    main.getEditFlightsParameter().parameterFlightField.setText("");
                    main.getEditFlightsParameter().idFlightField.setText("");
                }



            }
        });




    }
}
