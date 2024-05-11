package bank.management.system;

import java.sql.*;

public class Connection {

    java.sql.Connection c;
    Statement s;
    public Connection(){
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "Mh46y5979$" );
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

