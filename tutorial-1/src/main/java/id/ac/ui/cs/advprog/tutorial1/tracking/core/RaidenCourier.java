package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.List;

public class RaidenCourier implements RoadUser {
    int speed;
    String name;
    CourierBehaviour courierBehaviour;
    List<String> allowedRoutes;
    List<String> allRoutes;
    List<String> invalidRoutes;




    /*
        speed: the speed of the courier
        allowedRoutes: name of all possible routes this courier can visit
    */


    public RaidenCourier(String name, int speed, List<String> allRoutes) {
        // TODO complete me
        this.name = name;
        this.speed = speed;
        courierBehaviour = new SweetBehaviour();
        allowedRoutes = allRoutes;
        this.allRoutes = allRoutes;





    }


    @Override
    public void handleNotification(String notificationFrom, String location) {
        allowedRoutes = courierBehaviour.selectRoutes(notificationFrom,location,allRoutes,allowedRoutes );
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getAllowedRoutes() {
        return allowedRoutes;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
