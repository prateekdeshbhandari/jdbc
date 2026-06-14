package com.xwork.taxi.dao.impl;

import com.xwork.taxi.dao.TaxiDao;
import com.xwork.taxi.dto.TaxiDetailsDTO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaxiDAOImpl implements TaxiDao {

        @Override
        public boolean save(TaxiDetailsDTO taxiDetails) {

            System.out.println("Invoking Saving taxi details: " + taxiDetails);

            boolean isSaved = false;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);

        }

            Connection connection = null;

            String insertQuery =
                    "INSERT INTO taxidetails(driver_name, car_model, lisence_plate, fare_per_km) VALUES (?, ?, ?, ?)";

            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/payment_db",
                        "root",
                        "Prateek@#1"
                );

                PreparedStatement prepareStatement =
                        connection.prepareStatement(insertQuery);

                prepareStatement.setString(1, taxiDetails.getDriverName());
                prepareStatement.setString(2, taxiDetails.getCarModel());
                prepareStatement.setString(3, taxiDetails.getLicensePlate());
                prepareStatement.setDouble(4, taxiDetails.getFarePerKm());

                boolean check = prepareStatement.execute();
                isSaved = check;

            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }



            return isSaved;
        }

        @Override
        public boolean savedUpdate(String driverName, String carModal) {

            System.out.println("update data prosesing ...");
            boolean isUpdate=false;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Connection connection=null;
            String updateQuery="update taxidetails set car_model=? where driver_name=?";
            try {
              connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db","root","Prateek@#1");

              PreparedStatement preparedStatement=connection.prepareStatement(updateQuery);
              preparedStatement.setString(1,carModal);
              preparedStatement.setString(2,driverName);
              int update=preparedStatement.executeUpdate();
                System.out.println("update date sucssfully...");
                isUpdate=true;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return isUpdate;
        }

        @Override
        public boolean savedDelete(String driverName) {
            System.out.println("dtel;ete  data prossesing...");
            boolean isDelete=false;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            String dekleteQuery="Delete from taxidetails where driver_name=?";
            Connection connection=null;

            try {
               connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db","root","Prateek@#1");
                PreparedStatement preparedStatement=connection.prepareStatement(dekleteQuery);
                preparedStatement.setString(1,driverName);
                int delete=preparedStatement.executeUpdate();
                System.out.println("delete data sussefully..."+delete);
                isDelete=true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return isDelete;
        }


    }
