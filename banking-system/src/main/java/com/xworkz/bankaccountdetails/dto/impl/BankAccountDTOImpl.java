package com.xworkz.bankaccountdetails.dto.impl;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.xworkz.bankaccountdetails.dao.AccvountDetlilesDAO;
import com.xworkz.bankaccountdetails.dto.BankAccountDTO;

import java.sql.*;

public class BankAccountDTOImpl implements BankAccountDTO {


    @Override
    public int save(AccvountDetlilesDAO accvountDetlilesDAO) {
        System.out.println("propartis Invoking detiels: "+accvountDetlilesDAO);
        int validection=0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String insertQuery="insert into account_info( account_number,account_holder_name, account_type,  balance, branch_name)VALUES(?,?,?,?,?)";
        Connection connection=null;
        try {
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db","root","Prateek@#1");
           PreparedStatement prepareStatement =connection.prepareStatement(insertQuery);
            prepareStatement.setInt(1,accvountDetlilesDAO.getAccountNumber());
            prepareStatement.setString(2, accvountDetlilesDAO.getAccountHolderName());
            prepareStatement.setString(3, accvountDetlilesDAO.getAccountType());
            prepareStatement.setDouble(4,accvountDetlilesDAO.getBalance());
            prepareStatement.setString(5, accvountDetlilesDAO.getBranchName());

            boolean asved=prepareStatement.execute();
            System.out.println("data succesfully entterd...."+asved);

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
        return validection;

    }

    @Override
    public Boolean saveUpdate(int accountNumber, double balance, String accountType) {
        System.out.println("update Invokiing: ");
        boolean isUpdate=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String updateQuery="update account_info set balance=?,account_type=? where account_number=?";
        Connection connection=null;
        try {
          connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db","root","Prateek@#1");
           PreparedStatement prepareStatement= connection.prepareStatement(updateQuery);
            prepareStatement.setDouble(1,balance);
           prepareStatement.setString(2,accountType);

            prepareStatement.setInt(3,accountNumber);
          int updated=prepareStatement.executeUpdate();
           if(updated >0){
               isUpdate=true;
               System.out.println("update  the date  sucssefully.....");


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
    public Boolean saveDelete(int accountNumber) {
        System.out.println("dtat deleteing  processing...");
        boolean isDelete=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
        String deleteQuery="Delete from account_info where account_number=?";
        Connection connection=null;
        try {
           connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db","root","Prateek@#1");

       PreparedStatement prepareStatement= connection.prepareStatement(deleteQuery);
       prepareStatement.setInt(1,accountNumber);
       int delete=prepareStatement.executeUpdate();
       if(delete>1)
       {
          isDelete=true;
           System.out.println("delete  data sucesfully...:");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {


        if(connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        }
        return isDelete;

    }

    @Override
    public AccvountDetlilesDAO validection(int accountNumber) {
        AccvountDetlilesDAO dto= null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String selectQuery =
                "SELECT *  FROM  account_info WHERE account_number =?";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/payment_db",
                    "root",
                    "Prateek@#1");

            PreparedStatement preparedStatement =
                    connection.prepareStatement(selectQuery);


            preparedStatement.setInt(1,accountNumber);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                dto=new AccvountDetlilesDAO();
                dto.setAccountNumber( resultSet.getInt("account_number"));
                dto.setAccountHolderName( resultSet.getString(" account_holder_name"));
                dto.setAccountType( resultSet.getString("account_type"));
                dto.setBalance( resultSet.getDouble("balance"));
                dto.setBranchName( resultSet.getString("branch_name"));
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

        return dto;
    }

}


