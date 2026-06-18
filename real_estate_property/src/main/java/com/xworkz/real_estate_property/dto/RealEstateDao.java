package com.xworkz.real_estate_property.dto;

import com.xworkz.real_estate_property.dao.RealEstatePropertyDetilesDTO;

import java.util.List;

public interface RealEstateDao {
    public boolean save(RealEstatePropertyDetilesDTO realEstatePropertyDetilesDTO);
    public boolean saveUpdate(int propertyId,double price,String ownerName);
    public boolean savedDelete(int propertyId);
   List <RealEstatePropertyDetilesDTO> getDetailsList();
}
