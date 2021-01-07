package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCitiesParameter extends JPanel {
    AdminGUI main;
    JLabel id;
    JTextField idField;
    JButton back;
    JButton next;
    JLabel parameter;
    JTextField parameterField;

    public EditCitiesParameter(AdminGUI main) {
        this.main = main;

        setSize(500, 500);
        setLayout(null);

        id = new JLabel("ID");
        id.setBounds(100, 100, 300, 40);
        add(id);

        idField = new JTextField();
        idField.setBounds(200, 100, 100, 40);
        add(idField);

        parameter = new JLabel("PARAMETER");
        parameter.setBounds(100, 150, 300, 40);
        add(parameter);

        parameterField = new JTextField();
        parameterField.setBounds(200, 150, 100, 40);
        add(parameterField);

        back = new JButton("BACK");
        back.setBounds(275, 200, 100, 40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditPage().setVisible(true);
                main.getEditCitiesParameter().setVisible(false);
            }
        });

        next = new JButton("NEXT");
        next.setBounds(125, 200, 100, 40);
        add(next);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parameterField.getText().equals("name") || parameterField.getText().equals("country") || parameterField.getText().equals("short_name")) {
                    main.getEditCitiesParameter().setVisible(false);
                    main.getEditCitiesString().setVisible(true);
                }
                if (parameter.getText().equals("id")) {
                    main.getEditCitiesParameter().setVisible(false);
                    main.getEditCitiesInt().setVisible(true);
                }
            }
        });
    }
}
