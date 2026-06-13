package com.xwork.taxi.dao.impl;

import com.xwork.taxi.dao.TaxiDao;
import com.xwork.taxi.dto.TaxiDetailsDTO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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



}
