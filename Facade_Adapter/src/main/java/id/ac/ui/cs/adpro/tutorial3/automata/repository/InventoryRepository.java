package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public interface InventoryRepository {

    List<String> fetchInventory();

    Set<String> getUnique();

    void addUnique(String item);

    void addItem(String item);
}
