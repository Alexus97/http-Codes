package com.dev.jt.httpcodes.model;

public class House {
    private String color;
    private Integer numWindows;
    private String address;
    private Boolean haveGarage;

    public static HouseBuilder builder() { // da acceso a los atributos.
        return new HouseBuilder();
    }


    // Usando patron builder.
    private House(String color, Integer numWindows, String address, Boolean haveGarage) {
        this.color = color;
        this.numWindows = numWindows;
        this.address = address;
        this.haveGarage = haveGarage;
    }


    // public House(String color, String address) {
    //     this.color = color;
    //     this.address = address;
    // }

    // public House(String color, Integer numWindows, Boolean haveGarage) {
    //     this.color = color;
    //     this.numWindows = numWindows;
    //     this.haveGarage = haveGarage;
    // }

    // public House() {
    // }

    // public House(String color, Integer numWindows, String address) {
    //     this.color = color;
    //     this.numWindows = numWindows;
    //     this.address = address;
    // }
    // public House(String color, Integer numWindows) {
    //     this.color = color;
    //     this.numWindows = numWindows;
    // }


    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Integer getNumWindows() {
        return numWindows;
    }
    public void setNumWindows(Integer numWindows) {
        this.numWindows = numWindows;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Boolean getHaveGarage() {
        return haveGarage;
    }
    public void setHaveGarage(Boolean haveGarage) {
        this.haveGarage = haveGarage;
    }
    
    public static class HouseBuilder {
        private String color;
        private Integer numWindows;
        private String address;
        private Boolean haveGarage = Boolean.FALSE; // valor por defecto.

        public HouseBuilder color(String color) {
            this.color = color;
            return this;
        }
        public HouseBuilder numWindows(Integer numWindows) {
            this.numWindows = numWindows;
            return this;
        }
        public HouseBuilder address(String address) {
            this.address = address;
            return this;
        }
        public HouseBuilder haveGarage(Boolean haveGarage) {
            this.haveGarage = haveGarage;
            return this;
        }
        public House build() {
            return new House(color, numWindows, address, haveGarage); // devuelve el objeto que es capa de construir.
        }
    }


}
