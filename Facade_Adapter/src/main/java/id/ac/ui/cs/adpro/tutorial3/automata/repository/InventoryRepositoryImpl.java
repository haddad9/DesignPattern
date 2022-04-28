package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class InventoryRepositoryImpl implements InventoryRepository {

    private List<String> inventory = new ArrayList<>();
    private Set<String> invUnique   = new HashSet<>();

    @Override
    public List<String> fetchInventory() {
        return inventory;
    }

    @Override
    public Set<String> getUnique() {
        return invUnique;
    }

    @Override
    public void addUnique(String item) {

    }

    @Override
    public void addItem(String item) {
        inventory.add(item);
    }


}
