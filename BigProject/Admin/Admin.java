package Admin;

import java.net.Socket;

public class Admin {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 2024);
            System.out.println("Socket");
            AdminGUI gui = new AdminGUI(socket);
            System.out.println("1");
            gui.setVisible(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}