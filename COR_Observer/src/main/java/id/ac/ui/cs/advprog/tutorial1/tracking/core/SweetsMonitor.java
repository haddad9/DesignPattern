package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;
import java.util.List;

public class SweetsMonitor implements EventMonitor {
    List<RoadUser> roadUsers = new ArrayList<>();

    @Override
    public void addRoadUser(RoadUser roadUser) {
        // TODO Auto-generated method stub
        roadUsers.add(roadUser);
        
    }

    @Override
    public void notifyRoadUsers(String newSweetsLocation) {
        // TODO Auto-generated method stub
        for(RoadUser r: roadUsers){
            r.handleNotification(this.getName(),newSweetsLocation);

        }
        
    }

    @Override
    public String getName() {
        return "Sweets Monitor";
    }
    
}
