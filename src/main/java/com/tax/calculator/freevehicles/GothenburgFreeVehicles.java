package com.tax.calculator.freevehicles;

import com.tax.calculator.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class GothenburgFreeVehicles implements FreeVehicles{

    public GothenburgFreeVehicles() {
        freeVehicles.add("Motorcycle");
        freeVehicles.add("Emergency");
        freeVehicles.add("Diplomat");
        freeVehicles.add("Foreign");
        freeVehicles.add("Military");
    }
    private List<String > freeVehicles = new ArrayList<>();
    public void setFreeVehicles(List<String> freeVehicles) {
        this.freeVehicles = freeVehicles;
    }
    @Override
    public boolean isFreeVehicle(Vehicle vehicle){

        if(vehicle != null)
            return freeVehicles.contains(vehicle.getVehicleType());

        return false;
    }

}
