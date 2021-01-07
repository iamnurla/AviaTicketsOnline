package Admin;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

public class Server extends Thread {
    ServerSocket socket;
    Connection connection;

    public Server(ServerSocket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
    }

    @Override
    public void run() {

        while (socket.isBound()) {
            try {
                Socket socket2 = socket.accept();
                System.out.println("ADMIN CONNECTED");
                ServerThread a1 = new ServerThread(socket2, connection);
                a1.start();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}