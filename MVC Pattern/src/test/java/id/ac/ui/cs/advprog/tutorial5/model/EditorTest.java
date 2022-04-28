package id.ac.ui.cs.advprog.tutorial5.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditorTest {

    private Class<?> EditorClass;

    @BeforeEach
    public void setUp() throws Exception {
        EditorClass = Class
                .forName("id.ac.ui.cs.advprog.tutorial5.model.Editor");
    }

    @Test
    public void editorIsAPublicClass() {
        int classModifiers = EditorClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));

    }

    @Test
    public void testEditorIsNotAbstractClass() {
        assertFalse(Modifier.isAbstract(EditorClass.getModifiers()));
    }

    @Test
    public void testEditorGetNumArticlesReturnsValidValue(){
        Editor EditorMock = Mockito.mock(
                Editor.class,
                Mockito.withSettings()
                        .useConstructor("name","email",1 )
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));

        assertTrue(EditorMock.getWrittenArticles() == 1);
    }

    @Test
    public void testEditorGetEmailReturnsValidValue(){
        Editor EditorMock = Mockito.mock(
                Editor.class,
                Mockito.withSettings()
                        .useConstructor("name","email",1 )
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));

        assertTrue(EditorMock.getEmail().equals("email"));
    }

    @Test
    public void testEditorGetNameReturnsValidValue(){
        Editor EditorMock = Mockito.mock(
                Editor.class,
                Mockito.withSettings()
                        .useConstructor("name","email",1 )
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));
        assertTrue(EditorMock.getName().equals("name"));
    }

    @Test
    public void testGetArticlesReturnsValidSet(){
        Editor EditorMock = Mockito.mock(
                Editor.class,
                Mockito.withSettings()
                        .useConstructor("name","email",1 )
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));
        Set<Article> set = new HashSet<>();
        EditorMock.setArticles(set);


        assertTrue(EditorMock.getArticles().equals(set));

    }

    @Test
    public void testGetArticlesReturnsValidSize(){
        Editor EditorMock = Mockito.mock(
                Editor.class,
                Mockito.withSettings()
                        .useConstructor("name","email",1 )
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));
        Set<Article> set = new HashSet<>();
        EditorMock.setArticles(set);
        assertTrue(EditorMock.getArticles().size() == 0 );
    }

    @Test
    public void testEditorGetIdReturnsValidValue(){
        Editor EditorMock = Mockito.mock(
                Editor.class,
                Mockito.withSettings()
                        .useConstructor("name","email",1 )
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));
        EditorMock.setId(1);
        assertTrue(EditorMock.getId() == 1);
    }
}
