package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection connect(){
        try{
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelbudget",
                    "root",
                    "password"
            );
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
