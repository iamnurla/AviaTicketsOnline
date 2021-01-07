package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BuySelectedTicket extends JPanel {
    CassirFrame main;
    Ticket selected_ticket;
    Flights selected_flights;
    Aircrafts selected_aircrafts;
    JLabel Cost;
    JButton back;
    JButton buy;


    public BuySelectedTicket(CassirFrame main){
        this.main = main;

        setSize(500,500);
        setLayout(null);

        Cost = new JLabel();
        Cost.setBounds(100,100,300,30);
        add(Cost);

        back = new JButton("BACK");
        back.setBounds(150,400,200,50);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getBuySelectedTicket().setVerifyInputWhenFocusTarget(false);
                main.getSearchTicket().setVisible(true);
            }
        });

        buy = new JButton("BUY");
        buy.setBounds(150,300,200,50);
        add(buy);
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selected_ticket.ticket_type.equals("EconomyClass")) {
                    main.DeleteAircraft(selected_aircrafts);
                    try {
                        main.addAircraft(new Aircrafts(selected_aircrafts.id,selected_aircrafts.name,selected_aircrafts.model,selected_aircrafts.business_class_capacity-1,selected_aircrafts.econom_class_capacity));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                if(selected_ticket.ticket_type.equals("BusinessCLass")){
                    try{
                        main.DeleteAircraft(selected_aircrafts);
                        main.addAircraft(new Aircrafts(selected_aircrafts.id,selected_aircrafts.name,selected_aircrafts.model,selected_aircrafts.business_class_capacity-1,selected_aircrafts.econom_class_capacity));
                    }catch (Exception ee){
                        ee.printStackTrace();
                    }
                }
            }
        });

    }
}
