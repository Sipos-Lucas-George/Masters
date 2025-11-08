import static org.junit.Assert.*;

import org.junit.Test;

public class TestPerson {
    private Person male;
    private Person female;

    @Test
    public void testConstructorWrongInputLetter() {
        try {
            new Person('A');
            fail("Should thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotEquals(e.getMessage().trim(), "");
        }
    }

    @Test
    public void testConstructorWrongInputSymbol() {
        try {
            new Person('-');
            fail("Should thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotEquals(e.getMessage().trim(), "");
        }
    }

    @Test
    public void testInputGetGenderLowercase() {
        male = new Person('m');
        female = new Person('w');
        assertEquals(female.getGender(), Gender.FEMALE);
        assertEquals(male.getGender(), Gender.MALE);
        assertNotEquals(male.getGender(), female.getGender());
    }

    @Test
    public void testInputGetGenderSymbolLowercase() {
        male = new Person('m');
        female = new Person('w');
        assertEquals(female.getGenderSymbol(), 'W');
        assertEquals(male.getGenderSymbol(), 'M');
        assertNotEquals(male.getGenderSymbol(), female.getGenderSymbol());
    }

    @Test
    public void testGetGenderUppercase() {
        male = new Person('M');
        female = new Person('W');
        assertEquals(male.getGender(), Gender.MALE);
        assertEquals(female.getGender(), Gender.FEMALE);
        assertNotEquals(male.getGender(), female.getGender());
    }

    @Test
    public void testGetGenderSymbolUppercase() {
        male = new Person('M');
        female = new Person('W');
        assertEquals(male.getGenderSymbol(), 'M');
        assertEquals(female.getGenderSymbol(), 'W');
        assertNotEquals(male.getGenderSymbol(), female.getGenderSymbol());
    }
}
