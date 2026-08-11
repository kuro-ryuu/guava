package src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTest {

    @Test
    void testConcatenate() {
        StringManipulator sm = new StringManipulator();

        assertEquals("HelloWorld", sm.concatenate("Hello", "World"));
    }

    @Test
    void testFindLength() {
        StringManipulator sm = new StringManipulator();

        assertEquals(5, sm.findLength("Hello"));
    }

    @Test
    void testConvertToUpperCase() {
        StringManipulator sm = new StringManipulator();

        assertEquals("HELLO WORLD", sm.convertToUpperCase("Hello World"));
    }

    @Test
    void testConvertToLowerCase() {
        StringManipulator sm = new StringManipulator();

        assertEquals("hello world", sm.convertToLowerCase("Hello World"));
    }

    @Test
    void testContainsSubstring() {
        StringManipulator sm = new StringManipulator();

        assertTrue(sm.containsSubstring("Hello World", "World"));
        assertFalse(sm.containsSubstring("Hello World", "Java"));
    }
}