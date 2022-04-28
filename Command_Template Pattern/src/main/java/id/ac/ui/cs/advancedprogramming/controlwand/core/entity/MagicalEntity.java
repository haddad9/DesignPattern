package id.ac.ui.cs.advancedprogramming.controlwand.core.entity;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.ManaIntensity;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public abstract class MagicalEntity {
    protected String name;
    protected MagicalEntityState currentState;
    protected List<MagicalEntityState> stateHistory;
    protected MagicalEntityState prevState = null;




    public MagicalEntity(String name) {
        this.name = name;
    }

    protected abstract String defineState(MagicalEntityState state);

    public String getName() {
        return name;
    }

    public MagicalEntityState getCurrentState() {
        return currentState;
    }

    public List<String> getLifeArchive() {
        return stateHistory.stream().map(this::defineState).collect(Collectors.toList());
    }

    public void undo() {
        // TODO: Complete Me
        // overriden by concrete class


    }


}
