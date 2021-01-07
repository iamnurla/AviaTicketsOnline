package Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlightDelete extends JPanel {
    AdminGUI main;
    JButton deleteButton;
    JButton back;

    public FlightDelete(AdminGUI main) {
        this.main = main;
        setSize(500,500);
        setLayout(null);

        JLabel nameLabel = new JLabel("ID");
        nameLabel.setSize(100, 40);
        nameLabel.setLocation(150, 150);
        add(nameLabel);

        JTextField nameLong = new JTextField();
        nameLong.setBounds(200, 150, 200, 40);
        add(nameLong);

        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(100, 200, 300, 40);
        add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flights flights = new Flights(Integer.parseInt(nameLong.getText()), 0, 0, 0, null, 0, 0);
                main.DeleteFlight(flights);
                nameLong.setText("");
            }
        });
        back = new JButton("BACK");
        back.setBounds(100,250,300,40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.flightDelete.setVisible(false);
                main.deletePage.setVisible(true);
            }
        });
        JButton exit = new JButton("EXIT");
        exit.setBounds(100,300,300,40);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
