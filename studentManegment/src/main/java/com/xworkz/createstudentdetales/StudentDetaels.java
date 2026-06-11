package com.xworkz.createstudentdetales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDetaels {

    public static void main(String[] args) {
        //load this
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver load sucessfully");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //connection
        String sqlQuery ="INSERT INTO student_info VALUES (1, 'PRATEEK','4SF23IS407', 21, 2026),(2, 'prajwal','4SF23IS404', 21,2026),(3, 'praveen','4SF23IS400', 21, 2026)";
        Connection connection=null;
        Statement statement=null;
        try {
          connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db","root","Prateek@#1");
           statement=connection.createStatement();
          statement.execute(sqlQuery);
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

