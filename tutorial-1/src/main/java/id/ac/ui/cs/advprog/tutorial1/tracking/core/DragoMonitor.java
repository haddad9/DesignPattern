package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;
import java.util.List;

public class DragoMonitor implements EventMonitor {
    List<RoadUser> roadUsers = new ArrayList<>();

    @Override
    public void addRoadUser(RoadUser roadUser) {
        // TODO Auto-generated method stub
        roadUsers.add(roadUser);
        
    }

    @Override
    public void notifyRoadUsers(String newDragoLocation) {
        // TODO Auto-generated method stub
        for(RoadUser r: roadUsers){
            r.handleNotification(this.getName(),newDragoLocation);

        }
        
    }

    @Override
    public String getName() {
        return "Drago Monitor";
    }
    
}
