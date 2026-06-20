package com.xworkz.softer_data.Dao.impl;

import com.xworkz.softer_data.Dao.SoftwareDAO;
import com.xworkz.softer_data.Dto.SoftwareDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SoftwareDAOImpl implements SoftwareDAO {


    @Override
    public boolean save(SoftwareDTO dto) {

        System.out.println("data  Invoking start...");
        String url = "jdbc:mysql://localhost:3306/software_db";
        String username = "root";
        String password = "Prateek@#1";

        String sql = "insert into software_table " +
                "(software_name,current_version,developed_year,developed_by,open_source) " +
                "values(?,?,?,?,?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection =
                    DriverManager.getConnection(url, username, password);

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, dto.getSoftwareName());
            ps.setInt(2, dto.getCurrentVersion());
            ps.setInt(3, dto.getDevelopedYear());
            ps.setString(4, dto.getDevelopedBy());
            ps.setString(5, dto.getOpenSource());

           Boolean ref= ps.execute() ;
            System.out.println("data is  sucssefully Invoking...");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    }

