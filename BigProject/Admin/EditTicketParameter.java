package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTicketParameter extends JPanel {
    CassirFrame main;
    JLabel id;
    JButton back;
    JTextField idField;
    JButton next;
    JLabel parameterLabel;
    JTextField parameterField;

    public EditTicketParameter(CassirFrame main){
        this.main = main;

        setSize(500,500);
        setLayout(null);

        id = new JLabel("ID");
        id.setBounds(100,50,300,30);
        add(id);

        idField = new JTextField();
        idField.setBounds(100,100,300,30);
        add(idField);

        parameterLabel = new JLabel("PARAMETER");
        parameterLabel.setBounds(100,150,300,30);
        add(parameterLabel);

        parameterField = new JTextField();
        parameterField.setBounds(100,200,300,30);
        add(parameterField);

        back = new JButton("BACK");
        back.setBounds(275,400,100,30);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getTicketMenu().setVisible(true);
                main.getEditTicketParameter().setVisible(false);
            }
        });

        next = new JButton("NEXT");
        next.setBounds(125,400,100,30);
        add(next);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(parameterField.getText().equals("name") || parameterField.getText().equals("surname") || parameterField.getText().equals("passport_number")||parameterField.getText().equals("ticket_type")){
                    main.getEditTicketParameter().setVisible(false);
                    main.getEditTicketString().setVisible(true);
                }
                if(parameterField.getText().equals("id")||parameterField.getText().equals("flight_id")) {
                    main.getEditTicketParameter().setVisible(false);
                    main.getEditTicketInt().setVisible(true);
                }
            }
        });

    }
}
