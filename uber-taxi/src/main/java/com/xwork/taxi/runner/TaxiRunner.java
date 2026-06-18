package com.xwork.taxi.runner;

import com.xwork.taxi.dao.TaxiDao;
import com.xwork.taxi.dao.impl.TaxiDAOImpl;
import com.xwork.taxi.dto.TaxiDetailsDTO;
import com.xwork.taxi.servies.TaxiDetielsDtoValidection;
import com.xwork.taxi.servies.impl.TaxiDetailesValidectionImpl;

import java.util.ArrayList;
import java.util.List;

public class TaxiRunner {
    public static void main(String[] args) {
     TaxiDao dao = new TaxiDAOImpl();
//
//        TaxiDetailsDTO dto = new TaxiDetailsDTO();
//        dto.setDriverName("Denaa");
//        dto.setCarModel("BMW");
//        dto.setLicensePlate("KA-01-AB-1234");
//        dto.setFarePerKm(15.0);
//
//        TaxiDetailsDTO dto1 = new TaxiDetailsDTO();
//        dto1.setDriverName("Prateek");
//        dto1.setCarModel("BMW");
//        dto1.setLicensePlate("KA-02-AB-1234");
//        dto1.setFarePerKm(-9);
//        int saved = dao.save(dto);
//
//        System.out.println("Taxi details saved: " + saved);
//          dao.save(dto1);



//        TaxiDetielsDtoValidection taxiDetielsDtoValidection=new TaxiDetailesValidectionImpl();
//        taxiDetielsDtoValidection.validetSave(dto);
//        taxiDetielsDtoValidection.validetSave(dto1);
//
//        //update start

//delete start
       // boolean dele=dao1.savedDelete("Devanath");
       // System.out.println("Deleteed: "+dele);

//       TaxiDetailsDTO ref= dao.selectByDriverName("Devanath");
//
//        System.out.println("Driver Name : " + ref.getDriverName());
//        System.out.println("Car Model   : " + ref.getCarModel());
//        System.out.println("License Plate : " + ref.getLicensePlate());
//        System.out.println("Fare Per Km : " + ref.getFarePerKm());
//        List <TaxiDetailsDTO>ref=dao.taxiDetielsList();
//        for(TaxiDetailsDTO reff:ref){
//            System.out.println("read thois row.."+reff);
        List<TaxiDetailsDTO>taxiDetailes=new ArrayList<>();

TaxiDetailsDTO dto=new TaxiDetailsDTO();
        TaxiDetielsDtoValidection taxiDetielsDtoValidection=new TaxiDetailesValidectionImpl();
        dto.setDriverName("esd");
        dto.setCarModel("BMW");
        dto.setLicensePlate("KA-01-AB-1234");
        dto.setFarePerKm(-5);

        TaxiDetailsDTO dto2=new TaxiDetailsDTO();
        dto2.setDriverName("dc");
        dto2.setCarModel("auid");
        dto2.setLicensePlate("KA-02-AB-1234");
        dto2.setFarePerKm(10);
        taxiDetailes.add(dto);
        taxiDetailes.add(dto2);

    taxiDetielsDtoValidection.validetSave(dto);
        taxiDetielsDtoValidection.validetSave(dto2);
  dao.insertMultpalRow(taxiDetailes);

//        List<TaxiDetailsDTO>taxiDetailes1=new ArrayList<>();
//        TaxiDetailsDTO dto1=new TaxiDetailsDTO();
//        TaxiDetielsDtoValidection taxiDetielsDtoValidection1=new TaxiDetailesValidectionImpl();
//        boolean  upda=dao.savedUpdate("Devanath","SUVs");
//        System.out.println("Updated: "+upda);
//        taxiDetailes1.add(dto1);
//        taxiDetielsDtoValidection1.validetSave(dto1);
//        dao.insertMultpalRow(taxiDetailes1);

        }
    }



