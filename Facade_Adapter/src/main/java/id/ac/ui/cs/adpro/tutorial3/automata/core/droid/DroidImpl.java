package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

public abstract class DroidImpl implements Droid {
    String name;

    public DroidImpl(String name) {
        this.name =name;
    }

    @Override
    public String getType() {
        return "Droid";
    }
}
