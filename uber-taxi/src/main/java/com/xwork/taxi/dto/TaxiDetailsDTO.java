package com.xwork.taxi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class TaxiDetailsDTO {


        private String driverName;
        private String carModel;
        private String licensePlate;
        private double farePerKm;

}
