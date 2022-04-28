package id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.ManaIntensity;

import java.util.ArrayList;
import java.util.LinkedList;

public class Familiar extends MagicalEntity {





    public Familiar(String name) {
        super(name);
        currentState = FamiliarState.SEALED;
        this.stateHistory = new ArrayList<>();

    }

    @Override
    protected String defineState(MagicalEntityState state) {
        return this.name + " is " + state.toString();
    }

    public void seal() {
        // TODO: Complete Me
        if(!currentState.equals(FamiliarState.SEALED)) {
            prevState = currentState;
            currentState = FamiliarState.SEALED;
            stateHistory.add(FamiliarState.SEALED);
        }

    }

    public void summon() {
        // TODO: Complete Me
        if(!currentState.equals(FamiliarState.SUMMONED)){
            prevState = currentState;
            stateHistory.add(FamiliarState.SUMMONED);
            currentState = FamiliarState.SUMMONED;

        }

    }

    public FamiliarState getPrev(){
        return (FamiliarState) this.prevState;
    }

    @Override
    public void undo(){
        if(!prevState.equals(null)) {
            switch ((FamiliarState)prevState) {
                case SEALED:
                    seal();
                    break;
                case SUMMONED:
                    summon();
                    break;

            }
        }
    }

}
