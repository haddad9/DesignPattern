package id.ac.ui.cs.advprog.tutorial1.tracking.core;


import java.util.List;

public class Courier implements RoadUser {
    int speed;
    String name;

    List<String> allowedRoutes;
    List<String> allRoutes;
    CourierBehaviour courierBehaviour;




    /*
        speed: the speed of the courier
        allowedRoutes: name of all possible routes this courier can visit
    */


    public Courier(String name, int speed, List<String> allRoutes) {
        // TODO complete me

        courierBehaviour = new NormalBehaviour();
        allowedRoutes = allRoutes;
        this.allRoutes = allRoutes;
        this.name = name;
        this.speed = speed;





    }


    @Override
    public void handleNotification(String notificationFrom, String location) {
        allowedRoutes = courierBehaviour.selectRoutes(notificationFrom,location,allRoutes,allowedRoutes);


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
