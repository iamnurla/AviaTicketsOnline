package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAircraftParameter extends JPanel {
    AdminGUI main;
    JLabel parameter;
    JLabel id;
    JTextField idField;
    JTextField parameterField;


    public EditAircraftParameter(AdminGUI main){
        this.main = main;

        setSize(500,500);
        setLayout(null);


        id = new JLabel("ID");
        id.setBounds(100,100,300,40);
        add(id);

        idField = new JTextField();
        idField.setBounds(100,150,300,40);
        add(idField);

        parameter = new JLabel("PARAMETER");
        parameter.setBounds(100,200,300,40);
        add(parameter);

        parameterField = new JTextField();
        parameterField.setBounds(100,250,300,40);
        add(parameterField);

        JButton next = new JButton("NEXT");
        next.setBounds(125,300,100,40);
        add(next);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(parameterField.getText().equals("name") || parameterField.getText().equals("model")){
                    main.getEditAircraftParameter().setVisible(false) ;
                    main.getEditAircraftString().setVisible(true);
                    if(main.getEditAircraftParameter().parameterField.equals("name")){
                        main.getEditAircraftString().enterString.setText("ENTER NAME");
                    }
                    if (main.getEditAircraftParameter().parameterField.equals("model")){
                        main.getEditAircraftString().enterString.setText("ENTER MODEL");
                    }
                }
                if (parameterField.getText().equals("id") || parameterField.getText().equals("business_class_capacity") || parameterField.getText().equals("econom_class_capacity")){
                    main.getEditAircraftParameter().setVisible(false);
                    main.getEditAircraftInt().setVisible(true);
                    if(main.getEditAircraftParameter().parameterField.equals("id")){
                        main.getEditAircraftInt().enterInt.setText("ENTER ID");
                    }if(main.getEditAircraftParameter().parameterField.equals("business_class_capacity")){
                        main.getEditAircraftInt().enterInt.setText("ENTER BUISNESS CLASS CAPACITY");
                    }if (main.getEditAircraftParameter().parameterField.equals("econom_class_capacity")){
                        main.getEditAircraftInt().enterInt.setText("ENTER ECONOM CLASS CAPACITY");
                    }
                }
            }
        });


        JButton back = new JButton("BACK");
        back.setBounds(275,300,100,40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditAircraftParameter().setVisible(false);
                main.getEditPage().setVisible(true);
            }
        });
    }
}
