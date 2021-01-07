package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAircraftInt extends JPanel {
    AdminGUI main;
    JLabel enterInt;
    JTextField enterIntField;
    JButton back;
    JButton edit;


    public EditAircraftInt(AdminGUI main){
        this.main = main;

        setSize(500,500);
        setLayout(null);

        enterInt = new JLabel("ENTER INT");
        enterInt.setBounds(100,100,300,40);
        add(enterInt);

        enterIntField = new JTextField();
        enterIntField.setBounds(100,150,300,40);
        add(enterIntField);

        back = new JButton("BACK");
        back.setBounds(125,270,100,40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditAircraftParameter().setVisible(true);
                main.getEditAircraftInt().setVisible(false);

            }
        });

        edit = new JButton("EDIT");
        edit.setBounds(275,270,100,40);
        add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(main.getEditAircraftParameter().parameterField.getText().equals("id")){
                    int id = 0;
                    Aircrafts aircrafts = null;
                    for (int i = 0;i<main.sendListA("aircrafts").size();i++){
                        if(main.sendListA("aircrafts").get(i).id == Integer.parseInt(main.getEditAircraftParameter().idField.getText())){
                            System.out.println("id found");
                            id = Integer.parseInt(enterIntField.getText());
                            aircrafts = main.sendListA("aircrafts").get(i);
                        }
                    }
                    main.EditAircraftInt("id",aircrafts,id);
                    enterIntField.setText("");
                    main.getEditAircraftParameter().parameterField.setText("");
                    main.getEditAircraftParameter().idField.setText("");
                }if(main.getEditAircraftParameter().parameterField.getText().equals("business_class_capacity")){
                    int business_class_capacity = 0;
                    Aircrafts aircrafts = null;
                    for(int i = 0;i<main.sendListA("aircrafts").size();i++){
                        if(main.sendListA("aircrafts").get(i).id == Integer.parseInt(main.getEditAircraftParameter().idField.getText())){
                            business_class_capacity = Integer.parseInt(enterIntField.getText());
                            aircrafts = main.sendListA("aircrafts").get(i);
                        }
                    }
                    main.EditAircraftInt("business_class_capacity",aircrafts,business_class_capacity);
                    enterIntField.setText("");
                    main.getEditAircraftParameter().parameterField.setText("");
                    main.getEditAircraftParameter().idField.setText("");
                }if(main.getEditAircraftParameter().parameterField.getText().equals("econom_class_capacity")){
                    int econom_class_capacity = 0;
                    Aircrafts aircrafts = null;
                    for (int i=0; i<main.sendListA("aircrafts").size();i++){
                        if(main.sendListA("aircrafts").get(i).id == Integer.parseInt(main.getEditAircraftParameter().idField.getText())){
                            econom_class_capacity = Integer.parseInt(enterIntField.getText());
                            aircrafts = main.sendListA("aircrafts").get(i);
                        }
                    }
                    main.EditAircraftInt("econom_class_capacity",aircrafts,econom_class_capacity);
                    enterIntField.setText("");
                    main.getEditAircraftParameter().parameterField.setText("");
                    main.getEditAircraftParameter().idField.setText("");
                }
            }
        });

    }

}
