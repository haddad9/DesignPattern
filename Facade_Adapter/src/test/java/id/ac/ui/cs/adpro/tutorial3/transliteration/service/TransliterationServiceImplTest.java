package id.ac.ui.cs.adpro.tutorial3.transliteration.service;


import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Aeron;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.lingua.Latin;
import id.ac.ui.cs.adpro.tutorial3.transliteration.core.util.Spell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransliterationServiceImplTest {

    TransliterationServiceImpl service = new TransliterationServiceImpl();

        Latin latin = Latin.getInstance();
        Aeron aeron = Aeron.getInstance();

        @Test
        public void testServiceEncode() {

            Spell s = new Spell("AKU cinta magic", latin);
            assertEquals("=ib0%ZCS_0SCHZM", service.encode(s.getText()));

        }

        @Test
        public void testCipherDecode() {
            Spell s = new Spell("=ib0%ZCS_0SCHZM", aeron);
            assertEquals("AKU cinta magic", service.decode(s.getText()));
        }
}
