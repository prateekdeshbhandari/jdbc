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
    }
}


