package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTicketString extends JPanel {
    CassirFrame main;
    JLabel enterLabel;
    JTextField enterField;
    JButton back;
    JButton edit;

    public EditTicketString(CassirFrame main) {
        this.main = main;

        setSize(500, 500);
        setLayout(null);

        enterLabel = new JLabel("ENTER STRING");
        enterLabel.setBounds(100, 100, 300, 40);
        add(enterLabel);

        enterField = new JTextField();
        enterField.setBounds(100, 150, 300, 30);
        add(enterField);

        back = new JButton("BACK");
        back.setBounds(275, 400, 100, 30);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditTicketParameter().setVisible(true);
                main.getEditTicketString().setVisible(false);
            }
        });

        edit = new JButton("EDIT");
        edit.setBounds(125, 400, 100, 30);
        add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (main.getEditTicketParameter().parameterField.getText().equals("name")) {
                    String name = "";
                    Ticket ticket = null;
                    for (int i = 0; i < main.sendListT("tickets").size(); i++) {
                        if (main.sendListT("tickets").get(i).id == Integer.parseInt(main.getEditTicketParameter().idField.getText())) {
                            name = enterField.getText();
                            ticket = main.sendListT("tickets").get(i);
                        }
                    }
                    main.EditTicketsString("name", ticket, name);
                    enterField.setText("");
                    main.getEditTicketParameter().parameterField.setText("");
                    main.getEditTicketParameter().idField.setText("");
                }
                if (main.getEditTicketParameter().parameterField.getText().equals("surname")) {
                    String surname = "";
                    Ticket ticket = null;
                    for (int i = 0; i < main.sendListT("tickets").size(); i++) {
                        if (main.sendListT("tickets").get(i).id == Integer.parseInt(main.getEditTicketParameter().id.getText())) {
                            surname = enterField.getText();
                            ticket = main.sendListT("tickets").get(i);
                        }
                    }
                    main.EditTicketsString("surname", ticket, surname);
                    enterField.setText("");
                    main.getEditTicketParameter().parameterField.setText("");
                    main.getEditTicketParameter().idField.setText("");
                }
                if (main.getEditTicketParameter().parameterField.getText().equals("passport_number")) {
                    String passport = "";
                    Ticket ticket = null;
                    for (int i = 0; i < main.sendListT("tickets").size(); i++) {
                        if (main.sendListT("tickets").get(i).id == Integer.parseInt(main.getEditTicketParameter().id.getText())) {
                            passport = enterField.getText();
                            ticket = main.sendListT("tickets").get(i);
                        }
                    }
                    main.EditTicketsString("passport_number", ticket, passport);
                    enterField.setText("");
                    main.getEditTicketParameter().parameterField.setText("");
                    main.getEditTicketParameter().idField.setText("");
                }
                if (main.getEditTicketParameter().parameterField.getText().equals("ticket_type")) {
                    String tickets = "";
                    Ticket ticket = null;
                    for (int i = 0; i < main.sendListT("tickets").size(); i++) {
                        if (main.sendListT("tickets").get(i).id == Integer.parseInt(main.getEditTicketParameter().id.getText())) {
                            tickets = enterField.getText();
                            ticket = main.sendListT("tickets").get(i);
                        }
                    }
                    main.EditTicketsString("ticket_type", ticket, tickets);
                    enterField.setText("");
                    main.getEditTicketParameter().parameterField.setText("");
                    main.getEditTicketParameter().idField.setText("");
                }

            }
        });

    }
}
