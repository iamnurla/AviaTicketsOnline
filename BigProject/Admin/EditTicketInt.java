package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTicketInt extends JPanel {
    CassirFrame main;
    JLabel enterLabel;
    JTextField enterField;
    JButton back;
    JButton edit;

    public EditTicketInt(CassirFrame main){
        this.main = main;

        setSize(500,500);
        setLayout(null);

        enterLabel = new JLabel("ENTER INT");
        enterLabel.setBounds(100,100,300,40);
        add(enterLabel);

        enterField = new JTextField();
        enterField.setBounds(100,150,300,30);
        add(enterField);

        back = new JButton("BACK");
        back.setBounds(275,400,100,30);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getEditTicketParameter().setVerifyInputWhenFocusTarget(false);
                main.getEditTicketInt().setVerifyInputWhenFocusTarget(true);
            }
        });

        edit = new JButton("EDIT");
        edit.setBounds(125,400,100,30);
        add(edit);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(main.getEditTicketParameter().parameterField.getText().equals("id")){
                    int id = 0;
                    Ticket ticket = null;
                    for (int i = 0;i<main.sendListT("tickets").size();i++){
                        if(main.sendListT("tickets").get(i).id == Integer.parseInt(main.getEditTicketParameter().idField.getText())){
                            id = Integer.parseInt(enterField.getText());
                            ticket = main.sendListT("tickets").get(i);
                        }
                    }
                    main.EditTicketsInt("id",ticket,id);
                    enterField.setText("");
                    main.getEditTicketParameter().parameterField.setText("");
                    main.getEditTicketParameter().idField.setText("");

                }
            }
        });
    }
}
