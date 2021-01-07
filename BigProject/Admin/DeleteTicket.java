package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTicket extends JPanel {
    CassirFrame main;
    JButton addButton;
    JButton back;

    public DeleteTicket(CassirFrame main) {
        this.main = main;

        setSize(500, 500);
        setLayout(null);

        JLabel nameLabel = new JLabel("ID");
        nameLabel.setBounds(100, 100, 100, 40);
        add(nameLabel);

        JTextField idField = new JTextField();
        idField.setBounds(200, 100, 300, 40);
        add(idField);

        addButton = new JButton("DELETE");
        addButton.setBounds(125, 200, 100, 40);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ticket ticket = new Ticket(Integer.parseInt(idField.getText()), 0, null, null, null, null);
                main.deleteTicket(ticket);
                idField.setText("");
            }
        });

        back = new JButton("BACK");
        back.setBounds(275,200,100,40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getTicketMenu().setVisible(true);
                main.getDeleteTicket().setVerifyInputWhenFocusTarget(false);
            }
        });

    }
}
