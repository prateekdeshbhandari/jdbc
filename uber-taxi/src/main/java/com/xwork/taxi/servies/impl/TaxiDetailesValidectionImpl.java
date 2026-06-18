package com.xwork.taxi.servies.impl;

import com.xwork.taxi.dao.TaxiDao;
import com.xwork.taxi.dao.impl.TaxiDAOImpl;
import com.xwork.taxi.dto.TaxiDetailsDTO;
import com.xwork.taxi.servies.TaxiDetielsDtoValidection;

import java.util.List;

public class TaxiDetailesValidectionImpl implements TaxiDetielsDtoValidection {
 TaxiDao taxiDao ;


    @Override
    public boolean validetSave(TaxiDetailsDTO taxiDetailsDTO) {
        //TaxiDao taxiDao = new TaxiDAOImpl();


        boolean idDriverName=false;
        boolean isCarModel=false;
        boolean islicensePlate=false;
        boolean isfarePerKm=false;

        String name=taxiDetailsDTO.getDriverName();
        if(name !=null&&!name.isEmpty()){
            idDriverName=true;



        }
        else {
            System.out.println("ivolid  names");
        }
        String model=taxiDetailsDTO.getCarModel();
        if(model!=null&&!model.isEmpty()){
            isCarModel=true;

        }
        else{
            System.out.println("care model is involid");
        }
        String lisens=taxiDetailsDTO.getLicensePlate();
        if(lisens!=null&&!lisens.isEmpty()){
            islicensePlate=true;

        }
        else{
            System.out.println("licens plate is involid");

        }

        double ferKIlometar=taxiDetailsDTO.getFarePerKm();
        if (ferKIlometar>0.00){
            isfarePerKm=true;

        }else {


            System.out.println("involid number");

        }
        if (idDriverName && isCarModel && islicensePlate && isfarePerKm) {
            System.out.println("Data validated successfully");

            TaxiDao taxiDao = new TaxiDAOImpl();
            return taxiDao.save(taxiDetailsDTO);

        }
        System.out.println("Data is invalid. Not inserted into database.");

        return false;
    }




}
