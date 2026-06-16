package com.xwork.taxi.dao.impl;

import com.xwork.taxi.dao.TaxiDao;
import com.xwork.taxi.dto.TaxiDetailsDTO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaxiDAOImpl implements TaxiDao {

        @Override
        public int save(TaxiDetailsDTO taxiDetails) {

            System.out.println("Invoking Saving taxi details: " + taxiDetails);

            int rowInsert=0 ;

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

                rowInsert = prepareStatement.executeUpdate();

                System.out.println("insert susdefullu.."+rowInsert);
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



            return rowInsert;
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
    @Override
    public List<TaxiDetailsDTO> taxiDetielsList(){
        List<TaxiDetailsDTO> arrayList = new ArrayList();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String selectQuery =
                "SELECT *  FROM taxidetails ";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/payment_db",
                    "root",
                    "Prateek@#1");

            PreparedStatement preparedStatement =
                    connection.prepareStatement(selectQuery);




            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


TaxiDetailsDTO dto=new TaxiDetailsDTO();
               dto.setDriverName( resultSet.getString("driver_name"));
              dto.setCarModel( resultSet.getString("car_model"));
               dto.setLicensePlate( resultSet.getString("lisence_plate"));
               dto.setFarePerKm( resultSet.getDouble("fare_per_km"));
                arrayList.add(dto);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return arrayList;
    }

}
