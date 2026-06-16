package com.xworkz.real_estate_property.dto.impl;

import com.xworkz.real_estate_property.dao.RealEstatePropertyDetilesDTO;
import com.xworkz.real_estate_property.dto.RealEstateDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RealEstateDAOImpl implements RealEstateDao {
    @Override
    public int save(RealEstatePropertyDetilesDTO realEstatePropertyDetilesDTO) {
        System.out.println("property data Invoking..."+realEstatePropertyDetilesDTO);
        int  rowselected=0;
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
           int insert=preparedStatement.executeUpdate();
            System.out.println("insert data sucssefully..."+insert);


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

        return rowselected;
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

    @Override
    public List <RealEstatePropertyDetilesDTO> getDetailsList() {
        List<RealEstatePropertyDetilesDTO>arrayList=new ArrayList();
        RealEstatePropertyDetilesDTO dto=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
        Connection connection=null;

            try {
              connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db","root","Prateek@#1");
            PreparedStatement preparedStatement=connection.prepareStatement("select * from property_info ");

                ResultSet resultSet=preparedStatement.executeQuery();

                while(resultSet.next()){
                    dto =new RealEstatePropertyDetilesDTO();
                    dto.setPropertyId(resultSet.getInt("property_id"));
                    dto.setAddress(resultSet.getString("address"));
                    dto.setPrice(resultSet.getDouble("price"));
                    dto.setArea(resultSet.getDouble("area"));
                    dto.setOwnerName(resultSet.getString("owner_name"));
                    arrayList.add(dto);
                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        return arrayList;
    }
}
