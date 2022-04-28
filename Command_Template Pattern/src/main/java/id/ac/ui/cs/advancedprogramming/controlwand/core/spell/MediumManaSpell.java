package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;

public class MediumManaSpell implements Spell{
    MagicTool tool;

    public MediumManaSpell(MagicTool tool){
        this.tool = tool;
    }

    @Override
    public void cast() {
        tool.medium();
    }

    @Override
    public void undo() {
      tool.undo();
    }

    @Override
    public String spellName() {
        return String.format("%s:MEDIUM",tool.getName());
    }
}
