package com.example.carwash;

public class CarWash {

    static final int Exterior = 5;
    static final int Interior = 10;

    private double total;
    private int NumberOfWashes;


    public CarWash(){
        NumberOfWashes = 0;
        total = NumberOfWashes*Exterior;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setNumberOfWashes(int numberOfWashes) {
        NumberOfWashes = numberOfWashes;
    }

    public int getNumberOfWashes() { return NumberOfWashes; }

    public double getTotalPrice(){
        return total*NumberOfWashes;
    }

}
