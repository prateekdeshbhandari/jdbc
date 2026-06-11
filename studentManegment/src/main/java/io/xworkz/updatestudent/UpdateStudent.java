package io.xworkz.updatestudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudent {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver load sucessfully");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //connection
        String sqlQuery ="Update student_info set STUDENT_AGE=22,STUDENT_NAME='pra'  where STUDENT_ID=2";
        Connection connection=null;
        Statement statement=null;
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db","root","Prateek@#1");
            statement=connection.createStatement();
            statement.executeUpdate(sqlQuery);
            System.out.println("data is succesfuly enterd....");


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
