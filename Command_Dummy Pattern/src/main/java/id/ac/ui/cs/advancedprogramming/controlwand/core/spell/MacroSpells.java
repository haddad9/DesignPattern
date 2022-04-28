package id.ac.ui.cs.advancedprogramming.controlwand.core.spell;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.Familiar;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;

import java.util.ArrayList;

public class MacroSpells implements Spell{
    String name;
    ArrayList<Spell> spells;




    public MacroSpells(String name, ArrayList<Spell> spells){
        this.name = name;
        this.spells = spells;

    }

    @Override
    public void cast() {
        for (Spell spell :
                spells) {
            spell.cast();
            
        }
        



    }

    @Override
    public void undo() {
        for (Spell spell :
                spells) {
            spell.undo();
        }

    }

    @Override
    public String spellName() {
        return this.name;
    }
}
