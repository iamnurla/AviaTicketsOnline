package Admin;

import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class ServerMain {
    static Connection connection;
    Scanner in = new Scanner(System.in);
    static void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bigproject?useUnicode=true&serverTimezone=UTC", "root", "");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket admin = new ServerSocket(2024);
            ServerSocket cashbox = new ServerSocket(5555);
            connect();
            Server st = new Server(admin,connection);
            CassirServer cs = new CassirServer(cashbox,connection);
            st.start();
            cs.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
