package com.xwork.taxi.dao;

import com.xwork.taxi.dto.TaxiDetailsDTO;

public interface TaxiDao {
    boolean save(TaxiDetailsDTO taxiDetails);
    public boolean savedUpdate(String driverName,String carModal);
    public boolean savedDelete(String driverName);





}
