package Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCitiesString extends JPanel {
    AdminGUI main;
    JLabel enterString;
    JTextField enterStringField;
    JButton back;
    JButton edit;


    public EditCitiesString(AdminGUI main){
        this.main = main;

        setSize(500,500);
        setLayout(null);

        enterString = new JLabel("ENTER STRING");
        enterString.setBounds(100,150,300,40);
        add(enterString);

        enterStringField = new JTextField();
        enterStringField.setBounds(200, 150, 100, 30);
        add(enterStringField);


        back = new JButton("BACK");
        back.setBounds(275, 200, 100, 30);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditCitiesParameter().setVisible(true);
                main.getEditCitiesString().setVisible(false);
            }
        });

        edit = new JButton("EDIT");
        edit.setBounds(125, 200, 100, 30);
        add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(main.getEditCitiesParameter().parameterField.getText().equals("name")){
                    String name  = "";
                    Cities cities = null;
                    for(int i =0; i<main.sendListC("cities").size();i++){
                        if(main.sendListC("cities").get(i).id == Integer.parseInt(main.getEditCitiesParameter().idField.getText())){
                            name = enterStringField.getText();
                            cities = main.sendListC("cities").get(i);
                        }
                    }
                    main.EditCitiesString("name",cities,name);
                    enterStringField.setText("");
                    main.getEditAircraftParameter().parameterField.setText("");
                    main.getEditAircraftParameter().idField.setText("");
                }if(main.getEditCitiesParameter().parameterField.getText().equals("country")){
                    String country  = "";
                    Cities city = null;
                    for(int i =0; i<main.sendListC("cities").size();i++){
                        if(main.sendListC("cities").get(i).id == Integer.parseInt(main.getEditCitiesParameter().idField.getText())){
                            country = enterStringField.getText();
                            city = main.sendListC("cities").get(i);
                        }
                    }
                    main.EditCitiesString("country",city,country);
                    enterStringField.setText("");
                    main.getEditAircraftParameter().parameterField.setText("");
                    main.getEditAircraftParameter().idField.setText("");
                }if(main.getEditCitiesParameter().parameterField.getText().equals("short_name")) {
                    String short_name = "";
                    Cities city = null;
                    for (int i = 0; i < main.sendListC("cities").size(); i++) {
                        if (main.sendListC("cities").get(i).id == Integer.parseInt(main.getEditCitiesParameter().id.getText())) {
                            short_name = enterStringField.getText();
                            city = main.sendListC("cities").get(i);
                        }
                    }
                    main.EditCitiesString("short_name", city, short_name);
                    enterStringField.setText("");
                    main.getEditAircraftParameter().parameterField.setText("");
                    main.getEditAircraftParameter().idField.setText("");
                }
            }
        });
    }
}
