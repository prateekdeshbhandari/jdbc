package com.xworkz.real_estate_property.severis.impl;

import com.xworkz.real_estate_property.dao.RealEstatePropertyDetilesDTO;
import com.xworkz.real_estate_property.severis.RealEstate;

public class RealEstetPropartesServis implements RealEstate {

    @Override
    public boolean validet(RealEstatePropertyDetilesDTO dto) {
        boolean isValidation = false;

        boolean isPropertyIdValid = false;
        boolean isAddressValid = false;
        boolean isPriceValid = false;
        boolean isAreaValid = false;
        boolean isOwnerNameValid = false;

        int id = dto.getPropertyId();
        if (id > 0) {
            isPropertyIdValid = true;
        } else {
            System.out.println("Invalid property id");
        }

        String address = dto.getAddress();
        if (address != null && !address.isEmpty()) {
            isAddressValid = true;
        } else {
            System.out.println("Invalid address");
        }

        double price = dto.getPrice();
        if (price > 0.0) {
            isPriceValid = true;
        } else {
            System.out.println("Invalid price");
        }

        double area = dto.getArea();
        if (area > 0.0) {
            isAreaValid = true;
        } else {
            System.out.println("Invalid area");
        }

        String ownerName = dto.getOwnerName();
        if (ownerName != null && !ownerName.isEmpty()) {
            isOwnerNameValid = true;
        } else {
            System.out.println("Invalid owner name");
        }

        if (isPropertyIdValid &&
                isAddressValid &&
                isPriceValid &&
                isAreaValid &&
                isOwnerNameValid) {

            isValidation = true;
            System.out.println("Data validated successfully...");
        }

        return isValidation;
    }
}

