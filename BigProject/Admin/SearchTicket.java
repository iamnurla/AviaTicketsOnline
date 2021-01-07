package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchTicket extends JPanel {
    //    public JComboBox<Integer> available_tickets;
    CassirFrame main;
    JButton next;
    JButton back;
    JComboBox availavble_ticketsCombo;
    JLabel available_ticketsLabel;
    public SearchTicket(CassirFrame main){
        this.main = main;

        setSize(500,500);
        setLayout(null);

        availavble_ticketsCombo = new JComboBox();
        availavble_ticketsCombo.setSelectedItem(null);
        availavble_ticketsCombo.setBounds(100,100,300,30);
        add(availavble_ticketsCombo);

        available_ticketsLabel = new JLabel("TICKETS MATCHING YOUR SETTINGS");
        available_ticketsLabel.setBounds(100,50,300,30);
        add(available_ticketsLabel);

        next = new JButton("NEXT");
        next.setBounds(100,300,300,50);
        add(next);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i =0; i<main.sendListT("tickets").size();i++){
                    if((main.sendListT("tickets").get(i).flight_id)==((Integer) main.getSearchTicket().availavble_ticketsCombo.getSelectedItem())){
                        main.getBuySelectedTicket().selected_ticket = main.sendListT("tickets").get(i);
                    }
                }
                for(int i =0; i<main.sendListF("flights").size();i++){
                    if(main.sendListF("flights").get(i).id == main.getBuySelectedTicket().selected_ticket.flight_id){
                        main.getBuySelectedTicket().selected_flights = main.sendListF("flights").get(i);
                    }
                }
                for(int i=0;i<main.sendListA("aircrafts").size();i++){
                    if (main.sendListA("aircrafts").get(i).id == main.getBuySelectedTicket().selected_flights.aircraft_id){
                        main.getBuySelectedTicket().selected_aircrafts = main.sendListA("aircrafts").get(i);
                    }
                }
                if(main.getBuySelectedTicket().selected_ticket.ticket_type.equals("BusinessClass")){
                    main.getBuySelectedTicket().Cost.setText("THE PRICE OF THIS TICKET "+ main.getBuySelectedTicket().selected_flights.business_place_price+" KZT");
                }if(main.getBuySelectedTicket().selected_ticket.ticket_type.equals("EconomyClass")){
                    main.getBuySelectedTicket().Cost.setText("THE PRICE OT THIS TICKET "+ main.getBuySelectedTicket().selected_flights.econom_place_price+" KZT");
                }
                main.getSearchTicket().setVisible(false);
                main.getBuySelectedTicket().setVisible(true);
                main.getBuySelectedTicket().setSize(520,500);
            }
        });

        back = new JButton("BACK");
        back.setBounds(100,150,300,40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                main.getBuyTicket().setVisible(true);
                main.getSearchTicket().setVisible(false);
                availavble_ticketsCombo.removeAllItems();
            }
        });


    }
}
