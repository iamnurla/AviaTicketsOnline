package Admin;

import java.net.Socket;

public class KassirSocket {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 5555);
            CassirFrame main = new CassirFrame(socket);
            main.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
