package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;

public class NoneManaSpell implements  Spell{
    MagicTool tool;
    public NoneManaSpell(MagicTool tool){
        this.tool = tool;

    }
    @Override
    public void cast() {
        tool.off();


    }

    @Override
    public void undo() {
        tool.undo();

    }

    @Override
    public String spellName() {
        return String.format("%s:NONE",tool.getName());
    }
}
