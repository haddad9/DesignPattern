package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;

public class HighManaSpell implements  Spell{
    MagicTool tool;

    public HighManaSpell(MagicTool tool){
        this.tool = tool;
    }

    @Override
    public void cast() {
        tool.high();
    }

    @Override
    public void undo() {
        tool.undo();

    }

    @Override
    public String spellName() {
        return String.format("%s:HIGH",tool.getName());
    }
}
