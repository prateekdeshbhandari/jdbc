package com.xworkz.real_estate_property.dto;

import com.xworkz.real_estate_property.dao.RealEstatePropertyDetilesDTO;

public interface RealEstateDao {
    public int save(RealEstatePropertyDetilesDTO realEstatePropertyDetilesDTO);
    public boolean saveUpdate(int propertyId,double price,String ownerName);
    public boolean savedDelete(int propertyId);
    RealEstatePropertyDetilesDTO saveRead(String propertyId);
}
