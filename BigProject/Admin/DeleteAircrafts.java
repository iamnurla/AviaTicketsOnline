package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteAircrafts extends JPanel {
    AdminGUI main;
    JButton deleteButton;
    JButton back;

    public DeleteAircrafts(AdminGUI main) {
        this.main = main;
        setSize(500, 500);
        setLayout(null);

        JLabel nameLabel = new JLabel("ID");
        nameLabel.setBounds(150, 150, 100, 40);
        add(nameLabel);

        JTextField id = new JTextField();
        id.setBounds(200, 150, 200, 40);
        add(id);

        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(100, 200, 300, 40);
        add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Aircrafts aircraft = new Aircrafts(Integer.parseInt(id.getText()), null, null, 0, 0);
                    main.DeleteAircraft(aircraft);
                    id.setText("");
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });

        back = new JButton("BACK");
        back.setBounds(100, 250, 300, 40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getDeletePage().setVisible(true);
                main.getDeleteAircrafts().setVisible(false);
            }
        });

        JButton exit = new JButton("EXIT");
        exit.setBounds(100, 300, 300, 40);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
