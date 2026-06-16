package com.xworkz.real_estate_property.runner;


import com.xworkz.real_estate_property.dao.RealEstatePropertyDetilesDTO;
import com.xworkz.real_estate_property.dto.RealEstateDao;
import com.xworkz.real_estate_property.dto.impl.RealEstateDAOImpl;
import com.xworkz.real_estate_property.severis.RealEstate;
import com.xworkz.real_estate_property.severis.impl.RealEstetPropartesServis;

public class RealEstatePropertyRunner {
    public static void main(String[] args) {
        RealEstateDao dao=new RealEstateDAOImpl();
        RealEstatePropertyDetilesDTO dto=new RealEstatePropertyDetilesDTO();
        dto.setPropertyId(1);
        dto.setAddress("Bengalluru");
        dto.setPrice(40000000.00);
        dto.setArea(40*40);
        dto.setOwnerName("Prateek");
        dao.save(dto);
        System.out.println("-----------------------------------------------------------");
        RealEstatePropertyDetilesDTO dto1 = new RealEstatePropertyDetilesDTO();
        dto1.setPropertyId(2);
        dto1.setAddress("Mysuru");
        dto1.setPrice(25000000.00);
        dto1.setArea(30 * 50);
        dto1.setOwnerName("Prajwal");

       int data= dao.save(dto1);
        System.out.println("deteils saved..."+data);
RealEstate realEstate=new RealEstetPropartesServis();
realEstate.validet(dto);
realEstate.validet(dto1);
        RealEstateDAOImpl dao1=new RealEstateDAOImpl();
       boolean up=dao1.saveUpdate(2,2400000,"prveeena");
        System.out.println("Updated: "+up);
      // boolean de=dao1.savedDelete(2);
       // System.out.println("Delete: "+de);

        RealEstatePropertyDetilesDTO ref=dao.saveRead("2");
        System.out.println("Id"+ref.getPropertyId());
        System.out.println("Addres"+ref.getAddress());
        System.out.println("price"+ref.getPrice());
        System.out.println("area"+ref.getArea());
        System.out.println("ownerName"+ref.getOwnerName());


    }

}
