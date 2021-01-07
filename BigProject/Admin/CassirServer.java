package Admin;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

public class CassirServer extends  Thread{

    ServerSocket socket;
    Connection connection;

    public CassirServer(ServerSocket socket,Connection connection){
        this.socket = socket;
        this.connection = connection;
    }

    @Override
    public void run() {
        while (socket.isBound()){
            try {
                Socket socket1 = socket.accept();
                System.out.println("CASSIR CONNECTED");
                CassirThread c1 = new CassirThread(socket1,connection);
                c1.start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
