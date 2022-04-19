package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.List;

public interface CourierBehaviour {
    List<String> selectRoutes(String from, String location, List<String> allRoutes, List<String> allowedRoutes);

}
