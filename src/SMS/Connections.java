package SMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connections {
    // will connect java with mysql database
    Connection c;                                                  // creating connection ,connection is a intrerface
    Statement s;
    Connections(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem","root","12345678");  // address of dtanase+admin name +password? this is connection string
            s=c.createStatement();        // u can execute mysql quiries using it
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
