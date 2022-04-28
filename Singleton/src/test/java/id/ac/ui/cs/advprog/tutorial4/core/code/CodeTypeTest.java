package id.ac.ui.cs.advprog.tutorial4.core.code;

import id.ac.ui.cs.advprog.tutorial4.core.item.ItemType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodeTypeTest {
    Set<String> set = new HashSet<>();

    @BeforeEach
    public void setUp() throws Exception {

        for(CodeType codeType : CodeType.values()){
            set.add(codeType.toString());
        }
    }

    @Test
    public void testCodeTypeHasTwoValues() {
        assertEquals(2, set.size() );
    }

    @Test
    public void testCodeTypeHasMembership() {

        assertTrue(set.contains("GIVEAWAY"));

    }
//,
    @Test
    public void testCodeTypeHasPromo() {
        assertTrue(set.contains("PROMO"));

    }

}
