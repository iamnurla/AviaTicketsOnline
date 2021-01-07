package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFlightsString  extends JPanel {
    AdminGUI main;
    JLabel enterString;
    JTextField enterStringField;
    JButton back;
    JButton edit;

    public EditFlightsString(AdminGUI main){
        this.main = main;

        setSize(500,500);
        setLayout(null);

        enterString = new JLabel("ENTER STRING");
        enterString.setBounds(100, 100, 300, 30);
        add(enterString);

        enterStringField = new JTextField();
        enterStringField.setBounds(100, 150, 300, 30);
        add(enterStringField);

        back = new JButton("BACK");
        back.setBounds(275, 400, 100, 30);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditFlightsString().setVisible(false);
                main.getEditFlightsParameter().setVisible(true);
            }
        });

        edit = new JButton("EDIT");
        edit.setBounds(125, 400, 100, 30);
        add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main.getEditFlightsParameter().parameterFlightField.getText().equals("departure_time")) {
                    String departure_time = "";
                    Flights flights = null;
                    for (int i = 0; i < main.sendListF("flights").size(); i++) {
                        if (main.sendListF("flights").get(i).id == Integer.parseInt(main.getEditFlightsParameter().idFlightField.getText())) {
                            departure_time = enterStringField.getText();
                            flights =  main.sendListF("flights").get(i);
                        }
                    }
                    main.FlightEditString("departure_time", flights, departure_time);
                    enterStringField.setText("");
                    main.getEditFlightsParameter().parameterFlightField.setText("");
                    main.getEditFlightsParameter().idFlightField.setText("");
                }

            }
        });

    }
}
