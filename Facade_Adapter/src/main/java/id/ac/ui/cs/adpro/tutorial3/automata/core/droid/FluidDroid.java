package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Fluids;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Direction;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Shape;

import java.util.List;

public class FluidDroid extends DroidImpl implements Droid{

    Fluids fluids;
    public FluidDroid( Fluids fluids) {
        super(fluids.getName());
        this.fluids = fluids;
    }

    @Override
    public String liftItem(String item) {
        String res = fluids.pushItem(item, Direction.Up);
        return res;
    }

    @Override
    public String countItem(List<String> inventory, String item) {
        String str = fluids.splitBy(inventory,item);
        int res =Integer.parseInt(str,2);
        fluids.merge();

        return String.format("FluidsDroid found %s %s",res,item);

    }

    @Override
    public String useTransporter() {
        String res = fluids.shapeShift(Shape.Transporter);

        return res ;
    }

    @Override
    public String useCrane() {
        String res = fluids.shapeShift(Shape.Crane);
        return res;
    }

    @Override
    public String getName() {
        return fluids.getName();
    }
}
