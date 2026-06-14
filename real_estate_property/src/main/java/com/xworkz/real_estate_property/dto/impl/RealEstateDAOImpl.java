package com.xworkz.real_estate_property.dto.impl;

import com.xworkz.real_estate_property.dao.RealEstatePropertyDetilesDTO;
import com.xworkz.real_estate_property.dto.RealEstateDao;

import java.sql.*;

public class RealEstateDAOImpl implements RealEstateDao {
    @Override
    public Boolean save(RealEstatePropertyDetilesDTO realEstatePropertyDetilesDTO) {
        System.out.println("property data Invoking..."+realEstatePropertyDetilesDTO);
        boolean isProperty=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver") ;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection=null;
        String insartQuery="Insert into property_info (property_id,address,price,area,owner_name)values(?,?,?,?,?) ";
        try {
          connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db","root","Prateek@#1");
           PreparedStatement preparedStatement= connection.prepareStatement(insartQuery);
           preparedStatement.setInt(1,realEstatePropertyDetilesDTO.getPropertyId());
           preparedStatement.setString(2,realEstatePropertyDetilesDTO.getAddress());
           preparedStatement.setDouble(3,realEstatePropertyDetilesDTO.getPrice());
           preparedStatement.setDouble(4,realEstatePropertyDetilesDTO.getArea());
           preparedStatement.setString(5, realEstatePropertyDetilesDTO.getAddress());
           boolean insert=preparedStatement.execute();
            System.out.println("insert data sucssefully..."+insert);
        isProperty=true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return isProperty;
    }

    @Override
    public boolean saveUpdate(int propertyId, double price, String ownerName) {
        boolean isUpdate=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection=null;
        String updateQuery="Update property_info set owner_name=?,price=? where property_id=? ";
        try {
           connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db","root","Prateek@#1");
            PreparedStatement preparedStatement=connection.prepareStatement(updateQuery);
            preparedStatement.setString(1,ownerName);
            preparedStatement.setDouble(2,price);
            preparedStatement.setInt(3,propertyId);
            int update=preparedStatement.executeUpdate();
            if(update>0){
                isUpdate=true;
                System.out.println("update is  complit");
            }
            else {
                System.out.println("no record found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return isUpdate;
    }

    @Override
    public boolean savedDelete(int propertyId) {
        boolean isDelete=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection=null;
        String updateQuery="Delete from property_info where property_id=?";
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db","root","Prateek@#1");
            PreparedStatement preparedStatement=connection.prepareStatement(updateQuery);

            preparedStatement.setInt(1,propertyId);
            int update=preparedStatement.executeUpdate();
            if(update>0){
                isDelete=true;
                System.out.println("Delete is  complit...");
            }
            else {
                System.out.println("no record found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return isDelete;
    }
}
