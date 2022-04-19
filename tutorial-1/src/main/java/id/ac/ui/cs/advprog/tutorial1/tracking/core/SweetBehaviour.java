package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;
import java.util.List;

public class SweetBehaviour implements  CourierBehaviour {
    String prevDrago = "None";
    String prevSweet = "None";


    @Override
    public List<String> selectRoutes(String from, String location, List<String> allRoutes, List<String> allowedRoutes) {

        if (from.equals("Drago Monitor")) {
            if (prevSweet.equals("None")) {
                List<String> tmp = new ArrayList<>();
                for (String r : allRoutes) {
                    if (!r.equals(location)) {

                        tmp.add(r);
                    }
                    prevDrago = location;
                    allowedRoutes = tmp;
                }

            }
            else {
                prevDrago = location;
            }

        } else {
            if (location.equals("None")) {
                if (!prevDrago.equals("None")) {
                    List<String> tmp = new ArrayList<>();
                    for (String r : allRoutes) {
                        if (!r.equals(prevDrago)) {
                            System.out.println(r);
                            tmp.add(r);
                        }
                        prevSweet = "None";
                        allowedRoutes = tmp;
                    }

                } else {
                    List<String> tmp = new ArrayList<>();
                    for (String r : allRoutes) {
                        tmp.add(r);
                        allowedRoutes = tmp;

                    }
                    prevSweet = "None";
                }


            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(location);
                allowedRoutes = tmp;
                prevSweet = location;
            }


        }
        return allowedRoutes;
    }
}