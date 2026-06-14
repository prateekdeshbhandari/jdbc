package com.xworkz.real_estate_property.dao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RealEstatePropertyDetilesDTO {
    private int propertyId;
    private String address;
    private double price;
    private double area;
    private String ownerName;
}
