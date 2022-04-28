package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.Familiar;

public class SummonSpell implements Spell{
    Familiar familiar;

    public SummonSpell(Familiar familiar){
        this.familiar = familiar;
    }

    @Override
    public void cast() {
        familiar.summon();

    }

    @Override
    public void undo() {
        familiar.undo();

    }

    @Override
    public String spellName() {
        return String.format("%s:SUMMONED", familiar.getName() );
    }
}
