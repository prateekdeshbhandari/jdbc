package com.xworkz.real_estate_property.runner;


import com.xworkz.real_estate_property.dao.RealEstatePropertyDetilesDTO;
import com.xworkz.real_estate_property.dto.RealEstateDao;
import com.xworkz.real_estate_property.dto.impl.RealEstateDAOImpl;
import com.xworkz.real_estate_property.severis.RealEstate;
import com.xworkz.real_estate_property.severis.impl.RealEstetPropartesServis;

import java.util.List;

public class RealEstatePropertyRunner {
    public static void main(String[] args) {
        RealEstateDao dao=new RealEstateDAOImpl();
        RealEstatePropertyDetilesDTO dto=new RealEstatePropertyDetilesDTO();
        dto.setPropertyId(1);
        dto.setAddress(null);
        dto.setPrice(40000000.00);
        dto.setArea(40*40);
        dto.setOwnerName("Prateek");

        System.out.println("-----------------------------------------------------------");
        RealEstatePropertyDetilesDTO dto1 = new RealEstatePropertyDetilesDTO();
        dto1.setPropertyId(2);
        dto1.setAddress("Mysuru");
        dto1.setPrice(25000000.00);
        dto1.setArea(30 * 50);
        dto1.setOwnerName("Prajwal");


RealEstate realEstate=new RealEstetPropartesServis(dao);
realEstate.validet(dto);
realEstate.validet(dto1);
        RealEstateDAOImpl dao1=new RealEstateDAOImpl();

       boolean up=dao1.saveUpdate(2,2400000,"prveeena");
        System.out.println("Updated: "+up);
       boolean de=dao1.savedDelete(2);
        System.out.println("Delete: "+de);

        List <RealEstatePropertyDetilesDTO>reff=dao.getDetailsList();

        System.out.println();
        for(RealEstatePropertyDetilesDTO refff:reff)
        {
            System.out.println(""+refff);
        }


    }

}
