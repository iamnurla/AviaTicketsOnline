package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCities extends JPanel {
    AdminGUI parent;
    public AddCities(AdminGUI parent){
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        JLabel idCities = new JLabel("ID ");
        idCities.setBounds(100,50,100,40);
        add(idCities);

        JTextField idCitiesF = new JTextField();
        idCitiesF.setBounds(200,50,250,40);
        add(idCitiesF);

        JLabel nameCities = new JLabel("Name ");
        nameCities.setBounds(100,100,100,40);
        add(nameCities);

        JTextField nameCitiesF = new JTextField();
        nameCitiesF.setBounds(200,100,250,40);
        add(nameCitiesF);

        JLabel countryCities = new JLabel("Country");
        countryCities.setBounds(100,150,100,40);
        add(countryCities);

        JTextField countryCitiesF = new JTextField();
        countryCitiesF.setBounds(200,150,250,40);
        add(countryCitiesF);

        JLabel shortnameCities = new JLabel("Short name");
        shortnameCities.setBounds(100,200,100,40);
        add(shortnameCities);

        JTextField shortnameCitiesF = new JTextField();
        shortnameCitiesF.setBounds(200,200,250,40);
        add(shortnameCitiesF);

        JButton addButtonCities = new JButton("ADD");
        addButtonCities.setBounds(150,260,250,40);
        add(addButtonCities);

        addButtonCities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(idCitiesF.getText());
                idCitiesF.setText("");
                String name = nameCitiesF.getText();
                nameCitiesF.setText("");
                String country = countryCitiesF.getText();
                countryCitiesF.setText("");
                String shortname = shortnameCitiesF.getText();
                shortnameCitiesF.setText("");

                Cities cities = new Cities(id,name,country,shortname);
                CitiesDate cd = new CitiesDate("ADD",cities);
                parent.addCities(cd);
            }
        });

        JButton backButtonCities = new JButton("BACK");
        backButtonCities.setBounds(150,310,250,40);
        add(backButtonCities);
        backButtonCities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.adminSecondPage.setVisible(true);
                parent.addCities.setVisible(false);
            }
        });

    }
}
