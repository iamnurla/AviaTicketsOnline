package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFlightsInt extends JPanel {
    AdminGUI main;
    JLabel enterInt;
    JTextField enterField;
    JButton back;
    JButton edit;

    public EditFlightsInt(AdminGUI main){
        this.main = main;

        setSize(500,500);
        setLayout(null);

        enterInt = new JLabel("ENTER INT");
        enterInt.setBounds(100, 100, 300, 30);
        add(enterInt);

        enterField = new JTextField();
        enterField.setBounds(100, 150, 300, 30);
        add(enterField);

        back = new JButton("BACK");
        back.setBounds(275, 200, 100, 30);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditFlightsInt().setVisible(false);
                main.getEditFlightsParameter().setVisible(true);
            }
        });

        edit = new JButton("EDIT");
        edit.setBounds(125, 200, 100, 30);
        add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(main.getEditFlightsParameter().parameterFlightField.getText().equals("id")){
                    int id = 0;
                    Flights flights = null;
                    for(int i =0; i<main.sendListF("flights").size();i++){
                        if(main.sendListF("flights").get(i).id == Integer.parseInt(main.getEditFlightsParameter().idFlightField.getText())){
                            id = Integer.parseInt(enterField.getText());
                            flights = main.sendListF("flights").get(i);
                        }
                    }
                    main.FlightEditInt("id",flights,id);
                    enterField.setText("");
                    main.getEditFlightsParameter().parameterFlightField.setText("");
                    main.getEditFlightsParameter().idFlightField.setText("");
                }if(main.getEditFlightsParameter().parameterFlightField.getText().equals("econom_place_price")){
                    int eco=0;
                    Flights flights = null;
                    for(int i = 0; i<main.sendListF("flights").size();i++){
                        if(main.sendListF("flights").get(i).id == Integer.parseInt(main.getEditFlightsParameter().idFlightField.getText())){
                            eco = Integer.parseInt(enterField.getText());
                            flights = main.sendListF("flights").get(i);
                        }
                    }
                    main.FlightEditInt("econom_place_price",flights,eco);
                    enterField.setText("");
                    main.getEditFlightsParameter().parameterFlightField.setText("");
                    main.getEditFlightsParameter().idFlightField.setText("");
                }
                if(main.getEditFlightsParameter().parameterFlightField.getText().equals("business_place_price")){
                    int bus=0;
                    Flights flights = null;
                    for(int i = 0; i<main.sendListF("flights").size();i++){
                        if(main.sendListF("flights").get(i).id == Integer.parseInt(main.getEditFlightsParameter().idFlightField.getText())){
                            bus = Integer.parseInt(enterField.getText());
                            flights = main.sendListF("flights").get(i);
                        }
                    }
                    main.FlightEditInt("business_place_price",flights,bus);
                    enterField.setText("");
                    main.getEditFlightsParameter().parameterFlightField.setText("");
                    main.getEditFlightsParameter().idFlightField.setText("");
                }
            }
        });

    }
}
