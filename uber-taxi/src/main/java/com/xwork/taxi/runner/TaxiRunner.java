package com.xwork.taxi.runner;

import com.xwork.taxi.dao.TaxiDao;
import com.xwork.taxi.dao.impl.TaxiDAOImpl;
import com.xwork.taxi.dto.TaxiDetailsDTO;

public class TaxiRunner {
    public static void main(String[] args) {
        TaxiDao dao = new TaxiDAOImpl();

        TaxiDetailsDTO dto = new TaxiDetailsDTO();
        dto.setDriverName("Devanath");
        dto.setCarModel("BMW");
        dto.setLicensePlate("KA-01-AB-1234");
        dto.setFarePerKm(15.0);

        boolean saved = dao.save(dto);

        System.out.println("Taxi details saved: " + saved);


        TaxiDAOImpl dao1=new TaxiDAOImpl();
        boolean  upda=dao1.savedUpdate("Devanath","SUVs");
        System.out.println("Updated: "+upda);

        boolean dele=dao1.savedDelete("Devanath");
        System.out.println("Deleteed: "+dele);
    }
}


