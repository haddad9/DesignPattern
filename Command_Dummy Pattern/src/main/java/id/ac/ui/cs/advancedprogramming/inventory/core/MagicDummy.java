package id.ac.ui.cs.advancedprogramming.inventory.core;

public class MagicDummy extends Dummy{
    public MagicDummy(float weight, DummyType type, String weapon) {
        super(weight, type, weapon);
    }

    @Override
    public void qualityCheck(){
        dummyLog.add("No weight adjustment");
        dummyLog.add("Training Dummy Activated");
        dummyLog.add(String.format("%s activated", weapon));
        dummyLog.add("Attack");
        dummyLog.add("Buff");

        dummyLog.add("Attack");
        dummyLog.add("Buff");

        dummyLog.add("Buff");


        dummyLog.add("Attack");
        dummyLog.add("Buff");

        dummyLog.add("Defend");
        dummyLog.add("Attack");
        dummyLog.add("Buff");

        dummyLog.add("Defend");


    }
}
