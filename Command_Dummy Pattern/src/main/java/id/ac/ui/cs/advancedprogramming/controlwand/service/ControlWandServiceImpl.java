package id.ac.ui.cs.advancedprogramming.controlwand.service;

import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.MagicalEntity;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.familiar.Familiar;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.MagicTool;
import id.ac.ui.cs.advancedprogramming.controlwand.core.entity.magictool.ManaIntensity;

import id.ac.ui.cs.advancedprogramming.controlwand.core.spell.*;
import id.ac.ui.cs.advancedprogramming.controlwand.repository.ControlWand;
import id.ac.ui.cs.advancedprogramming.controlwand.repository.EntityCollection;
import org.springframework.stereotype.Service;

import java.util.EnumSet;

@Service
public class ControlWandServiceImpl implements ControlWandService {
    private final ControlWand controlWand;
    private final EntityCollection entities;

    public ControlWandServiceImpl(ControlWand controlWand, EntityCollection entities) {
        this.controlWand = controlWand;
        this.entities = entities;
    }

    @Override
    public void castSpell(String spellName) {
        controlWand.cast(spellName);
    }

    @Override
    public void undoSpell() {
        controlWand.undo();
    }

    @Override
    public Iterable<String> getSpellNames() {
        return controlWand.getSpellNames();
    }

    @Override
    public Iterable<MagicalEntity> getMagicalEntities() {
        return entities.getMagicalEntities();
    }

    @Override
    public void contractFamiliar(String name) {
        // TODO: Register spells
        Familiar familiar = new Familiar(name);
        entities.registerEntity(familiar);
        Spell seal = new SealSpell(familiar);
        Spell summon = new SummonSpell(familiar);
        controlWand.registerSpell(seal);
        controlWand.registerSpell(summon);





    }

    @Override
    public void buyMagicTool(String name, EnumSet<ManaIntensity> requiredSpells) {

        // TODO: Register spells
        if(requiredSpells.size() != 0) { //if null do nothing
            MagicTool tool = new MagicTool(name);
            entities.registerEntity(tool);


            for (ManaIntensity mana : requiredSpells) {

                    if(mana.equals(ManaIntensity.LOW)) {
                        Spell low = new LowManaSpell(tool);
                        controlWand.registerSpell(low);
                    }
                    else if (mana.equals(ManaIntensity.HIGH)){
                    Spell high = new HighManaSpell(tool);
                    controlWand.registerSpell(high);
                    }


                    else if(mana.equals(ManaIntensity.MEDIUM)){
                    Spell medium = new MediumManaSpell(tool);
                    controlWand.registerSpell(medium);
                }
                Spell none = new NoneManaSpell(tool);
                controlWand.registerSpell(none);





            }
        }


    }

    @Override
    public void registerSpells(String name, int spellQuantity) {
        controlWand.registerSpells(name, spellQuantity);

    }
}
