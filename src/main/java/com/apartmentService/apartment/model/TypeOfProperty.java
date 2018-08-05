package com.apartmentService.apartment.model;

public enum TypeOfProperty {
    HOUSE,
    APARTMENT;


    public static TypeOfProperty check(String string){
        if(string.toLowerCase().equals("szeregówka")){
            return HOUSE;
        }else{
            return APARTMENT;
        }
    }
}
