package com.xwork.taxi.dao;

import com.xwork.taxi.dto.TaxiDetailsDTO;

import java.util.List;

public interface TaxiDao {
    boolean save(TaxiDetailsDTO taxiDetails);
    public boolean savedUpdate(String driverName,String carModal);
    public boolean savedDelete(String driverName);
    public List <TaxiDetailsDTO> taxiDetielsList();

    String insertMultpalRow( List<TaxiDetailsDTO>detailsDTOS);




}
