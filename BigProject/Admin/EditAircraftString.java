package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAircraftString extends JPanel {
    AdminGUI main;
    JLabel enterString;
    JTextField enterStringField;

    public EditAircraftString(AdminGUI main) {
        this.main = main;

        setSize(500, 500);
        setLayout(null);

        enterString = new JLabel("ENTER STRING");
        enterString.setBounds(100, 100, 300, 40);
        add(enterString);

        enterStringField = new JTextField();
        enterStringField.setBounds(100, 150, 300, 40);
        add(enterStringField);

        JButton back = new JButton("BACK");
        back.setBounds(100, 200, 300, 40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.editAircraftParameter.setVisible(true);
                main.editAircraftString.setVisible(false);
            }
        });

        JButton edit = new JButton("EDIT");
        edit.setBounds(100, 250, 300, 40);
        add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main.getEditAircraftParameter().parameterField.getText().equals("name")) {
                    String name = "";
                    Aircrafts aircrafts = null;
                    for (int i = 0; i<main.sendListA("aircrafts").size(); i++) {
                        if (main.sendListA("aircrafts").get(i).id == Integer.parseInt(main.getEditAircraftParameter().idField.getText())) {
                            name = (enterStringField.getText());
                            aircrafts = main.sendListA("aircrafts").get(i);
                        }
                    }
                    main.EditAircraftString("name", aircrafts, name);
                    enterStringField.setText("");
                    main.getEditAircraftParameter().parameterField.setText("");
                    main.getEditAircraftParameter().idField.setText("");
                }
                if(main.getEditAircraftParameter().parameterField.getText().equals("model")){
                    String model = "";
                    Aircrafts aircrafts = null;
                    for(int i = 0; i<main.sendListA("aircrafts").size();i++){
                        if(main.sendListA("aircrafts").get(i).id==Integer.parseInt(main.editAircraftParameter.idField.getText())){
                            model = (enterStringField.getText());
                            aircrafts = main.sendListA("aircrafts").get(i);
                        }
                    }
                    main.EditAircraftString("model",aircrafts,model);
                    enterStringField.setText("");
                    main.getEditAircraftParameter().parameterField.setText("");
                    main.getEditAircraftParameter().idField.setText("");
                }

            }
        });


    }
}
