package com.xworkz.food_delivery_app.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDeliveryAppDTO {
    private int orderId;
    private String customerName;
    private String deliveryAddress;
    private double orderAmount;
    private String payment;
}
