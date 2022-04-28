package id.ac.ui.cs.advprog.tutorial4.core.model.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RedeemCodeDTOTest {
    private Class<?> redeemCodeDTOClass;
    @BeforeEach
    public void setUp() throws Exception {
        redeemCodeDTOClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.model.dto.RedeemCodeDTO");

    }

    @Test
    public void testCreateCodeDTOIsNotAbstractClass() {
        assertFalse(Modifier.isAbstract(redeemCodeDTOClass.getModifiers()));


    }

    @Test
    public void testCreateCodeDTOIsPublic() {
        int classModifiers = redeemCodeDTOClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));

    }
}
