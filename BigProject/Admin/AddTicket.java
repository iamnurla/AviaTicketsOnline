package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTicket extends JPanel {
    CassirFrame main;
    JButton back;
    JButton add;
    JLabel flight_idLabel;
    JComboBox flight_idCombo;
    JLabel idLabel;
    JTextField idField;
    JLabel nameLabel;
    JTextField nameField;
    JLabel surnameLabel;
    JTextField surnameField;
    JLabel passport_numberLabel;
    JTextField passport_numberField;
    JLabel ticket_typeLabel;
    JComboBox ticket_typeCombo;
    String[] type = new String[2];
    String[] flight_ids;

    public AddTicket(CassirFrame main){
        type[0] = "Economy Class";
        type[1] = "Business Class";
        this.main = main;

        setSize(500,500);
        setLayout(null);

        flight_ids = new String[main.sendListF("flights").size()];
        for(int i =0;i <main.sendListF("flights").size();i++){
            flight_ids[i] = String.valueOf(main.sendListF("flights").get(i).id);
        }
        flight_idCombo = new JComboBox(flight_ids);
        flight_idCombo.setBounds(10,120,180,30);
        add(flight_idCombo);
        flight_idCombo.setSelectedItem(null);

        idLabel = new JLabel("ID");
        idLabel.setBounds(10,10,180,30);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(10,45,180,30);
        add(idField);

        flight_idLabel = new JLabel("FLIGHT");
        flight_idLabel.setBounds(10,85,180,30);
        add(flight_idLabel);

        nameLabel= new JLabel("NAME");
        nameLabel.setBounds(10,160,180,30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(10,195,180,30);
        add(nameField);

        surnameLabel = new JLabel("SURNAME");
        surnameLabel.setBounds(290,10,180,30);
        add(surnameLabel);

        surnameField = new JTextField();
        surnameField.setBounds(290,45,180,30);
        add(surnameField);

        passport_numberLabel= new JLabel("PASSPORT NUMBER");
        passport_numberLabel.setBounds(290,85,180,30);
        add(passport_numberLabel);

        passport_numberField = new JTextField();
        passport_numberField.setBounds(290,120,180,30);
        add(passport_numberField);

        ticket_typeLabel = new JLabel("TICKET TYPE");
        ticket_typeLabel.setBounds(290,160,180,30);
        add(ticket_typeLabel);

        ticket_typeCombo = new JComboBox(type);
        ticket_typeCombo.setBounds(290,195,180,30);
        add(ticket_typeCombo);
        ticket_typeCombo.setSelectedItem(null);

        add = new JButton("ADD");
        add.setBounds(125,400,100,30);
        add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ticket ticket = new Ticket(Integer.parseInt(idField.getText()), main.sendListF("flights").get(flight_idCombo.getSelectedIndex()).id, nameField.getText(), surnameField.getText(), passport_numberField.getText(), type[ticket_typeCombo.getSelectedIndex()]);
                main.addTicket(ticket);
                idField.setText("");
                nameField.setText("");
                surnameField.setText("");
                passport_numberField.setText("");
                flight_idCombo.setSelectedItem(null);
                ticket_typeCombo.setSelectedItem(null);

            }
        });

        back = new JButton("BACK");
        back.setBounds(275,400,100,30);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getTicketMenu().setVisible(true);
                main.getAddTicket().setVisible(false);
            }
        });
    }
}
