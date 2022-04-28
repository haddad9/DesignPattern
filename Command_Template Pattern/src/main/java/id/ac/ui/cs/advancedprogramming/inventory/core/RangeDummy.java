package id.ac.ui.cs.advancedprogramming.inventory.core;

public class RangeDummy extends Dummy{
    public RangeDummy(float weight, DummyType type, String weapon) {
        super(weight, type, weapon);
    }
    @Override
    public void qualityCheck(){
        dummyLog.add("Weight decreased by 20%");
        weight= (float) (weight*0.8);
        dummyLog.add("Training Dummy Activated");
        dummyLog.add(String.format("%s activated", weapon));
        dummyLog.add("Attack");
        dummyLog.add("Attack");
        dummyLog.add("Buff");
        dummyLog.add("Attack");
        dummyLog.add("Failed, can't defend");
        dummyLog.add("Attack");
        dummyLog.add("Failed, can't defend");


    }
}
