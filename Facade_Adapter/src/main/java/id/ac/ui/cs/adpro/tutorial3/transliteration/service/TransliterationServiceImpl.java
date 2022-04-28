package id.ac.ui.cs.adpro.tutorial3.transliteration.service;


import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Aeron;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Latin;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.tools.*;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.util.Spell;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransliterationServiceImpl implements TransliterationService {

    private boolean recentRequestType;
    private String recentRequestValue;

    private Cipher cipher;
    private Joiner joinerAeron;
    private Joiner joinerLatin;
    private LinguaTranslator translator;
    private Parser parserLatin;
    private Parser parserAeron;
    private Shifter shifter;

    public TransliterationServiceImpl() {
        // TODO: complete this constructor
        cipher = new Cipher();
        shifter = new Shifter();
        translator = new LinguaTranslator();
        joinerAeron =new Joiner(Aeron.getInstance());
        joinerLatin = new Joiner(Latin.getInstance());
        parserAeron = new Parser(Aeron.getInstance());
        parserLatin =new Parser( Latin.getInstance());




    }

    @Override
    public String encode(String text) {
        // TODO: complete this method
        List<Spell> spells =  parserLatin.parseSentence(text);
        List<Spell> newSpells = new ArrayList<>();
        for(Spell spell: spells){
            spell = translator.translate(spell, Aeron.getInstance());
            spell = shifter.shift(spell, -3);
            spell = cipher.encode(spell);
            newSpells.add(spell);

        }

        String res = joinerAeron.join(newSpells);
        return res;
    }

    @Override
    public String decode(String code) {
        // TODO: complete this method
        List<Spell> spells =  parserAeron.parseSentence(code);
        List<Spell> newSpells = new ArrayList<>();
        for(Spell spell: spells){
            spell = cipher.decode(spell);
            spell = shifter.shift(spell, 3);
            spell = translator.translate(spell, Latin.getInstance());
            newSpells.add(spell);
      }


            String res = joinerLatin.join(newSpells);


        return res;
    }

    @Override
    public void setRequestType(String requestType) {
        this.recentRequestType = requestType.equals("encode");
    }

    @Override
    public boolean isRequestEncode() {
        return recentRequestType;
    }

    @Override
    public String getRequestValue() {
        return recentRequestValue;
    }

    @Override
    public void setRequestValue(String requestValue) {
        recentRequestValue = requestValue;
    }

    @Override
    public String processAeronCipher(String text, String type) {

        Cipher c = new Cipher();
        Spell s = new Spell(text, Aeron.getInstance());
        if(type.equals("encode")) {
            return c.encode(s).getText();
        } else {
            return c.decode(s).getText();
        }
    }

    @Override
    public String processAeronShifter(String text, int shift) {
        Shifter shifter = new Shifter();
        Spell s = new Spell(text, Aeron.getInstance());
        return shifter.shift(s, shift).getText();
    }

}
