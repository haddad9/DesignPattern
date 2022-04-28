package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;

public class LowManaSpell implements Spell{
    MagicTool tool;

    public LowManaSpell(MagicTool tool){
        this.tool = tool;
    }

    @Override
    public void cast() {
        tool.low();

    }

    @Override
    public void undo() {
        tool.undo();

    }

    @Override
    public String spellName() {
        return String.format("%s:LOW",tool.getName());
    }
}
