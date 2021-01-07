package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainPage extends JPanel {
    AdminGUI parent;

    public AdminMainPage(AdminGUI parent) {
        this.parent = parent;

        setSize(500, 500);
        setLayout(null);

        JButton addMainButton = new JButton("ADD");
        addMainButton.setBounds(100, 100, 300, 40);
        add(addMainButton);

        addMainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.adminSecondPage.setVisible(true);
                parent.adminMainPage.setVisible(false);
            }
        });

        JButton editMainButton = new JButton("EDIT");
        editMainButton.setBounds(100, 150, 300, 40);
        add(editMainButton);

        editMainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.editPage.setVisible(true);
                parent.adminMainPage.setVisible(false);
            }
        });

        JButton deleteMainButton = new JButton("DELETE");
        deleteMainButton.setBounds(100, 200, 300, 40);
        add(deleteMainButton);
        deleteMainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.deletePage.setVisible(true);
                parent.adminMainPage.setVisible(false);
            }
        });

        deleteMainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton exitMainButton = new JButton("EXIT");
        exitMainButton.setBounds(100, 250, 300, 40);
        add(exitMainButton);
        exitMainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
