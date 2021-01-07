package Admin;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditFlightsParameter extends JPanel {
    AdminGUI main;
    JLabel idFlight;
    JTextField idFlightField;
    JButton back;
    JButton next;
    JLabel parameterFlight;
    JTextField parameterFlightField;
    int z = 0;
    int c = 0;
    int v = 0;

    public EditFlightsParameter(AdminGUI main) {
        this.main = main;

        setSize(500, 500);
        setLayout(null);

        idFlight = new JLabel("ID");
        idFlight.setBounds(100, 50, 300, 30);
        add(idFlight);

        idFlightField = new JTextField();
        idFlightField.setBounds(100, 100, 300, 30);
        add(idFlightField);

        parameterFlight = new JLabel("PARAMETER");
        parameterFlight.setBounds(100, 150, 300, 30);
        add(parameterFlight);

        parameterFlightField = new JTextField();
        parameterFlightField.setBounds(100, 200, 300, 30);
        add(parameterFlightField);

        back = new JButton("BACK");
        back.setBounds(275, 250, 100, 30);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditPage().setVisible(true);
                main.getEditFlightsParameter().setVisible(false);
            }
        });

        next = new JButton("NEXT");
        next.setBounds(125, 250, 100, 30);
        add(next);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parameterFlightField.getText().equals("id") || parameterFlightField.getText().equals("econom_place_price") || parameterFlightField.getText().equals("business_place_price")) {
                    main.getEditFlightsParameter().setVisible(false);
                    main.getEditFlightsInt().setVisible(true);
                }
                if (parameterFlightField.getText().equals("departure time")) {
                    main.getEditFlightsParameter().setVisible(false);
                    main.getEditFlightsString().setVisible(true);

                }
                if (parameterFlightField.getText().equals("departure_city_id")) {
                    main.getEditFlightsParameter().setVisible(false);
                    main.getEditFlightDepartureCityID().setVisible(true);
                    String[] list = new String[main.sendListC("cities").size()];
                    for (int i = 0; i < main.sendListC("cities").size(); i++) {
                        list[i] = String.valueOf(main.sendListC("cities").get(i).id);
                    }
                    if (list.length > main.getEditFlightDepartureCityID().enterCombo.getItemCount()) {
                        main.getEditFlightDepartureCityID().enterCombo.addItem(list[list.length - 1]);
                    }
                    if (list.length < main.getEditFlightDepartureCityID().enterCombo.getItemCount()) {
                        ArrayList<String> impostors = new ArrayList<>();
                        for (int i = 0; i < main.getEditFlightDepartureCityID().enterCombo.getItemCount(); i++) {
                            int notcorrect = 0;
                            for (int k = 0; k < list.length; k++) {
                                if (main.getEditFlightDepartureCityID().enterCombo.getItemAt(i).equals(list[k])) {
                                } else {
                                    notcorrect++;
                                }
                            }
                            if (notcorrect++ == list.length) {
                                impostors.add((String) main.getEditFlightDepartureCityID().enterCombo.getItemAt(i));
                            }
                        }
                        main.getEditFlightDepartureCityID().enterCombo.removeItem(impostors.get(z));
                        z++;
                    }

                }
                if (parameterFlightField.getText().equals("arrival_city_id")) {
                    main.getEditFlightsParameter().setVisible(false);
                    main.getEditFligthArrivalCityID().setVisible(true);
                    String[] list = new String[main.sendListC("cities").size()];
                    for (int i = 0; i < main.sendListC("cities").size(); i++) {
                        list[i] = String.valueOf(main.sendListC("cities").get(i).id);
                    }
                    if (list.length > main.getEditFligthArrivalCityID().enterArrivalCombo.getItemCount()) {
                        main.getEditFligthArrivalCityID().enterArrivalCombo.addItem(list[list.length - 1]);
                    }
                    if (list.length < main.getEditFligthArrivalCityID().enterArrivalCombo.getItemCount()) {
                        ArrayList<String> impostors = new ArrayList<>();
                        for (int i = 0; i < main.getEditFligthArrivalCityID().enterArrivalCombo.getItemCount(); i++) {
                            int notcorrect = 0;
                            for (int t = 0; t < list.length; t++) {
                                if (main.getEditFligthArrivalCityID().enterArrivalCombo.getItemAt(i).equals(list[t])) {
                                } else {
                                    notcorrect++;
                                }
                            }
                            if (notcorrect == list.length) {
                                impostors.add((String) main.getEditFligthArrivalCityID().enterArrivalCombo.getItemAt(i));
                            }
                        }
                        main.getEditFligthArrivalCityID().enterArrivalCombo.removeItem(impostors.get(c));
                        c++;
                    }
                }
                if (parameterFlightField.getText().equals("aircraft_id")) {
                    main.getEditFlightsParameter().setVisible(false);
                    main.getEditFlightAircraftId().setVisible(true);
                    String[] list = new String[main.sendListA("aircrafts").size()];
                    for (int i = 0; i < main.sendListA("aircrafts").size(); i++) {
                        list[i] = String.valueOf(main.sendListA("aircrafts").get(i).id);
                    }
                    if (list.length > main.getEditFlightAircraftId().enterAircraftIDCombo.getItemCount()) {
                        main.getEditFlightAircraftId().enterAircraftIDCombo.addItem(list[list.length - 1]);
                    }
                    if (list.length < main.getEditFlightAircraftId().enterAircraftIDCombo.getItemCount()) {
                        ArrayList<String> impostors = new ArrayList<>();
                        for (int i = 0; i < main.getEditFlightAircraftId().enterAircraftIDCombo.getItemCount(); i++) {
                            int notcorrect = 0;
                            for (int j = 0; j < list.length; j++) {
                                if (main.getEditFlightAircraftId().enterAircraftIDCombo.getItemAt(i).equals(list[j])) {
                                } else {
                                    notcorrect++;
                                }
                            }
                            if (notcorrect == list.length) {
                                impostors.add((String) main.getEditFlightAircraftId().enterAircraftIDCombo.getItemAt(i));
                            }
                        }
                        main.getEditFlightAircraftId().enterAircraftIDCombo.removeItem(impostors.get(v));
                        v++;
                    }
                }
            }
        });
    }
}
