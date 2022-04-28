package id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntityState;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class MagicTool extends MagicalEntity {


    public MagicTool(String name) {
        super(name);
        currentState = ManaIntensity.NONE;
        this.stateHistory = new ArrayList<>();

    }

    @Override
    protected String defineState(MagicalEntityState state) {
        return this.name + "'s mana intensity has been set to " + state.toString();
    }

    public void off() {
        // TODO: Complete Me
        if(!currentState.equals(ManaIntensity.NONE)) {
            prevState = currentState;
            currentState = ManaIntensity.NONE;
            stateHistory.add(ManaIntensity.NONE);
        }
    }

    public void low() {
        // TODO: Complete Me
        if(!currentState.equals(ManaIntensity.LOW)) {
            prevState = currentState;
            currentState = ManaIntensity.LOW;
            stateHistory.add(ManaIntensity.LOW);
        }
    }

    public void medium() {
        // TODO: Complete Me
        if(!currentState.equals(ManaIntensity.MEDIUM)) {
            prevState = currentState;
            currentState = ManaIntensity.MEDIUM;
            stateHistory.add(ManaIntensity.MEDIUM);
        }
    }

    public void high() {
        // TODO: Complete Me
        if(!currentState.equals(ManaIntensity.HIGH)) {
            prevState = currentState;
            currentState = ManaIntensity.HIGH;
            stateHistory.add(ManaIntensity.HIGH);
        }
    }

    public ManaIntensity getPrev(){
        return (ManaIntensity) prevState;
    }

    @Override
    public void undo(){
        if(!prevState.equals(null)) {
            switch ((ManaIntensity)prevState) {
                case HIGH:
                    high();
                    break;
                case LOW:
                    low();
                    break;
                case MEDIUM:
                    medium();
                    break;
                default:
                    off();


            }
        }

    }
}
