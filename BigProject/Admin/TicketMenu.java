package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TicketMenu extends JPanel {
    CassirFrame main;
    JButton add;
    JButton edit;
    JButton delete;
    JButton back;
    String [] list;

    ArrayList<String> impostors = new ArrayList<>();

    public TicketMenu(CassirFrame main){
        this.main = main;

        setSize(500,500);
        setLayout(null);

        add = new JButton("ADD");
        add.setBounds(100,100,300,40);
        add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getTicketMenu().setVisible(false);
                main.getAddTicket().setVisible(true);

                list = new String[main.sendListF("flights").size()];
                for(int i =0;i <main.sendListF("flights").size();i++){
                    list[i] = String.valueOf(main.sendListF("flights").get(i).id);
                }
                if(list.length<main.getAddTicket().flight_idCombo.getItemCount()) {
                    ArrayList<String> impostors = new ArrayList<>();

                    for(int i = 0;i<main.getAddTicket().flight_idCombo.getItemCount();i++){
                        int dursemes =0;
                        for(int j =0; j<list.length;j++){
                            if(Integer.parseInt((String) main.getAddTicket().flight_idCombo.getItemAt(i))!=Integer.parseInt(list[j])){
                                dursemes++;
                            }
                        }
                        if(dursemes==list.length){
                            impostors.add((String) main.getAddTicket().flight_idCombo.getItemAt(i));
                        }


                    }
                    for (int i = 0; i < (main.getAddTicket().flight_idCombo.getItemCount() - list.length); i++) {
                        main.getAddTicket().flight_idCombo.removeItem(impostors.get(i));
                    }
                }
                if(list.length>main.getAddTicket().flight_idCombo.getItemCount()) {

                    for (int i = 0; i < (list.length - main.getAddTicket().flight_idCombo.getItemCount()); i++) {
                        impostors.add(list[list.length - 1 - i]);
                    }
                    for (int i = 0; i < (list.length - main.getAddTicket().flight_idCombo.getItemCount()); i++) {
                        main.getAddTicket().flight_idCombo.addItem(impostors.get(i));
                    }
                }
            }
        });

        edit = new JButton("EDIT");
        edit.setBounds(100,150,300,40);
        add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditTicketParameter().setVisible(true);
                main.getTicketMenu().setVisible(false);
            }
        });
        delete = new JButton("DELETE");
        delete.setBounds(100,200,300,40);
        add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getTicketMenu().setVisible(false);
                main.getDeleteTicket().setVisible(true);
            }
        });
        back = new JButton("BACK");
        back.setBounds(100,250,300,40);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getTicketMenu().setVisible(false);
                main.getCassirMenu().setVisible(true);
            }
        });


    }
}