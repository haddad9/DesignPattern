package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;
import java.util.List;

public class NormalBehaviour implements CourierBehaviour{

    @Override
    public List<String> selectRoutes(String from, String location, List<String> allRoutes, List<String> allowedRoutes) {

        if(from.equals("Drago Monitor")){
            List<String> tmp = new ArrayList<>();
            for(String r: allRoutes){
                if(!r.equals(location)){

                    tmp.add(r);
                }
                allowedRoutes = tmp;
            }
        }



        return allowedRoutes;
    }
}
