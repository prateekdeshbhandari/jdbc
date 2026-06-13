package com.xwork.taxi.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TaxiDetailsDTO {


        private String driverName;
        private String carModel;
        private String licensePlate;
        private double farePerKm;

}
