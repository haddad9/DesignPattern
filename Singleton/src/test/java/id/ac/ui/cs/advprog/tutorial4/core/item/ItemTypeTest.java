package id.ac.ui.cs.advprog.tutorial4.core.item;

import org.easymock.Mock;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemTypeTest {



    @Test
    public void testItemTypeHasTwoValues() {
        assertEquals(2, ItemType.values().length );
    }

    @Test
    public void testItemTypeHasMembership() {
        Set<String> set = new HashSet<>();
        for(ItemType itemType : ItemType.values()){
            set.add(itemType.toString());
        }
        assertTrue(set.contains("MEMBERSHIP"));

    }

    @Test
    public void testItemTypeHasMerch() {
        Set<String> set = new HashSet<>();
        for(ItemType itemType : ItemType.values()){
            set.add(itemType.toString());
        }
        assertTrue(set.contains("MERCH"));

    }



}
