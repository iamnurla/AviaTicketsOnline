package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CitiesDelete extends JPanel {
    AdminGUI main;
    JButton deleteButton;
    JButton back;
    JButton exit;

    public CitiesDelete(AdminGUI main){
        this.main = main;
        setSize(500,500);
        setLayout(null);

        JLabel nameLabel=new JLabel("ID");
        nameLabel.setSize(100,40);
        nameLabel.setLocation(150,150);
        add(nameLabel);

        JTextField nameLong=new JTextField();
        nameLong.setBounds(200, 150,200,40);
        add(nameLong);

        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(100,200,300,40);
        add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cities cities = new Cities(Integer.parseInt(nameLong.getText()),null,null,null);
                main.DeleteCities(cities);
                nameLong.setText("");
            }
        });
        back = new JButton("BACK");
        back.setBounds(100,250,300,40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.citiesDelete.setVisible(false);
                main.deletePage.setVisible(true);
            }
        });
        exit = new JButton("EXIT");
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
