package com.xwork.taxi.runner;

import com.xwork.taxi.dao.TaxiDao;
import com.xwork.taxi.dao.impl.TaxiDAOImpl;
import com.xwork.taxi.dto.TaxiDetailsDTO;
import com.xwork.taxi.servies.TaxiDetielsDtoValidection;
import com.xwork.taxi.servies.impl.TaxiDetailesValidectionImpl;

public class TaxiRunner {
    public static void main(String[] args) {
        TaxiDao dao = new TaxiDAOImpl();

        TaxiDetailsDTO dto = new TaxiDetailsDTO();
        dto.setDriverName("Denaa");
        dto.setCarModel("BMW");
        dto.setLicensePlate("KA-01-AB-1234");
        dto.setFarePerKm(15.0);

        TaxiDetailsDTO dto1 = new TaxiDetailsDTO();
        dto1.setDriverName("Prateek");
        dto1.setCarModel("BMW");
        dto1.setLicensePlate("KA-02-AB-1234");
        dto1.setFarePerKm(-9);
        int saved = dao.save(dto);

        System.out.println("Taxi details saved: " + saved);
          dao.save(dto1);



        TaxiDetielsDtoValidection taxiDetielsDtoValidection=new TaxiDetailesValidectionImpl();
        taxiDetielsDtoValidection.validetSave(dto);
        taxiDetielsDtoValidection.validetSave(dto1);

        //update start
        TaxiDAOImpl dao1=new TaxiDAOImpl();
        boolean  upda=dao1.savedUpdate("Devanath","SUVs");
        System.out.println("Updated: "+upda);
//delete start
       // boolean dele=dao1.savedDelete("Devanath");
       // System.out.println("Deleteed: "+dele);

       TaxiDetailsDTO ref= dao.selectByDriverName("Devanath");

        System.out.println("Driver Name : " + ref.getDriverName());
        System.out.println("Car Model   : " + ref.getCarModel());
        System.out.println("License Plate : " + ref.getLicensePlate());
        System.out.println("Fare Per Km : " + ref.getFarePerKm());
    }
}


