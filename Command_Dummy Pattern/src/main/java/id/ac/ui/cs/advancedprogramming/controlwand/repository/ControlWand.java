package id.ac.ui.cs.advancedprogramming.controlwand.repository;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.spell.MacroSpells;
import id.ac.ui.cs.advancedprogramming.controlwand.core.spell.Spell;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Repository
public class ControlWand {

    final private Map<String, Spell> spells;
    final private Stack<Spell> casted;

    public ControlWand() {
        this.spells = new HashMap<>();
        this.casted = new Stack<>();
    }

    public void registerSpell(Spell spell) {
        spells.put(spell.spellName(), spell);
    }

    public void cast(String spellName) {
        // TODO: Complete Me
        Spell spell  = spells.get(spellName);
        spell.cast();
        casted.add(spell);

    }

    public void undo() {
        // TODO: Complete Me

        if(casted.size()>0){
            casted.pop().undo();
        }
    }

    public Iterable<String> getSpellNames() {
        return spells.keySet();
    }

    public void registerSpells(String name, int spellQuantity){
        Stack<Spell> copy = (Stack<Spell>) casted.clone();
        ArrayList<Spell> spells = new ArrayList<>();
        if(copy.size() >= spellQuantity){

        for (int i = 0; i < spellQuantity; i++) {
            spells.add(copy.pop());

        }

       }
        MacroSpells macro = new MacroSpells(name, spells);
        registerSpell(macro);



    }
}
