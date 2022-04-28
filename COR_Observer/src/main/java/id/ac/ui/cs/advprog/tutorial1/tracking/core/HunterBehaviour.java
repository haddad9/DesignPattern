package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;
import java.util.List;

public class HunterBehaviour implements CourierBehaviour{
    String prevDrago="None";
    @Override
    public List<String> selectRoutes(String from, String location, List<String> allRoutes, List<String> allowedRoutes) {

        if(from.equals("Drago Monitor")){
            if(!location.equals("None")){
                List<String> tmp = new ArrayList<>();
                tmp.add(location);
                allowedRoutes = tmp;
                prevDrago = location;
            }
            else{
                allowedRoutes = new ArrayList<>();
                prevDrago = "None";

            }


        }


        return allowedRoutes;
    }
}
