package io.xworkz.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateEcommers {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver load sucessfully");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //connection
        String sqlQuery ="Update users_info set password='prateek777',user_name='prateek g d'  where user_id=1";
        Connection connection=null;
        Statement statement=null;
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db","root","Prateek@#1");
            statement=connection.createStatement();
            statement.executeUpdate(sqlQuery);
            System.out.println("data is succesfuly update....");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(connection !=null){

                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                if (statement!=null){
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}

