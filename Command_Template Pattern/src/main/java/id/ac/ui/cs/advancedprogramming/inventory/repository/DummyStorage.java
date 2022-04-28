package id.ac.ui.cs.advancedprogramming.inventory.repository;

import id.ac.ui.cs.advancedprogramming.inventory.core.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DummyStorage {
    final private List<Dummy> dummies;

    public DummyStorage() { dummies = new ArrayList<>(); }

    public List<Dummy> getDummies() { return dummies; }

    public void createDummy(float weight, DummyType type, String weapon) {
        Dummy dummy = null;

        // TODO: Complete Me
        switch (type){
            case MAGIC:
                dummy = new MagicDummy(weight,type,weapon);
                break;
            case RANGED:
                dummy = new RangeDummy(weight,type,weapon);
                break;
            case MELEE:
                dummy = new MeleeDummy(weight,type,weapon);
                break;
        }
        dummies.add(dummy);



    }

    public void removeDummy(int index) {
        dummies.remove(index);
    }

    public Dummy getDummy(int index) {
        return dummies.get(index);
    }
}
