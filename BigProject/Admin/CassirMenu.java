package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CassirMenu extends JPanel {
    CassirFrame cassirFrame;
    JButton buy;
    JButton exit;
    JButton edit;
    JButton delete;
    public CassirMenu(CassirFrame cassirFrame){
        this.cassirFrame = cassirFrame;

        setSize(500,500);
        setLayout(null);

        buy = new JButton("BUY TICKETS");
        buy.setBounds(100,100,300,40);
        add(buy);
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cassirFrame.getCassirMenu().setVisible(false);
                cassirFrame.getBuyTicket().setVisible(true);
            }
        });
        edit = new JButton("EDIT TICKETS");
        edit.setBounds(100,150,300,40);
        add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cassirFrame.getCassirMenu().setVisible(false);
                cassirFrame.getTicketMenu().setVisible(true);

            }
        });

        exit = new JButton("EXIT");
        exit.setBounds(100,200,300,40);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}