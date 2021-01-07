package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCitiesInt extends JPanel {
    AdminGUI main;
    JLabel enterInt;
    JTextField enterIntField;
    JButton back;
    JButton edit;

    public EditCitiesInt(AdminGUI main){
        this.main = main;

        setSize(500,500);
        setLayout(null);

        enterInt = new JLabel("ENTER INT");
        enterInt.setBounds(100,100,300,30);
        add(enterInt);

        enterIntField = new JTextField();
        enterInt.setBounds(100,150,300,30);
        add(enterIntField);

        back = new JButton("BACK");
        back.setBounds(275,400,100,30);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditCitiesParameter().setVisible(true);
                main.getEditCitiesInt().setVisible(false);
            }
        });

        edit = new JButton("EDIT");
        edit.setBounds(125,400,100,30);
        add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(main.getEditCitiesParameter().parameterField.getText().equals("id")){
                    int id = 0;
                    Cities city = null;
                    for(int i =0; i<main.sendListC("cities").size();i++){
                        if(main.sendListC("cities").get(i).id == Integer.parseInt(main.getEditCitiesParameter().idField.getText())){
                            System.out.println("id found");
                            id = Integer.parseInt(enterIntField.getText());
                            city = main.sendListC("cities").get(i);
                        }
                    }
                    main.EditCitiesInt("id",city,id);
                    enterIntField.setText("");
                    main.getEditAircraftParameter().parameterField.setText("");
                    main.getEditAircraftParameter().idField.setText("");
                }

            }
        });
    }
}
