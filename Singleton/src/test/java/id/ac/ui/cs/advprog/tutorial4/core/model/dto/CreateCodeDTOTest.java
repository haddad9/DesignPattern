package id.ac.ui.cs.advprog.tutorial4.core.model.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateCodeDTOTest {
    private Class<?> createCodeDTOClass;
    @BeforeEach
    public void setUp() throws Exception {
        createCodeDTOClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.model.dto.CreateCodeDTO");

    }

    @Test
    public void testCreateCodeDTOIsNotAbstractClass() {
        assertFalse(Modifier.isAbstract(createCodeDTOClass.getModifiers()));


    }

    @Test
    public void testCreateCodeDTOIsPublic() {
        int classModifiers = createCodeDTOClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));

    }


}
