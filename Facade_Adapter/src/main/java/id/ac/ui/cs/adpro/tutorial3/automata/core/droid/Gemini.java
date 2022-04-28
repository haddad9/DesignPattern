package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

import java.util.List;

public class Gemini extends DroidImpl implements Droid {

    public Gemini(String name) {
        // TODO: Complete this method
        super(name);
    }

    @Override
    public String liftItem(String item) {
        return String.format("Lifting %s with mechanical arms", item); // TODO: Make this String meaningful
    }

    /**
     * Count numbers of wanted items inside inventory.
     *
     * @param inventory collection of items
     * @param wanted    item to count
     * @return String that describes the count result.
     */
    @Override
    public String countItem(List<String> inventory, String wanted) {
        int count =0;
        for (String inv : inventory) {
            if (wanted.equals(inv)) count++;
        }

        return String.format("Found %s %s",count,wanted); // TODO: Make this String meaningful
    }

    @Override
    public String useTransporter() {
        return "Using Gemini-compatible transporter"; // TODO: Make this String meaningful
    }

    @Override
    public String useCrane() {
        return this.getName() + "Using Gemini-compatible crane"; // TODO: Make this String meaningful
    }

    @Override
    public String getName() {
        return this.name; // TODO: Make this String meaningful
    }

}
