package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.Golem;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Punchable;

import java.util.Arrays;
import java.util.List;

public class GolemDroid extends DroidImpl implements Droid{
    Golem golem;


    public GolemDroid(Golem golem) {
        super(golem.getName());
        this.golem = golem;
    }

    @Override
    public String liftItem(String item) {
        String res = golem.liftItem(item);
        return res;
    }

    @Override
    public String countItem(List<String> inventory, String item) {
        int count = 0;
        for (String inv : inventory) {
            String str = golem.isItem(item,inv);
            boolean contains = Arrays.stream(str.split(" ")).anyMatch("not"::equals);
            if(!contains){
                count++;
            }
        }

        return String.format("GolemDroid found %s %s",count,item);
    }

    @Override
    public String useTransporter() {
        return golem.toss("item");
    }

    @Override
    public String useCrane() {
        String res = golem.punch(Punchable.CraneLever);

        return res;
    }

    @Override
    public String getName() {
        return golem.getName();
    }
}
