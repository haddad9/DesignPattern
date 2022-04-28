package id.ac.ui.cs.advancedprogramming.inventory.core;

public class MeleeDummy extends Dummy{
    public MeleeDummy(float weight, DummyType type, String weapon) {
        super(weight, type, weapon);
    }

    @Override
    public void qualityCheck(){
        dummyLog.add("Armor increased by 20");
        weight = weight+=20;
        dummyLog.add("Training Dummy Activated");
        dummyLog.add(String.format("%s no need for activation", weapon));
        dummyLog.add("Attack");
        dummyLog.add("Attack");
        dummyLog.add("(Buff) Attack");
        dummyLog.add("Attack");
        dummyLog.add("Defend");
        dummyLog.add("Attack");
        dummyLog.add("Defend");




    }
}
